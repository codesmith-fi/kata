package romanNumerals;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test cases for ConvertIntegerButtonListener class
 * @author erno
 *
 */
class ConvertIntegerButtonListenerTest {
	// Required classes for the test
	private JTextField sourceField;
	private JTextField targetField;
	private JButton actionButton;
	private ConvertIntegerButtonListener listener;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		sourceField =  new JTextField();
		targetField =  new JTextField();		
		actionButton = new JButton();
		listener = new ConvertIntegerButtonListener(targetField, sourceField);
		actionButton.addActionListener(listener);		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Test that the event is triggered and conversion succeeds, multiple values")
	void testListenerWithValidInteger() {
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

		// Test case sanity test
		assertEquals(expectedResults.length, testedNumbers.length);
					
		sourceField.setText("true");
		targetField.setText("not");
		for(int i=0; i<testedNumbers.length; ++i) {
			sourceField.setText(Integer.toString(testedNumbers[i]));
			targetField.setText("None");
			// Cause the event
			actionButton.doClick();
			assertTrue(expectedResults[i].equals(targetField.getText()));			
		}		
	}

	@Test
	@DisplayName("Test that the event is triggered and conversion fails as expected, multiple invalid values")
	void testListenerWithInvalidIntegerRange() {
		// Expected results in array
		final String testedNumberStrings[] = new String[] {
				"not integer", "1A", "A1", "MCMXIV"
		};
					
		sourceField.setText("true");
		targetField.setText("not");
		for(int i=0; i<testedNumberStrings.length; ++i) {
			sourceField.setText(testedNumberStrings[i]);
			targetField.setText("None");
			// Cause the event
			actionButton.doClick();
			assertEquals(targetField.getText(), ConvertIntegerButtonListener.TXT_VALUE_NOT_INTEGER);
		}		
	}
	
	@Test
	@DisplayName("Test that the event is triggered and conversion fails as expected, value zero")
	void testListenerWithInvalidIntegerZero() {					
		sourceField.setText("0");
		targetField.setText("not");
		// Cause the event
		actionButton.doClick();
		assertEquals(targetField.getText(), ConvertIntegerButtonListener.TXT_RESULT_UNDEFINED);
	}		
}	
