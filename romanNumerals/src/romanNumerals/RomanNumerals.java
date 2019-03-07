package romanNumerals;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.GroupLayout.ParallelGroup;

public class RomanNumerals extends JFrame {
	private static final long serialVersionUID = -3009379824040728206L;
	private static String TXT_WINDOW_TITLE = "Roman numberal calculator";
	private static String TXT_CALCULATE_ROMAN = "Convert";
	private static String TXT_CALCULATE_INTEGER = "Convert";
	private static String TXT_BUTTON_QUIT = "Exit";
	private static String TXT_BUTTON_QUIT_TOOLTIP = "Close the calculator";
	private static String TXT_INPUT_CONVERTROMAN_TOOLTIP = "Enter a Roman numeral here";
	private static String TXT_INPUT_CONVERTINTEGER_TOOLTIP = "Enter integer value here";
	private static String TXT_LABEL_CONVERTROMAN = "Convert Roman to integer value";
	private static String TXT_LABEL_CONVERTINTEGER = "Convert value to Roman numeral";
	private static String TXT_LABEL_RESULT = "Conversion result:";
	private static String TXT_MENUBAR_FILE = "File";
	
	private static int SIZE_WINDOW_WIDTH = 400;
	private static int SIZE_WINDOW_HEIGHT = 300;

	public RomanNumerals() {
		setupUserInterface();
	}
	
	public static void main(String[] args) {
		/* Commented out for now
		System.out.println("Roman numbers for 0-1000:");
		for( int i=0; i<1001; ++i) {
			String romanStr = romanNumeralParser.parseInt(i);
			if(romanStr.isEmpty()) {
				romanStr = "Not a valid Roman numeral";
			}
			System.out.printf("%5d: %s%n", i, romanStr);
		}
		*/

		var ui = new RomanNumerals();
		ui.setVisible(true);
		
		
	}

	/**
	 * Create and initialize the UI and components. One monolithic method
	 * because for now I did not see a reason to split it up
	 */
	private void setupUserInterface() {
		setTitle(TXT_WINDOW_TITLE);
		setSize(SIZE_WINDOW_WIDTH, SIZE_WINDOW_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setupMenuBar();	
		
		var pane = getContentPane();
		var layout = new GroupLayout(pane);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		pane.setLayout(layout);
		
		// Create and initialize the needed buttons
		var buttonQuit = new JButton(TXT_BUTTON_QUIT);
		buttonQuit.addActionListener(new QuitListener());
		buttonQuit.setToolTipText(TXT_BUTTON_QUIT_TOOLTIP);
		var buttonCalculateRoman = new JButton(TXT_CALCULATE_ROMAN);
		var buttonCalculateInteger = new JButton(TXT_CALCULATE_INTEGER);
		
		// Labels for possible operations
		var labelConvertRoman = new JLabel(TXT_LABEL_CONVERTROMAN);
		var labelConvertInteger = new JLabel(TXT_LABEL_CONVERTINTEGER);
		var labelConversionResult = new JLabel(TXT_LABEL_RESULT);
		
		var textInputRoman = new JTextField();
		textInputRoman.setToolTipText(TXT_INPUT_CONVERTROMAN_TOOLTIP);
		var textInputInteger = new JTextField();
		textInputInteger.setToolTipText(TXT_INPUT_CONVERTINTEGER_TOOLTIP);
		// Read only text field for the result
		var textResultValue = new JTextField();
		textResultValue.setEditable(false);
		
		// Wanted layout for the components
		// --------------------------------------
		// | This is the label for operations   |
		// | |numeral input| |button|           |
		// | |Roman input  | |button|           |
		// |                                    |
		// | This is a label for the result     |
		// | |text field for the result       | |
		// |                                    |
		// | |button|                           |
		// --------------------------------------
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(labelConvertInteger)
					.addGroup(layout.createSequentialGroup()
						.addComponent(textInputInteger)
						.addComponent(buttonCalculateInteger)
						)
					.addComponent(labelConvertRoman)
					.addGroup(layout.createSequentialGroup()
							.addComponent(textInputRoman)
							.addComponent(buttonCalculateRoman)
							)
					.addComponent(labelConversionResult)
					.addComponent(textResultValue)
					.addComponent(buttonQuit)
				);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(labelConvertInteger)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(textInputInteger)
						.addComponent(buttonCalculateInteger)
						)
					.addComponent(labelConvertRoman)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(textInputRoman)
							.addComponent(buttonCalculateRoman)
							)
					.addComponent(labelConversionResult)
					.addComponent(textResultValue)
					.addComponent(buttonQuit)
				);
		pack();
	}
	
	/**
	 * Setup the wanted menu and menu items
	 */
	private void setupMenuBar() {
		var menubar = new JMenuBar();
		var menu = new JMenu();
		var menuitemQuit = new JMenuItem();
		menuitemQuit.setText(TXT_BUTTON_QUIT);
		menuitemQuit.addActionListener(new QuitListener());
		menu.add(menuitemQuit);		
		menubar.add(menu);
		menu.setText(TXT_MENUBAR_FILE);
		setJMenuBar(menubar);		
	}
}
