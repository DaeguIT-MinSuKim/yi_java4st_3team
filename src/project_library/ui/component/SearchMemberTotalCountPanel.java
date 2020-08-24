package project_library.ui.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class SearchMemberTotalCountPanel extends JPanel {

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
		
		JLabel lblGetLateTotalCount = new JLabel("	");
		add(lblGetLateTotalCount);
		
		JLabel lblKwon1 = new JLabel("권");
		add(lblKwon1);
		
		JLabel lblStillRent = new JLabel("대여중");
		add(lblStillRent);
		
		JLabel lblGetStillRent = new JLabel("	");
		add(lblGetStillRent);
		
		JLabel lblKwon2 = new JLabel("권");
		add(lblKwon2);
		
		JLabel lblTotal = new JLabel("총");
		add(lblTotal);
		
		JLabel lblGetTotal = new JLabel("	");
		add(lblGetTotal);
		
		JLabel lblKwon3 = new JLabel("권");
		add(lblKwon3);

	}

}
