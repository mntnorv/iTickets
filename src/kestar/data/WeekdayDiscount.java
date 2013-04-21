package kestar.data;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekdayDiscount extends Discount {

	private int fromWeekday;
	private int toWeekday;
	
	@JsonCreator
	public WeekdayDiscount(@JsonProperty("fromWeekday") int fromWeekday,
			@JsonProperty("toWeekday") int toWeekday) {
		super();
		this.fromWeekday = fromWeekday;
		this.toWeekday = toWeekday;
	}

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

	public int getFromWeekday() {
		return fromWeekday;
	}

	public int getToWeekday() {
		return toWeekday;
	}

}
