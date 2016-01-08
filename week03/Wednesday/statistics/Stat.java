package week03.Wednesday.statistics;

import java.util.LinkedList;
import java.util.List;


public class Stat implements Statistics {

	private List<Integer> data;
	private double mean;
	private Integer median;
	private Integer mode;
	private Integer countMode;
	private Integer range;
	
	public Stat() {
		data = new LinkedList<>();
		countMode = 0;
	}
	
	public String toString() {
		return data.toString();
	}
	
	public double getMean() {
		return mean;
	}
	
    public int getMedian() {
    	return median;
    }
	
	public int getMode() {
		return mode;
	}
	
	public int getRange() {
		return range;
	}
	
	public void add(int value) {
		addSorted(value);
		mean = pGetMean();
		median = pGetMedian();
		int countCurValue = countFound(value);
		if (countCurValue > countMode) {
			mode = value;
			countMode = countCurValue;
		}
		range = pGetRange();
	}
	
	private void addSorted(int v) {
		if (data.size() > 0) {
			for (int i = 0; i < data.size(); i++) {
				if (v < data.get(i)) {
					data.add(i, v);
					return;
				}	
			}
		}
		data.add(v);
	}
	
	private double pGetMean() {
		double sum = 0.0;
		for (int temp: data) {
			sum += temp;
		}
		return sum / data.size();
	}
	
	private int pGetMedian() {
		int size = data.size();
		if (size % 2 == 1) {
			size++;
		}
		int index = size/2;
		return data.get(index - 1);
	}

	private int countFound(int value) {
		int count = 0;
		for (int temp: data) {
			if (temp == value) {
				count++;
			}
		}
		return count;
	}
	
	private int pGetRange() {
		int lastValue = data.get(data.size() - 1);
		return lastValue - data.get(0);
	}
		
	public static void main(String [] Arg) {
		
		Stat statData = new Stat();
		statData.add(13);
		statData.add(18);
		statData.add(13);
		statData.add(14);
		statData.add(13);
		statData.add(16);
		statData.add(14);
		statData.add(21);
		statData.add(13);
		
		System.out.println(statData);
		Statistics data = statData;
		System.out.println(data.getMean());
		System.out.println(data.getMedian());
		System.out.println(data.getMode());
		System.out.println(data.getRange());
	}
}
