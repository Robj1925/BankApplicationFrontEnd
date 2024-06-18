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

	public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded(){ 

	//Arrange
		Basket expected = new Basket();
		//Act
		 List<Book> actual = basket.getBooksInBasket();
		//Assert
		 assertEquals(actual.size(), 0);
		

	} 
}
