package com.fdmgroup.DesignPatternExercises;

public class Utility {
	public static Utility utility = new Utility();

	private Utility() {
	}
	
	public static Utility getInstance() {
		return utility;
	}
	public int maxOfTwoNumbers(int first, int second) {
		return Math.max(first, second);
	}
	public int minOfTwoNumbers(int first, int second) {
		return Math.min(first, second);
	}
	public double squareRootOfOneNumber(double first) {
		return Math.sqrt(first);
	}
}
