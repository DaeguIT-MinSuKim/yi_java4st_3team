package project_library.ui.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchBookTotalCountPanel extends JPanel {
	public static JTextField tfCount;

	/**
	 * Create the panel.
	 */
	public SearchBookTotalCountPanel() {
		setBorder(new EmptyBorder(10, 0, 10, 10));
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(15);
		flowLayout.setVgap(0);
		
		JLabel lblTotalCount = new JLabel("총대여 횟수 : ");
		add(lblTotalCount);
		
		tfCount = new JTextField();
		add(tfCount);
		tfCount.setColumns(10);
		
		JLabel lblTotalCount2 = new JLabel("회");
		add(lblTotalCount2);

	}

}
