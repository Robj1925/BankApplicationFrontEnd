package com.fdmgroup.comparisonsExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Runner {

	public static void main(String[] args) {
		Book b = new Book("Learn Java", 45678, 19.99, 500, 4.3);
		Book b2 = new Book("Learn UNIX", 65432, 17.5, 650, 3.9);
		Book b3 = new Book("Learn SQL", 87956 , 9.75, 220, 4.4);
		  Book book4 = new Book("Learn Agile", 35367, 25.5, 500, 4.4);
	        Book book5 = new Book("Learn React",55676, 28.75, 490, 4.8);
	        Book book6 = new Book("Learn JavaScript", 34343, 14.99, 300, 4.4);
	        Book book7 = new Book("Learn Python", 65767, 27.25, 500, 4.1);
	        
	        List<Book> books = new ArrayList<>();
	        books.add(book7);
	        books.add(book6);
	        books.add(book5);
	        books.add(book4);
	        books.add(b3);
	        books.add(b2);
	        books.add(b);
	        
	        Collections.sort(books, new BookComparatorComparesByRatingThenPriceInDescending()); //i tested al of them worked properly
	        for (Book book : books) {
	        	//System.out.println(book);
	        }
	        TreeSet<Book> set = new TreeSet<>( new BookComparatorComparesByRatingThenPriceInDescending());
	        
	        set.add(book7);
	        set.add(book6);
	        set.add(book5);
	        set.add(book4);
	        set.add(b3);
	        set.add(b2);
	        set.add(b);
	        
	        for (Book book : set) {
	        	System.out.println(book);
	        }

	}
	 public static PriorityQueue<Double> createDescendingPriorityQueue(double... numbers) {
	        // Create a PriorityQueue with the natural order comparator reversed
	        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
	        
	        // Add all numbers to the PriorityQueue
	        for (double num : numbers) {
	            pq.add(num);
	        }
	        
	        return pq;
	    }
}
