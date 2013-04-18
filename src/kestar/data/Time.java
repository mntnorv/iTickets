package kestar.data;

public class Time {
	private int hours;
	private int minutes;
	private int seconds;
	
	public Time() {
		hours = 0;
		minutes = 0;
		seconds = 0;
	}

	public Time(int hours, int minutes, int seconds) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public Time(String timeStr) {
		if (timeStr.length() >= 4 && timeStr.length() <= 8) {
			String[] parts = timeStr.split(":");
			if (parts.length < 2 || parts.length > 3) {
				throw new IllegalArgumentException(timeStr);
			}
			
			hours = Integer.parseInt(parts[0]);
			minutes = Integer.parseInt(parts[1]);
			
			if (parts.length == 3) {
				seconds = Integer.parseInt(parts[2]);
			}
		} else {
			throw new IllegalArgumentException(timeStr);
		}
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}
