package com.fdmgroup.threadingExercises.exercise3;

public class AverageCalculator {
	private long total;
	private long count;
	
	public synchronized void addToTotal(int number) {
		total += number;
		count++;
	}
	public double calculateAverage() {
		
		return total / (double) count;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
}
