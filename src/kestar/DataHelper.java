package kestar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kestar.data.AgeGroup;
import kestar.data.Client;
import kestar.data.SocialGroup;
import kestar.data.Vehicle;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataHelper {
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
	
	public void readData() {
		try {
			JsonParser parser = factory.createJsonParser(new File(dataFileName));
			
			parser.nextToken();
			
			while (parser.nextToken() != JsonToken.END_OBJECT) {
				String fieldName = parser.getCurrentName();
				parser.nextToken();
				if ("ageGroups".equals(fieldName)) {
					ageGroups = readAgeGroups(parser, mapper);
				} else if ("socGroups".equals(fieldName)) {
					socialGroups = readSocialGroups(parser, mapper);
				} else if ("clients".equals(fieldName)) {
					clients = readClients(parser, mapper);
				} else if ("vehicles".equals(fieldName)) {
					vehicles = readVehicles(parser, mapper);
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

	private List<AgeGroup> readAgeGroups(JsonParser parser, ObjectMapper mapper)
			throws JsonParseException, JsonMappingException, IOException {
		
		List<AgeGroup> groups = new ArrayList<AgeGroup>();
		while (parser.nextToken() == JsonToken.START_OBJECT) {
			AgeGroup group = mapper.readValue(parser, AgeGroup.class);
			groups.add(group);
		}
		return groups;
	}
	
	private List<SocialGroup> readSocialGroups(JsonParser parser, ObjectMapper mapper)
			throws JsonParseException, JsonMappingException, IOException {
		
		List<SocialGroup> groups = new ArrayList<SocialGroup>();
		while (parser.nextToken() == JsonToken.START_OBJECT) {
			SocialGroup group = mapper.readValue(parser, SocialGroup.class);
			groups.add(group);
		}
		return groups;
	}
	
	private List<Client> readClients(JsonParser parser, ObjectMapper mapper)
			throws JsonParseException, JsonMappingException, IOException {
		
		List<Client> clients = new ArrayList<Client>();
		while (parser.nextToken() == JsonToken.START_OBJECT) {
			Client client = mapper.readValue(parser, Client.class);
			clients.add(client);
		}
		return clients;
	}
	
	private List<Vehicle> readVehicles(JsonParser parser, ObjectMapper mapper)
			throws JsonParseException, JsonMappingException, IOException {
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		while (parser.nextToken() == JsonToken.START_OBJECT) {
			Vehicle vehicle = mapper.readValue(parser, Vehicle.class);
			vehicles.add(vehicle);
		}
		return vehicles;
	}
}
