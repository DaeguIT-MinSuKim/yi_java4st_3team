package project_library.ui.component;

import javax.swing.JPanel;
import javax.swing.JButton;

public class RentalManagementButton extends JPanel {
	private JButton btnRent;
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public RentalManagementButton() {
		
		btnRent = new JButton("대여");
		add(btnRent);
		
		btnCancel = new JButton("닫기");
		add(btnCancel);

	}

}
