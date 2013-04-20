package kestar.data;

import java.util.Calendar;

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
