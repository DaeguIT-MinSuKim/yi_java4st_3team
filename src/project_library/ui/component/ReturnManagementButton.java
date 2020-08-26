package project_library.ui.component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_library.dto.Rent;
import project_library.ui.frame.ReturnManagementFrame;


@SuppressWarnings("serial")
public class ReturnManagementButton extends JPanel implements ActionListener {
	public static JButton btnReturn;
	public static JButton btnExit;
	
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
		 String RentDate = bdt.getRentDate().substring(0, 10); // 대여일
		 
		 // String -> Date 형변환
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		 
		 try {
			Date trans_ReturnDate = dateFormat.parse(ReturnDate);// 반납일 형변환
			Date trans_RentDate = dateFormat.parse(RentDate);// 대여일 형변환
			
			System.out.println(trans_ReturnDate);
			System.out.println(trans_RentDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 // 대여일과 반납일 비교
		 
		 int compare = ReturnDate.compareTo(RentDate);
		 
		 if( compare > 0 ) {
			 System.out.println("ReturnDate > RentDate");
		 }else if( compare < 0 ) {
			 System.out.println("ReturnDate < RentDate");
		 }else {
			 System.out.println("ReturnDate = RentDate");
		 }
		 
		 
		//02. 반납완료 값 입력
		
		
		//03. UI 화면 클리어, 테이블 목록에서 삭제
	}
	
	protected void actionPerformedBtnExit() {
		System.exit(0);
	}

}
