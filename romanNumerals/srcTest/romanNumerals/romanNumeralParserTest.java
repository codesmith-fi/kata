package romanNumerals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class romanNumeralParserTest {

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

	@Test
	@DisplayName("Convert 0 into Roman numeral, must give an empty result")
	void testParseInt_0() {
		assertTrue(romanNumeralParser.parseInt(0).isEmpty());
	}	

	@Test
	@DisplayName("Convert from 1 to 10 into Roman numeral and verify the results")
	void testParseInt_1to20() {
		// Expected results in array
		String expectedResults[] = new String[] {
				"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", 
				"X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
				"XVIII", "XIX", "XX"
		};
		
		// Create computed results with the converter
		ArrayList<String> results = new ArrayList<String>();
		results.add(""); // Special case for 0, not a Roman numeral
		for(int i=1; i<=20; ++i) {
			results.add(romanNumeralParser.parseInt(i));
		}
		
		for(int i=1; i<=20; ++i) {
			String failMsg = String.format("Fail: %d should be %s but was %s", 
					i, expectedResults[i], results.get(i));
			assertTrue(expectedResults[i].equals(results.get(i)), failMsg);
		}
	}

	@Test
	@DisplayName("Convert specific numbers into Roman numeral and verify the results")
	void testParseInt_selectedNumbers() {
		// Expected results in array
		String expectedResults[] = new String[] {
				"XI", "XV", "XXI", "XL", "L", "XC", "C", "CX", "CD",
				"D", "DC", "CM", "M", "MC", "MMCM", "MMM"
		};

		// Integers to be converted and verified against their expected
		// results
		int testedNumbers[] = new int[] {
				11, 15, 21, 40, 50, 90, 100, 110, 400,
				500, 600, 900, 1000, 1100, 2900, 3000
		};
		
		// Verify that the test case is not insane
		assertEquals(expectedResults.length, testedNumbers.length);
		
		for(int i=0; i < testedNumbers.length; ++i) {
			String result = romanNumeralParser.parseInt(testedNumbers[i]);
			String failMsg = String.format("Fail: %d should be %s but was %s", 
					testedNumbers[i], expectedResults[i], result);
			assertEquals(expectedResults[i], result, failMsg);
		}		
	}
		
	@Test
	@DisplayName("Convert integers from 1 to 3000 into Roman numeral, must give a result")
	void testParseIntWithRange() {
		for(int i=1; i<=3000; ++i) {
			String roman = romanNumeralParser.parseInt(i);
			assertFalse(roman.isEmpty());
		}
	}

	@Test
	@DisplayName("Parse roman numeral which is not valid")
	void testParseRomanWithIllegal() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
				romanNumeralParser.parseRoman("");
		});
	}
	
	@Test
	@DisplayName("Parse roman numerals to produce a integer values")
	void testParseRoman() {
		// Roman numerals to be converted to integer
		String romanStrings[] = new String[] {
				"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
				"XI", "XV", "XXI", "XL", "L", "XC", "C", "CX", "CD",
				"D", "DC", "CM", "M", "MC", "MMCM", "MMM"
		};

		// Expected integer results for the romanStrings conversion
		int expectedResults[] = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 15, 21, 40, 50, 90, 100, 110, 400,
				500, 600, 900, 1000, 1100, 2900, 3000
		};

		// Verify that the test case is not insane
		assertEquals(romanStrings.length, expectedResults.length);
		
		// Verify the conversion results
		for(int i=0; i < expectedResults.length; ++i) {
			int result = romanNumeralParser.parseRoman(romanStrings[i]);
			String failStr = String.format(
					"\"%s\" should produce value %d but result was %d", 
					romanStrings[i], expectedResults[i], result);
			assertEquals(expectedResults[i], result, failStr);
		}
	}	
}
