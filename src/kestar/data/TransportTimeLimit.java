package kestar.data;

public class TransportTimeLimit {
	private int fromWeekday;
	private int toWeekday;
	private Time fromTime;
	private Time toTime;
	
	public TransportTimeLimit() {
		fromWeekday = 0;
		toWeekday = 0;
		fromTime = new Time();
		toTime = new Time();
	}

	public TransportTimeLimit(int fromWeekday, int toWeekday, Time fromTime,
			Time toTime) {
		this.fromWeekday = fromWeekday;
		this.toWeekday = toWeekday;
		this.fromTime = fromTime;
		this.toTime = toTime;
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
