import java.util.List;

public class Checkout {

	public Double calculatePrice(Basket basket) {
		double price = 0.0;
		List<Book> books = basket.getBooksInBasket();

		if (books.isEmpty()) {
			return price;
		}
		for (Book book : books) {
			price += book.getPrice();
		}

		int bookCount = books.size();
		double discount = 0.0;

		if (bookCount >= 10) {
			discount += 0.10; // 10% discount for 10 or more books
		}

		discount += (bookCount / 3) * 0.01; // 1% discount for every 3 books

		return price * (1 - discount);
	}

}
