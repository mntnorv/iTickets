package kestar.data;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SocialGroupDiscount extends Discount {

	private String group;
	
	@JsonCreator
	public SocialGroupDiscount(@JsonProperty("group") String group) {
		this.group = group;
	}
	
	@Override
	public boolean isApplicable(Calendar dateAndTime, Client client,
			Vehicle vehicle) {
		return client.getSocialGroup().equals(group);
	}
	
	public String getGroup() {
		return group;
	}
}
