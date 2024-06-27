package com.fdmgroup.threadingExercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fdmgroup.threadingExercises.exercise3.AverageCalculator;

public class FileReaderThread extends Thread {
	private AverageCalculator averageCalculator;
	private String fileName;
	public FileReaderThread(AverageCalculator averageCalculator, String fileName) {
		super();
		this.averageCalculator = averageCalculator;
		this.fileName = fileName;
	}
	@Override
	public void run() {
		File file = new File(fileName);
		// FileReader fr = new FileReader(file);
		
		try (Scanner myReader = new Scanner(file);) {
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] nums = data.split(",");
	
		      
		        for (String num : nums) {
		        	num = num.trim();
		        	//System.out.println(num);
		        	averageCalculator.addToTotal(Integer.parseInt(num));
		        }
		       // System.out.println(data);
		      }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		super.run();
		
	}
	
	

}
