package com.fdmgroup.javaDocExercises;
/**
 * InvalidAccountException is an exception when a function is tried to be performed on an account with invalid attributes.
 * 
 * @author FDMGroup
 * @version 1.0
 */
public class InvalidAccountException extends Exception{
	private String message;
/**
 * constructor which calls on its parent (Exception class) constructor
 * @param message
 * 		passes our parameter to the parent class constructor
 */
	public InvalidAccountException(String message) {
		super(message);
		this.message = message;
		// TODO Auto-generated constructor stub
	}
	

}
