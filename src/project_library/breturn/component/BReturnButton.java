package project_library.breturn.component;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BReturnButton extends JPanel {

	/**
	 * Create the panel.
	 */
	public BReturnButton() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		
		JButton btnReturn = new JButton("반납");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnReturn);
		
		JButton btnExit = new JButton("닫기");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btnExit);

	}

}
