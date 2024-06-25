package com.fdmgroup.comparisonsExercises;

import java.util.Comparator;

public class BookComparatorComparesByRatingThenPriceInDescending implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		if (o1.getRating() != o2.getRating()) {
			return Double.compare(o2.getRating(), o1.getRating());
		}
		return Double.compare(o1.getPrice(), o2.getPrice());
	}

}
