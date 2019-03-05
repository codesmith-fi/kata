package fizzbuzzTest;

import fizzbuzz.FizzBuzzEvaluator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class FizzBuzzEvaluatorTest {
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test isFizz method with a valid Fizz number, divisible by three
	 */
	@DisplayName("Number is divisable by three (isFizz returns true)")
	@ParameterizedTest(name ="Number {0} is divisable by three (Fizz)")
	@ValueSource(ints = {3, 6, 9, 12, 15, 18, 21, 24})
	void testIsFizzValid(int number) {
		assertTrue(FizzBuzzEvaluator.isFizz(number));
	}

	/**
	 * Test isFizz method with invalid Fizz number, not divisible by three
	 */
	@DisplayName("Number is not divisable by three (isFizz returns false)")
	@ParameterizedTest(name ="Number {0} is not divisable by three (Fizz)")
	@ValueSource(ints = {0, 1, 2, 4, 5, 7, 8, 10, 11, 13})
	void testIsInFizzValid(int number) {
		assertFalse(FizzBuzzEvaluator.isFizz(number));
	}	
	
	/**
	 * Test isBuzz method with a valid Buzz number, divisible by five
	 */
	@DisplayName("Number is divisable by five (isBuzz returns true)")
	@ParameterizedTest(name ="Number {0} is divisable by five (Buzz)")
	@ValueSource(ints = {5, 10, 15, 20, 25, 30, 35, 40})
	void testIsBuzzValid(int number) {
		assertTrue(FizzBuzzEvaluator.isBuzz(number));
	}

	/**
	 * Test isBuzz method with a invalid Buzz number, not divisible by five
	 */
	@DisplayName("Number is not divisable by five (isBuzz returns false)")
	@ParameterizedTest(name ="Number {0} is not divisable by five (Buzz)")
	@ValueSource(ints = {0, 1, 2, 3, 4, 6, 7, 8, 9, 11})
	void testIsBuzzInvalid(int number) {
		assertFalse(FizzBuzzEvaluator.isBuzz(number));
	}
}
