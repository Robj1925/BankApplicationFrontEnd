package com.fdmgroup.threadingExercises;

import java.io.File;
import java.util.Random;

import com.fdmgroup.threadingExercises.exercise3.AverageCalculator;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
//		ThreadManager threadManager = new ThreadManager();
//		int numOfThreads = new Random().nextInt(20);
//		//threadManager.createThreads(numOfThreads);
//		
//		System.out.println("Number of threads created: " + numOfThreads);
//		ThreadManagerChild threadManagerChild = new ThreadManagerChild();
//		threadManagerChild.createThreads(numOfThreads);
//		threadManagerChild.runThreads();
//		threadManager.runThreads();
		System.out.println(new File(".").getAbsolutePath());
		AverageCalculator aC = new AverageCalculator();
		String fileName = "./src/main/java/TestRecords.txt";
		String fileName1 = "./src/main/resources/records1.txt";
		String fileName2 = "./src/main/resources/records2.txt";

		FileReaderThread fileReaderThread = new FileReaderThread(aC, fileName);
		fileReaderThread.start();
		fileReaderThread.join();
		System.out.println(aC.getCount());
		System.out.println(aC.getTotal());
		System.out.println(aC.calculateAverage());

		AverageCalculator averageCalculator1 = new AverageCalculator();
		AverageCalculator averageCalculator2 = new AverageCalculator();

		FileReaderThread fileReaderThread1 = new FileReaderThread(averageCalculator1, fileName1);
		FileReaderThread fileReaderThread2 = new FileReaderThread(averageCalculator1, fileName2);


//		System.out.println(averageCalculator1.getTotal());
//		System.out.println(averageCalculator1.calculateAverage());
//		System.out.println(averageCalculator2.getTotal());
//		System.out.println(averageCalculator2.calculateAverage());
		fileReaderThread1.start();
		fileReaderThread2.start();
		
		Thread currentTotalThread = new Thread(() -> {
			while (true) {
				System.out.println(averageCalculator1.getTotal());
				System.out.println(averageCalculator1.calculateAverage());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;

				}
		
				
//				System.out.println(averageCalculator2.getCount());
//				System.out.println(averageCalculator2.calculateAverage());
//				
//				try {
//					fileReaderThread2.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//					break;
//
//				}
			}
			
		});

		currentTotalThread.start();
		fileReaderThread1.join();
		fileReaderThread2.join();
		currentTotalThread.interrupt();

	}

}
