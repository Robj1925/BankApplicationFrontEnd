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

}
