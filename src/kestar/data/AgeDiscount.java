package kestar.data;

import java.util.Calendar;

public class AgeDiscount extends Discount {
	
	public int fromAge;
	public int toAge;

	@Override
	public boolean isApplicable(Calendar dateAndTime, Client client,
			Vehicle vehicle) {
		return client.getAge() >= fromAge && client.getAge() <= toAge;
	}
}
