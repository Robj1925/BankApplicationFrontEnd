package myConcepts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fdmgroup.DesignPatternExercises.Utility;

class UtilityTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_UtilityClassOnlyHasOneInstanceWhenGetInstanceIsCalled() {
		Utility expected = Utility.getInstance();
		Utility actual = Utility.getInstance();
		
		assertSame(expected, actual);
	}

}
