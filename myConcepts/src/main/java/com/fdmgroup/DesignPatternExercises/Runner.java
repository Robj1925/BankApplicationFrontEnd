package com.fdmgroup.DesignPatternExercises;

public class Runner {
	public static void main(String[] args) {
		Utility test = Utility.getInstance();
		System.out.println(test.maxOfTwoNumbers(10, 2));
		System.out.println(test.minOfTwoNumbers(100, 20));
		System.out.println(test.squareRootOfOneNumber(25));
	}
}
