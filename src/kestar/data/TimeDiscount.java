package kestar.data;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeDiscount extends Discount {
	private Time fromTime;
	private Time toTime;
	
	@JsonCreator
	public TimeDiscount(@JsonProperty("fromTime") Time fromTime,
			@JsonProperty("toTime") Time toTime) {
		super();
		this.fromTime = fromTime;
		this.toTime = toTime;
	}

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

	public Time getFromTime() {
		return fromTime;
	}

	public Time getToTime() {
		return toTime;
	}
}
