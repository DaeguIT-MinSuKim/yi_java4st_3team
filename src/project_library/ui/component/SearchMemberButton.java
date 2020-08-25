package project_library.ui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import project_library.dto.Member;
import project_library.ui.frame.SearchMemberFrame;

@SuppressWarnings("serial")
public class SearchMemberButton extends JPanel {

	public SearchMemberButton() {
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member name= SearchMemberFrame.pInput.getItem();
				
				
				// membersearchmanagement 에 입력된 정보를 가지고 와서 member name으로 회원 정보와 일치하는지 
				//일치하는 name이 잇다면 정보를 가지고 와서 pmemberinfo에 올려주기 
				//pMemberinfo에 올려진 회원이 빌린 대여정보를 pRentInfo로 올리기 
			}
		});
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
