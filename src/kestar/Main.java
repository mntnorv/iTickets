package kestar;

import java.util.List;

import kestar.data.AgeGroup;
import kestar.data.Client;
import kestar.data.SocialGroup;
import kestar.data.Vehicle;

public class Main {
	public static void main(String [ ] args) {
		DataHelper dataHelper = new DataHelper("itickets_data");
		dataHelper.readData();
		
		List<AgeGroup> ageGroups = dataHelper.getAgeGroups();
		List<SocialGroup> socialGroups = dataHelper.getSocialGroups();
		List<Client> clients = dataHelper.getClients();
		List<Vehicle> vehicles = dataHelper.getVehicles();
	}
}
