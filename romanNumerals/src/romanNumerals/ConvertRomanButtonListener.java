package romanNumerals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * Listener for the Convert roman to integer button
 * Takes the source text field and the target result text field
 * in the constructor. 
 * @author erno
 */
public class ConvertRomanButtonListener implements ActionListener {
	// Class constants
	public static final String TXT_VALUE_NOT_ROMAN = "Not a valid Roman numeral";
	
	// This target component will be updated with the result
	private JTextField resultTextField;	
	// This source component is used to get the Roman numeral
	private JTextField valueTextField;
	
	/**
	 * Construct the listener
	 * @param resultTarget component which will be updated
	 * @param valueSource component which contains the Roman numeral 
	 * 	to be converted
	 */
	public ConvertRomanButtonListener(JTextField resultTarget, JTextField valueSource)
	{
		valueTextField = valueSource;
		resultTextField = resultTarget;
	}
	
	/**
	 * Perform the Roman numeral to integer conversion
	 * @param e event to be handled, not used
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ConvertIntegerButtonListener::actionPerformed invoked");
		try {
			int result = RomanNumeralParser.parseRoman(
					valueTextField.getText());
			String resultString = Integer.toString(result);
			System.out.printf("  Roman \"%s\" is %s%n", 
					valueTextField.getText(), resultString);
			resultTextField.setText(resultString);			
		} catch(IllegalArgumentException exception) {
			String failureText = String.format(
					"  Tried to convert \"%s\" which is not a Roman numeral", 
					valueTextField.getText());
			System.out.println(failureText);
			
			resultTextField.setText(TXT_VALUE_NOT_ROMAN);
		}
	}	
}
