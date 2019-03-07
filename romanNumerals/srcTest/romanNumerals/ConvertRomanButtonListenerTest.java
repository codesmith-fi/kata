package romanNumerals;

import static org.junit.Assert.*;
import org.junit.*;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Unit test cases for ConvertRomanButtonListener class
 * @author erno
 *
 */
public class ConvertRomanButtonListenerTest {
	// Required classes for the test
	private JTextField sourceField;
	private JTextField targetField;
	private JButton actionButton;
	private ConvertRomanButtonListener listener;
	
	@Before
	public void setUp() throws Exception {
		sourceField =  new JTextField();
		targetField =  new JTextField();		
		actionButton = new JButton();
		listener = new ConvertRomanButtonListener(targetField, sourceField);
		actionButton.addActionListener(listener);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListenerWithValidRomanNumeralsShouldSucceed() {
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
			
		for(int i=0; i<testedRomans.length; ++i) {
			sourceField.setText(testedRomans[i]);
			targetField.setText("None");
			// Cause the event
			actionButton.doClick();
			assertEquals(expectedResults[i], 
					Integer.parseInt(targetField.getText()));			
		}		
	}

	@Test
	public void testListenerWithInvalidRomanNumerals() {
		// Roman numerals to be tested
		final String testedRomans[] = new String[] {
				"XIa", "zXV", "not a roman", "whatever", "1I"
		};
			
		for(int i=0; i<testedRomans.length; ++i) {
			sourceField.setText(testedRomans[i]);
			targetField.setText("None");
			// Cause the event
			actionButton.doClick();
			assertEquals(targetField.getText(), ConvertRomanButtonListener.TXT_VALUE_NOT_ROMAN);
		}		
	}
}	
