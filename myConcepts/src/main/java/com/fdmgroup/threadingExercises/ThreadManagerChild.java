package com.fdmgroup.threadingExercises;

public class ThreadManagerChild extends ThreadManager {
	
	@Override
	public void createThreads(int number) {
		for (int i = 0; i < number; i++) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("This is ran from the child class " + Thread.currentThread().getName() + " is running.");			
				}
				
				
			}, "Thread" + i);
			threads.add(thread);
		}
	}
}
