package project_library.ui.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project_library.dto.Rent;
import project_library.service.RentalManagementService;
import project_library.ui.frame.RentalManagementFrame;

public class RentalManagementButton extends JPanel implements MouseListener {
	public static JButton btnRent;
	public static JButton btnCancel;
	private RentalManagementService rService;
	
	/**
	 * Create the panel.
	 */
	public RentalManagementButton() {
		initcomponents();
		
		/*
		 * 프로그램 시작시 동작
		 * */
		// 01. [대여]버튼 비활성화
		btnRent.setEnabled(false);
		
	}

	private void initcomponents() {
		btnRent = new JButton("대여");
		btnRent.addMouseListener(this);
		add(btnRent);
		
		btnCancel = new JButton("닫기");
		btnCancel.addMouseListener(this);
		add(btnCancel);
	}

	public JButton getBtnRent() {
		return btnRent;
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_mouseClicked(e);
		}
		if (e.getSource() == btnRent) {
			do_btnRent_mouseClicked(e);
		}
	}
	
	public void do_btnRent_mouseClicked(MouseEvent e) {
		
		// 대여 버튼 클릭시 데이터 처리 ↓
		// 01. '도서'테이블 총대여횟수+1, 대여가능여부=0(NO), '회원'테이블 총대여권수+1
		Rent bookCode = RentalManagementFrame.pPanel.getItem();
		rService.modifyBook(bookCode);
		
		// 02 '출납' 대여목록 INSERT
		rService.insertBook(bookCode);
		
		// 대여 버튼 클릭시 UI처리 ↓
		// 01. 입력창 clear / disabled
		RentalManagementFrame.pPanel.clearTf();
		RentalManagementFrame.pPanel.setEditalbeFalseTf();
		
		// 02. [대여] 버튼 비활성화	
		btnRent.setEnabled(false);
		
		// 03. 도서목록 테이블에 대여한 rows 삭제
		int idx = RentalManagementFrame.table.getSelectedRow();
		RentalManagementFrame.table.delRentManagementDto(idx);
		
		//04. 완료 메시지
		JOptionPane.showMessageDialog(null, "도서 대여가 완료되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	protected void do_btnCancel_mouseClicked(MouseEvent arg0) {
		System.exit(0);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
