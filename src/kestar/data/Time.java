package kestar.data;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonValue;

public class Time implements Comparable<Time> {
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
	
	public Time(Calendar cal) {
		hours = cal.get(Calendar.HOUR_OF_DAY);
		minutes = cal.get(Calendar.MINUTE);
		seconds = cal.get(Calendar.SECOND);
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
	
	@Override
	@JsonValue
	public String toString() {
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	@Override
	public int compareTo(Time o) {
		if (hours == o.hours) {
			if (minutes == o.minutes) {
				return seconds - o.seconds;
			} else {
				return minutes - o.minutes;
			}
		} else {
			return hours - o.hours;
		}
	}
}
