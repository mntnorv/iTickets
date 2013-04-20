package kestar.data;

import java.util.Calendar;

public class SocialGroupDiscount extends Discount {

	private String group;
	
	@Override
	public boolean isApplicable(Calendar dateAndTime, Client client,
			Vehicle vehicle) {
		return client.getSocialGroup().equals(group);
	}
}
