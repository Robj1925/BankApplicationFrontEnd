import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<Book> books;

	public Basket() {
		this.books = new ArrayList<>();
	}


	public List<Book> getBooksInBasket() {
		return books;
	}


	public List<Book> addBook(Book book) {
		// TODO Auto-generated method stub
		books.add(book);
		return books;
	}

}
