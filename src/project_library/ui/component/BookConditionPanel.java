package project_library.ui.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class BookConditionPanel extends JPanel {
	private JTextField tfTotalBook;
	private JTextField tfTotalLated;
	private JTextField tfTotalRent;
	public BookConditionPanel() {
		setLayout(new GridLayout(0, 3, 5, 10));
		
		JLabel lblTotalBook = new JLabel("총보유 권수 ");
		lblTotalBook.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalBook);
		
		tfTotalBook = new JTextField();
		add(tfTotalBook);
		tfTotalBook.setColumns(10);
		
		JLabel lblKwon1 = new JLabel("권");
		add(lblKwon1);
		
		JLabel lblTotalLated = new JLabel("총연체 권수");
		lblTotalLated.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalLated);
		
		tfTotalLated = new JTextField();
		tfTotalLated.setColumns(10);
		add(tfTotalLated);
		
		JLabel lblKwon2 = new JLabel("권");
		add(lblKwon2);
		
		JLabel lblTotalRent = new JLabel("총대여 횟수");
		lblTotalRent.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalRent);
		
		tfTotalRent = new JTextField();
		tfTotalRent.setColumns(10);
		add(tfTotalRent);
		
		JLabel lblKwon3 = new JLabel("권");
		add(lblKwon3);
	}

}
