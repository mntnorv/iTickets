package kestar.data;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class Discount {
	
	private double discount;
	
	public abstract boolean isApplicable(Calendar dateAndTime,
			Client client, Vehicle vehicle);

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
