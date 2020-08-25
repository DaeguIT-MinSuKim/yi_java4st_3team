package project_library.ui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import project_library.dto.Member;
import project_library.service.MemberManagementService;
import project_library.ui.frame.SearchMemberFrame;

@SuppressWarnings("serial")
public class SearchMemberButton extends JPanel {

	public SearchMemberButton() {
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			private MemberManagementService mService;
			public  ArrayList<Member> memberDtoList;

			public void actionPerformed(ActionEvent e) {
				Member name= SearchMemberFrame.pInput.getItem();
				
				mService=new MemberManagementService();
				memberDtoList=(ArrayList<Member>)mService.getMemberDtoList();
				
				boolean memberChk=false;
				String memberCode="";
				String memberName="";
				String memberTel="";
				
				for(Member M: memberDtoList) {
					memberChk=true;
					memberCode=M.getNo();
					memberName=M.getName();
					memberTel=M.getTel();
				}
				
				if(memberChk==true) {
					
				}
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
