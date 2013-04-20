package kestar.data;

import java.util.Calendar;

public class WeekdayDiscount extends Discount {

	private int fromWeekday;
	private int toWeekday;
	
	@Override
	public boolean isApplicable(Calendar dateAndTime, Client client,
			Vehicle vehicle) {
		int weekday = dateAndTime.get(Calendar.DAY_OF_WEEK);
		weekday -= 1;
		if (weekday == 0) {
			weekday = 7;
		}
		
		return weekday >= fromWeekday && weekday <= toWeekday;
	}

}
