package romanNumerals;

import static org.junit.Assert.*;
import org.junit.*;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Unit test cases for ConvertIntegerButtonListener class
 * @author erno
 *
 */
public class ConvertIntegerButtonListenerTest {
	// Required classes for the test
	private JTextField sourceField;
	private JTextField targetField;
	private JButton actionButton;
	private ConvertIntegerButtonListener listener;

	@Before
	public void setUp() throws Exception {
		sourceField =  new JTextField();
		targetField =  new JTextField();		
		actionButton = new JButton();
		listener = new ConvertIntegerButtonListener(targetField, sourceField);
		actionButton.addActionListener(listener);		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListenerWithValidIntegerEventShouldTriggerAndConversionNotFail() {
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
	public void testListenerWithInvalidIntegersEventShouldTriggerAndConversionFail() {
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
	public void testListenerWithInvalidIntegerZeroEventShouldTriggerAndConversionFail() {					
		sourceField.setText("0");
		targetField.setText("not");
		// Cause the event
		actionButton.doClick();
		assertEquals(targetField.getText(), ConvertIntegerButtonListener.TXT_RESULT_UNDEFINED);
	}		
}	
