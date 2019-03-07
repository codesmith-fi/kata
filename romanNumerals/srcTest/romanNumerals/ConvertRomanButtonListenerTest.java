package romanNumerals;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test cases for ConvertRomanButtonListener class
 * @author erno
 *
 */
class ConvertRomanButtonListenerTest {
	// Required classes for the test
	private JTextField sourceField;
	private JTextField targetField;
	private JButton actionButton;
	private ConvertRomanButtonListener listener;
	
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
		listener = new ConvertRomanButtonListener(targetField, sourceField);
		actionButton.addActionListener(listener);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Test that the event is triggered and conversion succeeds, multiple roman numerals")
	void testListenerWithValidRomanNumerals() {
		// Roman numerals to be tested
		final String testedRomans[] = new String[] {
				"XI", "XV", "XXI", "XL", "L", "XC", "C", "CX", "CD",
				"D", "DC", "CM", "M", "MC", "MMCM", "MMM"
		};

		// Expected results from the conversion
		final int expectedResults[] = new int[] {
				11, 15, 21, 40, 50, 90, 100, 110, 400,
				500, 600, 900, 1000, 1100, 2900, 3000
		};

		// Test case sanity test
		assertEquals(expectedResults.length, testedRomans.length);
			
		sourceField.setText("true");
		targetField.setText("not");
		for(int i=0; i<testedRomans.length; ++i) {
			sourceField.setText(testedRomans[i]);
			targetField.setText("None");
			// Cause the event
			actionButton.doClick();
			assertEquals(expectedResults[i], 
					Integer.parseInt(targetField.getText()));			
		}		
	}
}	
