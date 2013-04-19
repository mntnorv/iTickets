package kestar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kestar.data.AgeGroup;
import kestar.data.Client;
import kestar.data.SocialGroup;
import kestar.data.Vehicle;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataHelper {
	private static final Map<Class<?>, String> CLASS_MAP = new HashMap<Class<?>, String>();
	
	private JsonFactory factory;
	private ObjectMapper mapper;
	
	private List<AgeGroup> ageGroups;
	private List<SocialGroup> socialGroups;
	private List<Client> clients;
	private List<Vehicle> vehicles;
	private String dataFileName;
	
	public DataHelper(String dataFileName) {
		this.dataFileName = dataFileName;
		
		factory = new JsonFactory();
		mapper = new ObjectMapper();
	}
	
	static {
		CLASS_MAP.put(AgeGroup.class, "ageGroups");
		CLASS_MAP.put(SocialGroup.class, "socGroups");
		CLASS_MAP.put(Client.class, "clients");
		CLASS_MAP.put(Vehicle.class, "vehicles");
	}
	
	//================================================================================
	// Getters
	//================================================================================
	public List<AgeGroup> getAgeGroups() {
		return ageGroups;
	}

	public List<SocialGroup> getSocialGroups() {
		return socialGroups;
	}

	public List<Client> getClients() {
		return clients;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	//================================================================================
	// Read methods
	//================================================================================
	public void readData() {
		try {
			JsonParser parser = factory.createJsonParser(new File(dataFileName));
			
			parser.nextToken();
			
			while (parser.nextToken() != JsonToken.END_OBJECT) {
				String fieldName = parser.getCurrentName();
				parser.nextToken();
				if (CLASS_MAP.get(AgeGroup.class).equals(fieldName)) {
					ageGroups = readArray(parser, mapper, AgeGroup.class);
				} else if (CLASS_MAP.get(SocialGroup.class).equals(fieldName)) {
					socialGroups = readArray(parser, mapper, SocialGroup.class);
				} else if (CLASS_MAP.get(Client.class).equals(fieldName)) {
					clients = readArray(parser, mapper, Client.class);
				} else if (CLASS_MAP.get(Vehicle.class).equals(fieldName)) {
					vehicles = readArray(parser, mapper, Vehicle.class);
				}
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
	
	private <T> List<T> readArray(JsonParser parser, ObjectMapper mapper, Class<T> type)
			throws JsonParseException, JsonMappingException, IOException {
		
		List<T> list = new ArrayList<T>();
		while (parser.nextToken() == JsonToken.START_OBJECT) {
			T item = mapper.readValue(parser, type);
			list.add(item);
		}
		return list;
	}
}
