package project_librery.searchMember.component;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchMemberButton extends JPanel {

	public SearchMemberButton() {
		
		JButton btnSearch = new JButton("검색");
		add(btnSearch);
		
		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(btnClose);

	}

}
