package project_library.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class ReturnManagementButton extends JPanel implements ActionListener {
	private JButton btnReturn;
	private JButton btnExit;
	

	public ReturnManagementButton() {
		initComponents();

	}

	private void initComponents() {
		
		setBorder(new EmptyBorder(0, 10, 0, 10));
		
		
		btnReturn = new JButton("반납");
		btnReturn.addActionListener(this);
		btnReturn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnReturn);
		
		btnExit = new JButton("닫기");
		btnExit.addActionListener(this);
		btnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnExit);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnReturn) {
			actionPerformedBtnReturn();
		}
		
		if(e.getSource() == btnExit) {
			actionPerformedBtnExit();
		}
	}

	protected void actionPerformedBtnReturn() {
		
	}
	
	protected void actionPerformedBtnExit() {
		System.exit(0);
	}

}
