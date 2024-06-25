package com.fdmgroup.comparisonsExercises;

import java.util.Comparator;

public class BookComparatorByNumberOfPages implements Comparator<Book> {

	@Override
	public int compare(Book b, Book b2) {
		return Integer.compare(b.getNumberOfPages(), b2.getNumberOfPages());

	}



}
