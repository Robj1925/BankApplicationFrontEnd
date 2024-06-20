import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckoutTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	// @Test
	void test() {
		fail("Not yet implemented");
	}

	@Test

	public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket() {
		// Arrange
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		// Act
		Double expected = checkout.calculatePrice(basket);

		// Assert
		assertEquals(expected, 0.0);
	}

	@Test

	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(9.99);
		basket.addBook(book);
		Checkout checkout = new Checkout();
		// Act
		Double expected = checkout.calculatePrice(basket);
		// Assert
		assertEquals(expected, 9.99);
	}

	@Test
	public void test_CalculatePrice_ReturnsPriceOfTwoBooksInBasket_WhenPassedBasketWithTwoBooks() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(5.00);
		Book book1 = new Book(5.00);
		basket.addBook(book);
		basket.addBook(book1);
		Checkout checkout = new Checkout();
		// Act
		Double actual = checkout.calculatePrice(basket);
		// Assert
		assertEquals(actual, 10);
	}

	@Test
	public void test_CalculatePrice_ReturnDiscountedPriceofThreeBooksInBasket_WhenPassedBasketWithThreeBooks() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(25.99);
		Book book2 = new Book(25.99);
		Book book3 = new Book(25.99);
		basket.addBook(book);
		basket.addBook(book2);
		basket.addBook(book3);
		Checkout checkout = new Checkout();
		// Act
		Double actual = checkout.calculatePrice(basket);
		System.out.println("Actual: " + actual);
		// Assert
		assertEquals(actual, 77.1903);
	}

	@Test
	public void test_CalculatePrice_ReturnDiscountedPriceOf7BooksInBasket_WhenPassedBasketWithSevenBooks() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(25.99);
		Book book2 = new Book(25.99);
		Book book3 = new Book(25.99);
		Book book4 = new Book(25.99);
		Book book5 = new Book(25.99);
		Book book6 = new Book(25.99);
		Book book7 = new Book(25.99);
		basket.addBook(book);
		basket.addBook(book2);
		basket.addBook(book3);
		basket.addBook(book4);
		basket.addBook(book5);
		basket.addBook(book6);
		basket.addBook(book7);

		Checkout checkout = new Checkout();
		// Act
		Double actual = checkout.calculatePrice(basket);
		System.out.println("Actual: " + actual);
		assertEquals(actual, 178.2914);
	}
	
	@Test
	public void test_CalculatePrice_ReturnDiscountedPriceOf10BooksInBasket_WhenPassedBasketWith10Books() {
		// Arrange
				Basket basket = new Basket();
				Book book = new Book(10.00);
				Book book2 = new Book(10.00);
				Book book3 = new Book(10.00);
				Book book4 = new Book(10.00);
				Book book5 = new Book(10.00);
				Book book6 = new Book(10.00);
				Book book7 = new Book(10.00);
				Book book8 = new Book(10.00);
				Book book9 = new Book(10.00);
				Book book10 = new Book(10.00);

				basket.addBook(book);
				basket.addBook(book2);
				basket.addBook(book3);
				basket.addBook(book4);
				basket.addBook(book5);
				basket.addBook(book6);
				basket.addBook(book7);
				basket.addBook(book8);
				basket.addBook(book9);
				basket.addBook(book10);


				Checkout checkout = new Checkout();
				// Act
				Double actual = checkout.calculatePrice(basket);
				System.out.println("Actual: " + actual);
				assertEquals(actual, 87.00);
		
	}

	/* 
	 * */
}
