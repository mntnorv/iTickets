package kestar.data;

public class Vehicle {
	private int type;
	private int route;
	private double price;
	private String discountGroup;
	
	public Vehicle() {
		type = 0;
		route = 0;
		price = 0;
		discountGroup = "";
	}

	public Vehicle(int type, int route, double price, String discountGroup) {
		super();
		this.type = type;
		this.route = route;
		this.price = price;
		this.discountGroup = discountGroup;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRoute() {
		return route;
	}

	public void setRoute(int route) {
		this.route = route;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDiscountGroup() {
		return discountGroup;
	}

	public void setDiscountGroup(String discountGroup) {
		this.discountGroup = discountGroup;
	}
}
