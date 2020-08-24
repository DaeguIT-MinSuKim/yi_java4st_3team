package project_library.ui.component;

import static project_library.ui.frame.BookManagementFrame.bookList;
import static project_library.ui.frame.BookManagementFrame.bookTable;
import static project_library.ui.frame.BookManagementFrame.pBPanel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_library.dto.Book;
import project_library.exception.EmptyTfException;
import project_library.exception.FristCharException;
import project_library.exception.InValidationException;
import project_library.service.BookManagementService;

@SuppressWarnings("serial")
public class BookManagementButton extends JPanel implements ActionListener {
	public static JButton btnAdd;
	public static JButton btnSave;
	public static JButton btnUpdate;
	public static JButton btnDelete;
	public static JButton btnExit;
	private BookManagementService bService;

	public BookManagementButton() {

		initComponents();

		btnSave.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}

	private void initComponents() {

		setBorder(new EmptyBorder(0, 10, 0, 10));
		setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 0));

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnAdd);

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		btnSave.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnSave);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnDelete);

		btnExit = new JButton("닫기");
		btnExit.addActionListener(this);
		btnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(btnExit);
	}

	public void actionPerformed(ActionEvent e) {

		try {

			if (e.getSource() == btnUpdate) {
				actionPerformedBtnUpdate();
			}

			if (e.getSource() == btnDelete) {
				actionPerformedBtnDelete();
			}

			if (e.getSource() == btnAdd) {
				actionPerformedBtnAdd();
			}

			if (e.getSource() == btnExit) {
				actionPerformedBtnExit();
			}

			if (e.getSource() == btnSave) {
				actionPerformedBtnSave();
			}

		} catch (EmptyTfException ee) {
			JOptionPane.showMessageDialog(null, "공란 존재", "오류", JOptionPane.ERROR_MESSAGE);
			return;

		} catch (FristCharException ee) {
			JOptionPane.showMessageDialog(null, "도서코드는 B로 시작해야 됩니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;

		} catch (InValidationException ee) {
			JOptionPane.showMessageDialog(null, "형식이 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	protected void actionPerformedBtnSave() {

		// pBPanel 에서 getMember()를 이용해서 newBto
		Book newBto = pBPanel.getBook();

		// pBPanel 에서 getCodeNo()를 이용해서 newBto2
		Book newBto2 = pBPanel.getCodeNo();

		// 테이블에 있는 모든 도서코드 체크
		for (Book b : bookList) {
			if (newBto2.getNo().equals(b.getNo())) {
				JOptionPane.showMessageDialog(null, "도서코드가 중복입니다.", "오류", JOptionPane.ERROR_MESSAGE);
				System.out.println(newBto2);
				return;
			}

		}
		String message = String.format("%s 도서가 저장 되었습니다.", newBto.getBookName());
		JOptionPane.showMessageDialog(null, message);
		
		// Book DB 저장 연동
		bService = new BookManagementService();
		bService.insertBook(newBto);

		// newBto를 Book에 add
		bookTable.addBookDto(newBto);

		// bList add
		bookList.add(newBto);

		// pBPanel clear
		pBPanel.clearTf();

		// 저장 성공 - 수정, 삭제 버튼 활성화
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);

		// 저장 버튼 비활성화
		btnSave.setEnabled(false);

		// 도서 코드 비활성화
		pBPanel.getTf().setEditable(false);

		int idx = bookList.indexOf(newBto);
		bookTable.setRowSelectionInterval(0, idx);
		System.out.println(idx);

	}

	protected void actionPerformedBtnAdd() {

		// 입력창 활성화
		pBPanel.setEditalbeTrueTf();

		// Clear
		pBPanel.clearTf();

		// 저장, 수정, 삭제 버튼 비활성화
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}

	protected void actionPerformedBtnUpdate() {
		Book uptatedBoo = pBPanel.getItem();
		int idx = bookList.indexOf(uptatedBoo);
		bookTable.updateRow(idx, uptatedBoo);
		bookTable.setRowSelectionInterval(0, idx);
		pBPanel.clearTf();
		JOptionPane.showMessageDialog(null, "수정 되었습니다.");
	}

	protected void actionPerformedBtnDelete() {

		// 선택된 인덱스
		int idx = bookTable.getSelectedRow();

		// Book DB 삭제 연동
		Book delBook = pBPanel.getItem();
		bService.removeBook(delBook);

		// 삭제 여부 메시지
		int result = JOptionPane.showConfirmDialog(null, "정말 삭제 하시겠습니까?", "경고", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			
			// table 에서 삭제
			bookTable.delBookDto(idx);

			// pMember clear
			pBPanel.clearTf();

			// 삭제 성공 - 수정, 삭제 버튼 비활성화
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);

		} else {
			// 삭제 취소 - 수정, 삭제 버튼 활성화
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
		}

	}

	protected void actionPerformedBtnExit() {
		System.exit(0);
	}

}
