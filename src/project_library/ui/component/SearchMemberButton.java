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

	public String getMemberName;
	public String getMemberCode;
	public String getMemberTel;
	private SearchMemberFrame bFrame;

	public SearchMemberButton() {
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			private MemberManagementService mService;
			public  ArrayList<Member> memberDtoList;
			public String memberName;
			public String memberTel;
			public String memberCode;

			public void actionPerformed(ActionEvent e) {
				//System.out.println("A");
				
				Member name = SearchMemberFrame.pInput.getItem();
				
				mService=new MemberManagementService();
				memberDtoList=(ArrayList<Member>)mService.getMemberDtoList();
//				if (isEmpty()) {
//					throw new EmptyTfException("공란 존재");
//				}

				boolean memberChk=false;
				memberCode = "";
				memberName = "";
				memberTel = "";
				
				for(Member M: memberDtoList) {
					memberChk=true;
					memberCode=M.getNo();
					memberName=M.getName();
					memberTel=M.getTel();
				}
				
				if(memberChk==true) {
					
				}
			}
//			public Member getMember() {
//
//				// 공란
//				
//				// 형식
//				if (!isInvalid()) {
//					throw new InValidationException("형식이 맞지 않습니다.");
//				}
//
////				String no = tfNo.getText().trim();
//				String name = tfName.getText().trim();
////				String tel = tfTel.getText().trim();
//				return new Member(name);
//			}
			public String getMemberName() {
				return memberName;
			}

			public String getMemberTel() {
				return memberTel;
			}

			public String getMemberCode() {
				return memberCode;
			}
		});
		add(btnSearch);
		
		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				bFrame.dispose();
			}
		});
		add(btnClose);

	}
	public void setbFrame(SearchMemberFrame bFrame) {
		this.bFrame = bFrame;
	}

}
