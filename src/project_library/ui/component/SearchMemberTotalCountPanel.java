package project_library.ui.component;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class SearchMemberTotalCountPanel extends JPanel {
	public static JTextField tfGetLateTotalCount;
	public static JTextField tfGetStillRent;
	/**
	 * Create the panel.
	 */
	public SearchMemberTotalCountPanel() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(15);
		flowLayout.setVgap(0);
		
		JLabel lblTitle = new JLabel("총계 : ");
		add(lblTitle);
		
		JLabel lblLateTotalCount = new JLabel("연체 ");
		add(lblLateTotalCount);
		
		tfGetLateTotalCount = new JTextField();
		add(tfGetLateTotalCount);
		tfGetLateTotalCount.setColumns(10);
		
		JLabel lblKwon1 = new JLabel("권");
		add(lblKwon1);
		
		JLabel lblStillRent = new JLabel("대여중");
		add(lblStillRent);
		
		tfGetStillRent = new JTextField();
		add(tfGetStillRent);
		tfGetStillRent.setColumns(10);
		
		JLabel lblKwon2 = new JLabel("권");
		add(lblKwon2);

	}

}
