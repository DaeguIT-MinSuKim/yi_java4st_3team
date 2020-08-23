package project_library.ui.component;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BookConditionPanel extends JPanel {
	private JTextField tfTotalBookCount;
	private JTextField tfToTalLatedBookCount;
	private JTextField tfTotalRentCount;

	/**
	 * Create the panel.
	 */
	public BookConditionPanel() {
		setLayout(new GridLayout(0, 3, 10, 0));
		
		JLabel lblTotalBookCount = new JLabel("총보유 권수");
		lblTotalBookCount.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalBookCount);
		
		tfTotalBookCount = new JTextField();
		add(tfTotalBookCount);
		tfTotalBookCount.setColumns(10);
		
		JLabel lblKwon1 = new JLabel("권");
		add(lblKwon1);
		
		JLabel lblToTalLatedBookCount = new JLabel("총연체 권수");
		lblToTalLatedBookCount.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblToTalLatedBookCount);
		
		tfToTalLatedBookCount = new JTextField();
		tfToTalLatedBookCount.setColumns(10);
		add(tfToTalLatedBookCount);
		
		JLabel lblKwon2 = new JLabel("권");
		add(lblKwon2);
		
		JLabel lblTotalRentCount = new JLabel("총대여 횟수");
		lblTotalRentCount.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalRentCount);
		
		tfTotalRentCount = new JTextField();
		tfTotalRentCount.setColumns(10);
		add(tfTotalRentCount);
		
		JLabel lblKwon3 = new JLabel("권");
		add(lblKwon3);

	}

}
