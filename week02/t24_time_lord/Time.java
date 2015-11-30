package week02.t24_time_lord;

import java.time.LocalDateTime;


public class Time {
	
	public int year;
	public int month;
	public int day;
	public int hour;
	public int minute;
	public int second;
	
	public Time(int year, int month, int day, int hour, int minute, int second) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public String toString() {
		return String.format("%02d:%02d:%02d %02d.%02d.%02d", day, minute, second, day, month, year % 1000);
	}
	
	public static Time now() {
		LocalDateTime t = LocalDateTime.now();
		return new Time(t.getYear(), t.getMonthValue(), t.getDayOfMonth(), 
				t.getHour(), t.getMinute(), t.getSecond());
	}
	
	public static void main(String[] args) {
		Time myt = new Time(2014, 1, 3, 13, 6, 54);
		System.out.println(myt);
		System.out.println(Time.now());
		
	}
	
	
	
}
