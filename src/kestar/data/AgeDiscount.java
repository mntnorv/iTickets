package kestar.data;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AgeDiscount extends Discount {
	
	public int fromAge;
	public int toAge;
	
	@JsonCreator
	public AgeDiscount(@JsonProperty("fromAge") int fromAge,
			@JsonProperty("toAge") int toAge) {
		this.fromAge = fromAge;
		this.toAge = toAge;
	}

	@Override
	public boolean isApplicable(Calendar dateAndTime, Client client,
			Vehicle vehicle) {
		return client.getAge() >= fromAge && client.getAge() <= toAge;
	}

	public int getFromAge() {
		return fromAge;
	}

	public int getToAge() {
		return toAge;
	}
}
