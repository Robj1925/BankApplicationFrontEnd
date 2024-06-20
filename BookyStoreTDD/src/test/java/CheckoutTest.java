import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckoutTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	//@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test 

	public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket() { 
		//Arrange
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		//Act
		Double expected = checkout.calculatePrice(basket);
		
		//Assert
		assertEquals(expected, 0.0);
	} 
	
	@Test 

	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook() { 
		//Arrange
		Basket basket = new Basket();
		Book book = new Book(9.99);
		basket.addBook(book);
		Checkout checkout = new Checkout();
		//Act
		Double expected = checkout.calculatePrice(basket);
		//Assert
		assertEquals(expected, 9.99 );
	} 
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfTwoBooksInBasket_WhenPassedBasketWithTwoBooks() {
		//Arrange
		Basket basket = new Basket();
		Book book = new Book(5.00);
		Book book1 = new Book(5.00);
		basket.addBook(book);
		basket.addBook(book1);
		Checkout checkout = new Checkout();
		//Act
		Double actual = checkout.calculatePrice(basket);
		//Assert
		assertEquals(actual, 10);
	}
	@Test
	public void test_CalculatePrice_ReturnDiscountedPriceofThreeBooksInBasket_WhenPassedBasketWithThreeBooks() {
		//Arrange
		Basket basket = new Basket();
		Book book = new Book(25.99);
		Book book2 = new Book(25.99);
		Book book3 = new Book(25.99);
		basket.addBook(book);
		basket.addBook(book2);
		basket.addBook(book3);
		Checkout checkout = new Checkout();
		//Act
		Double actual = checkout.calculatePrice(basket);
		System.out.println("Actual: " + actual);
		//Assert
		assertEquals(actual, 77.1903);
	}
	
	/* 
	 * */
}

