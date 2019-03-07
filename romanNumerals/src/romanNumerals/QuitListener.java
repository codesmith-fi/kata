/**
 * 
 */
package romanNumerals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for window close event that should exit the application
 * @author erno
 *
 */
public class QuitListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
