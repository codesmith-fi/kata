package romanNumerals;

import javax.swing.*;

public class romanNumerals extends JFrame {
	private static final long serialVersionUID = -3009379824040728206L;
	private static String TXT_WINDOW_TITLE = "Roman numberal calculator";
	private static int SIZE_WINDOW_WIDTH = 400;
	private static int SIZE_WINDOW_HEIGHT = 300;

	public romanNumerals() {
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

		var ui = new romanNumerals();
		ui.setVisible(true);
		
		
	}

	public void setupUserInterface() {
		setTitle(TXT_WINDOW_TITLE);
		setSize(SIZE_WINDOW_WIDTH, SIZE_WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
