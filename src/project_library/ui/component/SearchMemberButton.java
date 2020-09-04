package project_library.ui.component;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project_library.dto.Member;
import project_library.dto.Rent;
import project_library.exception.InValidationException;
import project_library.service.BookStatusManagementService;
import project_library.service.MemberManagementService;
import project_library.service.SearchMemberManagementService;
import project_library.ui.frame.SearchMemberFrame;
@SuppressWarnings("serial")
public class SearchMemberButton extends JPanel {

	public String getMemberName;
	public String getMemberCode;
	public String getMemberTel;
	protected Window bFrame;
	private BookStatusManagementService bService;

	public SearchMemberButton() {
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			private MemberManagementService mService;
			public  ArrayList<Member> memberDtoList;
			public ArrayList<Rent> SBookList;
			public String memberName;
			public String memberTel;
			public String memberCode;
			private SearchMemberManagementService sService;
			private ArrayList<Rent> SearchMemberBookList;
			
			
			public void actionPerformed(ActionEvent e) {
				bService = new BookStatusManagementService();
				//System.out.println("A");
				try {
				Member no = SearchMemberFrame.pInput.getItem();
				
				String getCode = no.getNo();
//				System.out.println(getCode);
				
				mService=new MemberManagementService();
				memberDtoList=(ArrayList<Member>)mService.getMemberDtoList();
				
//				System.out.println(memberDtoList);
				
				boolean memberChk=false;
				memberCode = "";
				memberName = "";
				memberTel = "";
				
				
				for(Member M: memberDtoList) {
					//	System.out.println(M.getNo());
					if( M.getNo().equals(getCode) ) {
						memberChk = true;
						memberCode=M.getNo();
						memberName=M.getName();
						memberTel=M.getTel();
						
					}
				}
				
//				System.out.println(memberCode);
				
				if(memberChk == true) {
					SearchMemberInfoShowPanel.lblGetNo.setText(memberCode);
					SearchMemberInfoShowPanel.lblGetName.setText(memberName);
					SearchMemberInfoShowPanel.lblGetTel.setText(memberTel);
					
					
					
					//--------------------------------------table
					
 					sService = new SearchMemberManagementService(); 
					SearchMemberBookList = (ArrayList<Rent>) sService.getSelectSearchMemberByNoList(memberCode);
					SearchMemberFrame.stable.setSearchMemberManagementList(SearchMemberBookList);
					
					// 연체 
					int num = 0;
					for( int i=0; i < SearchMemberFrame.stable.getRowCount(); i++ ) {
						if( SearchMemberBookList.get(i).getIsDelay().equals("Y") ) {
							num += 1;
						}
					}
					
					// 대여중
					int num2 = 0;
					for( int i=0; i < SearchMemberFrame.stable.getRowCount(); i++ ) {
						if( SearchMemberBookList.get(i).getReturnDate() == null ) {
							num2 += 1;
						}
					}
					
					
					
					
					int count1 = SearchMemberFrame.stable.getRowCount();
					String count2 = Integer.toString(count1);
//					
					SearchMemberTotalCountPanel.tfGetLateTotalCount.setText(num+""); // 연체
					SearchMemberTotalCountPanel.tfGetStillRent.setText(num2+""); // 대여중
					SearchMemberTotalCountPanel.tfGetTotal.setText(count2); // 총
					
					
				}else {
					JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.","오류",JOptionPane.ERROR_MESSAGE);
					clearMemberInfo();
				}
				
				}catch(InValidationException aa) {
					JOptionPane.showMessageDialog(null, "형식에 맞게 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
				
				} 
					  catch(NullPointerException aa) { JOptionPane.showMessageDialog(null,
					  "대여 내역이 없는 회원입니다.", "오류", JOptionPane.ERROR_MESSAGE); }
					 
					 
				
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
	protected void clearMemberInfo() {
		SearchMemberInfoShowPanel.lblGetNo.setText("");
		SearchMemberInfoShowPanel.lblGetName.setText("");
		SearchMemberInfoShowPanel.lblGetTel.setText("");
	}
	public void setbFrame(SearchMemberFrame bFrame) {
		this.bFrame = bFrame;
	}

}
