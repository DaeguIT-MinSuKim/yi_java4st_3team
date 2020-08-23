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
		initcomponents();
		
		/*
		 * 프로그램 시작시 동작
		 * */
		// 01. [대여]버튼 비활성화
		btnRent.setEnabled(false);
	}

	private void initcomponents() {
		btnRent = new JButton("대여");
		add(btnRent);
		
		btnCancel = new JButton("닫기");
		add(btnCancel);
	}

}
