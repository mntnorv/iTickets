package kestar.data;

public class Vehicle {
	private int type;
	private int route;
	private double price;
	private String timeData;
	private String discountGroup;
	
	public Vehicle() {
		type = 0;
		route = 0;
		price = 0;
		timeData = "";
		discountGroup = "";
	}

	public Vehicle(int type, int route, double price, String timeData,
			String discountGroup) {
		super();
		this.type = type;
		this.route = route;
		this.price = price;
		this.timeData = timeData;
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

	public String getTimeData() {
		return timeData;
	}

	public void setTimeData(String timeData) {
		this.timeData = timeData;
	}

	public String getDiscountGroup() {
		return discountGroup;
	}

	public void setDiscountGroup(String discountGroup) {
		this.discountGroup = discountGroup;
	}
}
