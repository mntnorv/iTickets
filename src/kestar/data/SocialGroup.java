package kestar.data;

public class SocialGroup {
	private String name;
	private double discount;
	
	public SocialGroup() {
		name = "";
		discount = 0;
	}

	public SocialGroup(String name, double discount) {
		super();
		this.name = name;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
