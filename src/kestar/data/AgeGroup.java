package kestar.data;

public class AgeGroup {
	private int fromAge;
	private int toAge;
	private double discount;
	
	public AgeGroup() {
		fromAge = 0;
		toAge = 0;
		discount = 0;
	}

	public AgeGroup(int fromAge, int toAge, double discount) {
		super();
		this.fromAge = fromAge;
		this.toAge = toAge;
		this.discount = discount;
	}

	public int getFromAge() {
		return fromAge;
	}

	public void setFromAge(int fromAge) {
		this.fromAge = fromAge;
	}

	public int getToAge() {
		return toAge;
	}

	public void setToAge(int toAge) {
		this.toAge = toAge;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
