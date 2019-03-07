package romanNumerals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * Listener for the convert integer to Roman button
 * Takes the source text field and the target result text field
 * in the constructor. 
 * @author erno
 */
public class ConvertIntegerButtonListener implements ActionListener {
	// Class constants
	public static final String TXT_RESULT_UNDEFINED = "Undefined";
	public static final String TXT_VALUE_NOT_INTEGER = "Not a valid integer value";
	
	// This target component will be updated with the result
	private JTextField resultTextField;
	// This source component is used to get the integer value
	private JTextField sourceValueTextField;
	
	/**
	 * Construct the listener
	 * @param resultTarget component which will be updated
	 * @param sourceTextField text field for the integer to be converted
	 */
	public ConvertIntegerButtonListener(JTextField resultTarget, JTextField sourceTextField)
	{
		resultTextField = resultTarget;
		sourceValueTextField = sourceTextField;
	}
	
	/**
	 * Perform the integer to Roman numeral conversion
	 * @param e event to be handled, not used
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ConvertIntegerButtonListener::actionPerformed invoked");
		try {
			int value = Integer.parseInt(sourceValueTextField.getText());			
			String roman = RomanNumeralParser.parseInt(value);
			String resultString = TXT_RESULT_UNDEFINED;
			if(!roman.isEmpty()) {
				resultString = roman;
			}
			resultTextField.setText(resultString);
			System.out.printf("  Integer %d is \"%s\" as Roman numeral%n", value, resultString);
		} catch(NumberFormatException exception) {
			String failureText = String.format(
					"  Tried to convert \"%s\" which is not a number", 
					sourceValueTextField.getText());
			System.out.println(failureText);
			resultTextField.setText(TXT_VALUE_NOT_INTEGER);
		}
	}	
}
