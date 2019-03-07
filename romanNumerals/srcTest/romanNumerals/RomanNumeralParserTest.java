package romanNumerals;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Unit test cases for romanNumeralParser class
 * @author erno
 *
 */
public class RomanNumeralParserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseIntZeroShouldProduceEmptyString_0() {
		assertTrue(RomanNumeralParser.parseInt(0).isEmpty());
	}	

	@Test
	public void testParseIntegersFromOneToTwentyShouldSucceed() {
		// Expected results in array
		final String expectedResults[] = new String[] {
				"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", 
				"X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
				"XVIII", "XIX", "XX"
		};
		
		// Create computed results with the converter
		for(int i=1; i<=20; ++i) {
			String result = RomanNumeralParser.parseInt(i);
			String failMsg = String.format("Fail: %d should be %s but was %s", 
					i, expectedResults[i], result);
			assertEquals(failMsg, expectedResults[i], result);
		}	
	}

	@Test
	public void testParseIntWithSelectedNumbersShouldSucceed() {
		// Expected results in array
		final String expectedResults[] = new String[] {
				"XI", "XV", "XXI", "XL", "L", "XC", "C", "CX", "CD",
				"D", "DC", "CM", "M", "MC", "MMCM", "MMM"
		};

		// Integers to be converted and verified against their expected
		// results
		final int testedNumbers[] = new int[] {
				11, 15, 21, 40, 50, 90, 100, 110, 400,
				500, 600, 900, 1000, 1100, 2900, 3000
		};
		
		// Verify that the test case is not insane
		assertEquals(expectedResults.length, testedNumbers.length);
		
		for(int i=0; i < testedNumbers.length; ++i) {
			String result = RomanNumeralParser.parseInt(testedNumbers[i]);
			String failMsg = String.format("Fail: %d should be %s but was %s", 
					testedNumbers[i], expectedResults[i], result);
			assertEquals(failMsg, expectedResults[i], result);
		}		
	}
		
	@Test
	public void testParseIntWithRangeOfValidValuesShouldProduceResult() {
		for(int i=1; i<=3000; ++i) {
			String roman = RomanNumeralParser.parseInt(i);
			assertFalse(roman.isEmpty());
		}
	}

	/**
	 * Test helper method for testing expected exception (IllegalArgumentException)
	 * with JUnit4
	 * @param argument Roman numeral to parse
	 * @return true if exception was thrown, otherwise false
	 */
	private boolean assertThrowsIllegalArgumentExceptionHelper(String argument) {
		boolean result = false;
		try {
			RomanNumeralParser.parseRoman(argument);
		} catch(Exception e) {
			if(e.getClass().getSimpleName()== "IllegalArgumentException") {
				result = true;
			}
		}
		return result;
	}
	
	@Test
	public void testParseRomanWithIllegaArgumentShouldFailWithExceptionl() {
		assertThrowsIllegalArgumentExceptionHelper("");
		assertThrowsIllegalArgumentExceptionHelper("ABC");
		assertThrowsIllegalArgumentExceptionHelper("VI1");
		assertThrowsIllegalArgumentExceptionHelper("1VI");
	}
	
	@Test
	public void testParseRomanWithSetOfValidNumeralsShouldSucceed() {
		// Roman numerals to be converted to integer
		final String romanStrings[] = new String[] {
				"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
				"XI", "XV", "XXI", "XL", "L", "XC", "C", "CX", "CD",
				"D", "DC", "CM", "M", "MC", "MMCM", "MMM"
		};

		// Expected integer results for the romanStrings conversion
		final int expectedResults[] = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 15, 21, 40, 50, 90, 100, 110, 400,
				500, 600, 900, 1000, 1100, 2900, 3000
		};

		// Verify that the test case is not insane
		assertEquals(romanStrings.length, expectedResults.length);
		
		// Verify the conversion results
		for(int i=0; i < expectedResults.length; ++i) {
			int result = RomanNumeralParser.parseRoman(romanStrings[i]);
			String failStr = String.format(
					"\"%s\" should produce value %d but result was %d", 
					romanStrings[i], expectedResults[i], result);
			assertTrue(failStr, expectedResults[i]==result);
		}
	}	
}
