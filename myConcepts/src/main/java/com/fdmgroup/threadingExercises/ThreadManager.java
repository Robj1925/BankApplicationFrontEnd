package com.fdmgroup.threadingExercises;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
	protected List<Thread> threads;
	

	public ThreadManager() {
		this.threads = new ArrayList<>();
	}

	public void createThreads(int number) {
		Runnable runnable = new MyRunnable();
		for (int i = 0; i < number; i++) {
			Thread thread0 = new Thread(runnable, "Thread" + i);
			threads.add(thread0);
		}

	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

	public void runThreads() {
		for (Thread thread : threads) {
			thread.start();
		}

	}

}
