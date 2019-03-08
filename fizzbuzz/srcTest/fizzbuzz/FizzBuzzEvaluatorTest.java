package fizzbuzz;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Unit test cases for FizzBuzzEvaluator class
 * @author erno
 */
public class FizzBuzzEvaluatorTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test isFizz method with a valid Fizz number, divisible by three
	 */
	@Test
	public void testIsFizzWithValidNumbersShouldReturnTrue() {
		final String valueStrings[] = new String[] {
			"3", "6", "9", "12", "13", "15", "18", "21", "24", "23", "33"
		};
		
		for(int i=0; i<valueStrings.length; ++i) {
			assertTrue(FizzBuzzEvaluator.isFizz(valueStrings[i]));
		}
	}

	/**
	 * Test isFizz method with invalid Fizz number, not divisible by three
	 */
	@Test
	public void testIsFizzWithInvalidNumbersShouldReturnFalse() {
		final String valueStrings[] = new String[] {
				"0", "1", "2", "4", "5", "7", "8", "10", "11", "14", "16"
			};
			
		for(int i=0; i<valueStrings.length; ++i) {
			assertFalse(FizzBuzzEvaluator.isFizz(valueStrings[i]));
		}
	}	
	
	/**
	 * Test isBuzz method with a valid Buzz number, divisible by five
	 */
	@Test
	public void testIsBuzzWithValidNumbersShouldReturnTrue() {
		final String valueStrings[] = new String[] {
				"5", "10", "15", "20", "25", "30", "35", "40", "155"
		};
			
		for(int i=0; i<valueStrings.length; ++i) {
			assertTrue(FizzBuzzEvaluator.isBuzz(valueStrings[i]));
		}
	}

	/**
	 * Test isBuzz method with a invalid Buzz number, not divisible by five
	 */
	@Test
	public void testIsBuzzWithInvalidNumbersShouldReturnFalse() {
		final String valueStrings[] = new String[] {
				"0", "1", "2", "3", "4", "6", "7", "8", "9", "11", "13", "23"
		};
			
		for(int i=0; i<valueStrings.length; ++i) {
			assertFalse(FizzBuzzEvaluator.isBuzz(valueStrings[i]));
		}
	}
}
