package kestar.data;

import java.util.Calendar;

public class TimeDiscount extends Discount {

	private Time fromTime;
	private Time toTime;
	
	@Override
	public boolean isApplicable(Calendar dateAndTime, Client client,
			Vehicle vehicle) {
		Time currentTime = new Time(dateAndTime);
		if (fromTime.compareTo(currentTime) <= 0 && toTime.compareTo(currentTime) >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
