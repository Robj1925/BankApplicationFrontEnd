package com.fdmgroup.comparisonsExercises;

import java.util.Comparator;

public class BookComparatorComparesByPagesThenByISBNInDescending implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		if (o1.getNumberOfPages() != o2.getNumberOfPages()) {
			return Integer.compare(o1.getNumberOfPages(), o2.getNumberOfPages());
		}
		return Integer.compare(o2.getIsbn(), o1.getIsbn());
	}

}
