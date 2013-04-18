package kestar.data;

public class Vehicle {
	private int type;
	private int route;
	private double price;
	private int fromWeekday;
	private int toWeekday;
	private Time fromTime;
	private Time toTime;
	
	public Vehicle() {
		type = 0;
		route = 0;
		price = 0;
		fromWeekday = 0;
		toWeekday = 0;
		fromTime = new Time();
		toTime = new Time();
	}

	public Vehicle(int type, int route, double price, int fromWeekday,
			int toWeekday, Time fromTime, Time toTime) {
		super();
		this.type = type;
		this.route = route;
		this.price = price;
		this.fromWeekday = fromWeekday;
		this.toWeekday = toWeekday;
		this.fromTime = fromTime;
		this.toTime = toTime;
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

	public int getFromWeekday() {
		return fromWeekday;
	}

	public void setFromWeekday(int fromWeekday) {
		this.fromWeekday = fromWeekday;
	}

	public int getToWeekday() {
		return toWeekday;
	}

	public void setToWeekday(int toWeekday) {
		this.toWeekday = toWeekday;
	}

	public Time getFromTime() {
		return fromTime;
	}

	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}

	public Time getToTime() {
		return toTime;
	}

	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}
}
