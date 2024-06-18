import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasketTest {
	private Basket basket;

	@BeforeEach
	void setUp() throws Exception {
		basket = new Basket();
	}

//	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test

	public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded() {
		// Arrange
		Basket expected = new Basket();
		// Act
		List<Book> actual = basket.getBooksInBasket();
		// Assert
		assertEquals(actual.size(), 0);

	}

	@Test

	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
		// Arange
		Basket b = new Basket();
		Book book = new Book();
		// Act
		List<Book> expected = b.addBook(book);
		// Assert
		assertEquals(expected.size(), 1);
	}

	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthTwo_AfterAddBookMethodIsCalledWithTwoBooks() {
		//Act
		Book book = new Book();
		Book book2 = new Book();
		//Arrange
		List<Book> expected = basket.addBook(book);
		expected = basket.addBook(book2);
		
		//Assert
		assertEquals(expected.size(), 2);
	}
}
