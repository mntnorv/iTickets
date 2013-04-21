package kestar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kestar.data.Client;
import kestar.data.Discount;
import kestar.data.SocialGroup;
import kestar.data.TransportTimeLimit;
import kestar.data.Vehicle;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataHelper {
	private JsonFactory factory;
	private ObjectMapper mapper;
	
	private List<SocialGroup> socialGroups;
	private List<Client> clients;
	private List<Vehicle> vehicles;
	private List<String> vehicleTypes;
	private Map<String, List<TransportTimeLimit>> timeLimits;
	private Map<String, List<Discount>> discounts;
	
	private Map<File, List<String>> classFileMap;
	
	public DataHelper() {
		factory = new JsonFactory();
		mapper = new ObjectMapper();
		
		classFileMap = new HashMap<File, List<String>>();
	}
	
	//================================================================================
	// Getters
	//================================================================================
	public List<SocialGroup> getSocialGroups() {
		return socialGroups;
	}

	public List<Client> getClients() {
		return clients;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public List<String> getVehicleTypes() {
		return vehicleTypes;
	}

	public Map<String, List<TransportTimeLimit>> getTimeLimits() {
		return timeLimits;
	}

	public Map<String, List<Discount>> getDiscounts() {
		return discounts;
	}

	//================================================================================
	// Read methods
	//================================================================================
	public void readData(List<File> files) {
		try {
			for(File file: files) {
				readDataFromFile(file);
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readDataFromFile(File file) throws JsonParseException, IOException {
		JsonParser parser = factory.createJsonParser(file);
		
		parser.nextToken();
		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = parser.getCurrentName();
			parser.nextToken();
			if ("socGroups".equals(fieldName)) {
				addToClassFileMap("socGroups", file);
				socialGroups = readArray(parser, mapper, SocialGroup.class);
			} else if ("clients".equals(fieldName)) {
				addToClassFileMap("clients", file);
				clients = readArray(parser, mapper, Client.class);
			} else if ("vehicles".equals(fieldName)) {
				addToClassFileMap("vehicles", file);
				vehicles = readArray(parser, mapper, Vehicle.class);
			} else if ("vehicleTypes".equals(fieldName)) {
				addToClassFileMap("vehicleTypes", file);
				vehicleTypes = mapper.readValue(parser, new TypeReference<List<String>>(){});
			} else if ("timeLimits".equals(fieldName)) {
				addToClassFileMap("timeLimits", file);
				timeLimits = readListMap(parser, mapper, TransportTimeLimit.class);
			} else if ("discounts".equals(fieldName)) {
				addToClassFileMap("discounts", file);
				discounts = readListMap(parser, mapper, Discount.class);
			} else {
				parser.skipChildren();
			}
		}
		
		parser.close();
	}
	
	private void addToClassFileMap(String className, File file) {
		if (!classFileMap.containsKey(file)) {
			classFileMap.put(file, new LinkedList<String>());
		}
		
		classFileMap.get(file).add(className);
	}
	
	private <T> List<T> readArray(JsonParser parser, ObjectMapper mapper, Class<T> type)
			throws JsonParseException, JsonMappingException, IOException {
		
		List<T> list = new ArrayList<T>();
		while (parser.nextToken() == JsonToken.START_OBJECT) {
			T item = mapper.readValue(parser, type);
			list.add(item);
		}
		return list;
	}
	
	private <TValue> Map<String, List<TValue>> readListMap(JsonParser parser, ObjectMapper mapper,
			Class<TValue> valueType) throws JsonParseException, JsonMappingException, IOException {
		Map<String, List<TValue>> map = new HashMap<String, List<TValue>>();
		
		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = parser.getCurrentName();
			parser.nextToken();
			map.put(fieldName, readArray(parser, mapper, valueType));
		}
		
		return map;
	}
	
	//================================================================================
	// Write methods
	//================================================================================
	public void writeData() {
		try {
			for (Map.Entry<File, List<String>> fileNameEntry: classFileMap.entrySet()) {
				List<String> fieldNames = fileNameEntry.getValue();
				File file = fileNameEntry.getKey();
				
				JsonGenerator generator = factory.createJsonGenerator(file, JsonEncoding.UTF8);
				generator.writeStartObject();
				
				for (String fieldName: fieldNames) {
					generator.writeFieldName(fieldName);
					if ("socGroups".equals(fieldName)) {
						mapper.writeValue(generator, socialGroups);
					} else if ("clients".equals(fieldName)) {
						mapper.writeValue(generator, clients);
					} else if ("vehicles".equals(fieldName)) {
						mapper.writeValue(generator, vehicles);
					} else if ("vehicleTypes".equals(fieldName)) {
						mapper.writeValue(generator, vehicleTypes);
					} else if ("timeLimits".equals(fieldName)) {
						mapper.writeValue(generator, timeLimits);
					} else if ("discounts".equals(fieldName)) {
						//mapper.writeValue(generator, discounts);
						writeListMap(discounts, generator, mapper);
					}
				}
				
				generator.writeEndObject();
				generator.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private <TValue> void writeListMap(Map<String, List<TValue>> map, JsonGenerator generator,
			ObjectMapper mapper) throws JsonGenerationException, IOException {
		generator.writeStartObject();
		for (Map.Entry<String, List<TValue>> entry: map.entrySet()) {
			generator.writeArrayFieldStart(entry.getKey());
			for (TValue listValue: entry.getValue()) {
				mapper.writeValue(generator, listValue);
			}
			generator.writeEndArray();
		}
		generator.writeEndObject();
	}
}
