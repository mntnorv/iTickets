package kestar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kestar.data.Client;
import kestar.data.Discount;
import kestar.data.SocialGroup;
import kestar.data.TransportTimeLimit;
import kestar.data.Vehicle;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
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
	
	private Map<String, String> classFileMap;
	
	public DataHelper() {
		factory = new JsonFactory();
		mapper = new ObjectMapper();
		
		classFileMap = new HashMap<String, String>();
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
	public void readData(List<String> fileNames) {
		try {
			for(String fileName: fileNames) {
				readDataFromFile(fileName);
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
	
	private void readDataFromFile(String fileName) throws JsonParseException, IOException {
		JsonParser parser = factory.createJsonParser(new File(fileName));
		
		parser.nextToken();
		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = parser.getCurrentName();
			parser.nextToken();
			if ("socGroups".equals(fieldName)) {
				classFileMap.put("socGroups", fileName);
				socialGroups = readArray(parser, mapper, SocialGroup.class);
			} else if ("clients".equals(fieldName)) {
				classFileMap.put("clients", fileName);
				clients = readArray(parser, mapper, Client.class);
			} else if ("vehicles".equals(fieldName)) {
				classFileMap.put("vehicles", fileName);
				vehicles = readArray(parser, mapper, Vehicle.class);
			} else if ("vehicleTypes".equals(fieldName)) {
				classFileMap.put("vehicleTypes", fileName);
				vehicleTypes = mapper.readValue(parser, new TypeReference<List<String>>(){});
			} else if ("timeLimits".equals(fieldName)) {
				classFileMap.put("timeLimits", fileName);
				timeLimits = readListMap(parser, mapper, TransportTimeLimit.class);
			} else if ("discounts".equals(fieldName)) {
				classFileMap.put("discounts", fileName);
				discounts = readListMap(parser, mapper, Discount.class);
			} else {
				parser.skipChildren();
			}
		}
		parser.close();
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
			JsonGenerator generator = factory.createJsonGenerator(new File("data/test"), JsonEncoding.UTF8);
			generator.writeStartObject();
			
			/*generator.writeFieldName(ARRAY_CLASS_MAP.get(SocialGroup.class));
			mapper.writeValue(generator, socialGroups);
			
			generator.writeFieldName(ARRAY_CLASS_MAP.get(VehicleType.class));
			mapper.writeValue(generator, vehicleTypes);
			
			generator.writeFieldName(ARRAY_CLASS_MAP.get(Client.class));
			mapper.writeValue(generator, clients);
			
			generator.writeFieldName(ARRAY_CLASS_MAP.get(Vehicle.class));
			mapper.writeValue(generator, vehicles);*/
			
			generator.writeEndObject();
			generator.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
