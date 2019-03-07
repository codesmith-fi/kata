/**
 * 
 */
package romanNumerals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for the event that should exit the application
 * @author erno
 */
public class QuitListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("QuitListener::actionPerformed invoked");
		System.out.println("  application exit");		
		System.exit(0);
	}
}
