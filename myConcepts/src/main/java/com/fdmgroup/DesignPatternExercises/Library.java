package com.fdmgroup.DesignPatternExercises;

import java.util.ArrayList;
import java.util.List;

public class Library {
	/*
	 * 
	 * 3. Create a library which contains a small number of books. A typical
	 * situation here may be that there are three books of one title and four of
	 * another. They can be borrowed and then returned. The program must check if
	 * the book is available. If not, the user must be warned that this is the case.
	 * When a library user borrows a book, the program should display what books are
	 * out on loan and which books are available.
	 */
	private List<Book> books;
	private List<Book> borrowed;
	private List<Book> available;
	public Library() {
		books = new ArrayList<>();
		Book book1 = new Book("Harry Potter");
		Book book2 = new Book("DBZ");
		Book book3 = new Book("DBS");
		Book book4 = new Book("Twilight");
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		available.add(book1);
		available.add(book2);
		available.add(book3);
		available.add(book4);

	}
	public Book borrow() {
		Book borrowedBook = null;
		for (Book b : available) {
			borrowedBook = b;
			available.remove(borrowedBook);
			break;
		}
		borrowed.add(borrowedBook);
		
		return borrowedBook;
		
		
	}
	public void returnBook(Book book) {
		borrowed.remove(book);
		available.add(book);
		
	}

}
