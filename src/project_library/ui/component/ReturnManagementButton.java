package project_library.ui.component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_library.dto.Rent;
import project_library.service.MemberManagementService;
import project_library.service.ReturnManagementService;
import project_library.ui.frame.RentalManagementFrame;
import project_library.ui.frame.ReturnManagementFrame;


@SuppressWarnings("serial")
public class ReturnManagementButton extends JPanel implements ActionListener {
	public static JButton btnReturn;
	public static JButton btnExit;
	private ReturnManagementService mService;
	private ReturnManagementFrame bFrame;

	public static JButton getBtnReturn() {
		return btnReturn;
	}

	public ReturnManagementButton() {
		initComponents();
		btnReturn.setEnabled(false);
	}

	private void initComponents() {
		
		setBorder(new EmptyBorder(0, 10, 0, 10));
		
		btnReturn = new JButton("반납");
		btnReturn.addActionListener(this);
		btnReturn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnReturn);
		
		btnExit = new JButton("닫기");
		btnExit.addActionListener(this);
		btnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnExit);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnReturn) {
			actionPerformedBtnReturn();
		}
		
		if(e.getSource() == btnExit) {
			actionPerformedBtnExit();
		}
	}

	protected void actionPerformedBtnReturn() {
		
		//01. 반납일, 대여일 비교 , 오류메시지
		 int idx = ReturnManagementFrame.table.getSelectedRow();
		 Rent bdt = ReturnManagementFrame.returnManagementList.get(idx);
		 String ReturnDate = ReturnManagementFrame.pRPanel.getTfRDate().getText(); // 반납일
		 String RentDate = bdt.getReturnDate().substring(0, 10); // 대여일
		 
		 // 대여일과 반납일 비교
		 int compare = ReturnDate.compareTo(RentDate);
		 if( compare > 0 ) { 
			 // 여기서 DB에 반납일 값 넣기 ㄱㄱ
			 Rent Data = ReturnManagementFrame.pRPanel.getItem();
			 //System.out.println(Data);
			mService = new ReturnManagementService();
			mService.updateReturnManagement(Data);
			
			//02. UI 화면 클리어, 테이블 목록에서 삭제
			ReturnManagementFrame.pRPanel.getTfRDate().setText(""); // 텍스트필드 글자 지움
			ReturnManagementFrame.pRPanel.clearTf();
			
			int Ridx = ReturnManagementFrame.table.getSelectedRow();
			ReturnManagementFrame.table.delReturnManagementDto(idx);
			
			JOptionPane.showMessageDialog(null, "도서 반납이 완료되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
			
			
			
			
		 } else { // 반납일을 잘못 입력했을 경우
			 JOptionPane.showMessageDialog(null, "대여일 이후의 날짜를 입력하세요", "오류", JOptionPane.ERROR_MESSAGE);
			 ReturnManagementFrame.pRPanel.getTfRDate().setText(""); // 텍스트필드 글자 지움
		 }
	}
	
	protected void actionPerformedBtnExit() {
		bFrame.dispose();
	}
	public void setbFrame(ReturnManagementFrame bFrame) {
		this.bFrame = bFrame;
	}

}
