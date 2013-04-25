package kestar.data;

public class Vehicle {
	private String type;
	private int route;
	private double price;
	private String timeData;
	private String discountGroup;
	
	public Vehicle() {
		type = "";
		route = 0;
		price = 0;
		timeData = "";
		discountGroup = "";
	}

	public Vehicle(String type, int route, double price, String timeData,
			String discountGroup) {
		super();
		this.type = type;
		this.route = route;
		this.price = price;
		this.timeData = timeData;
		this.discountGroup = discountGroup;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
	
	@Override
	public String toString() {
		return String.format("%d", route);
	}
}
