package kestar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kestar.data.Client;
import kestar.data.Discount;
import kestar.data.SocialGroup;
import kestar.data.TransportTimeLimit;
import kestar.data.Vehicle;

public class Main {
	public static void main(String [ ] args) {
		List<String> fileNames = new ArrayList<String>();
		fileNames.add("data/clients");
		fileNames.add("data/discounts");
		fileNames.add("data/social_groups");
		fileNames.add("data/transport");
		fileNames.add("data/transport_time_data");
		
		DataHelper dataHelper = new DataHelper();
		dataHelper.readData(fileNames);
		
		List<SocialGroup> socialGroups = dataHelper.getSocialGroups();
		List<String> vehicleTypes = dataHelper.getVehicleTypes();
		List<Client> clients = dataHelper.getClients();
		List<Vehicle> vehicles = dataHelper.getVehicles();
		Map<String, List<TransportTimeLimit>> timeLimits = dataHelper.getTimeLimits();
		Map<String, List<Discount>> discounts = dataHelper.getDiscounts();
		
		/*dataHelper.writeData();
		
		MainWindow testWindow = new MainWindow();
		testWindow.setVisible(true);*/
	}
}
