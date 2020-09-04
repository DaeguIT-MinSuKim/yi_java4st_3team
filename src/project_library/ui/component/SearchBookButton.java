package project_library.ui.component;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project_library.dto.Book;
import project_library.dto.Rent;
import project_library.service.BookManagementService;
import project_library.service.SearchBookManagementService;
import project_library.ui.frame.SearchBookFrame;

@SuppressWarnings("serial")
public class SearchBookButton extends JPanel implements MouseListener {
	private JButton btnSearch;
	private JButton btnExit;
	private BookManagementService bService;
	private SearchBookManagementService sService;
	public static ArrayList<Book> bookDtoList;
	public static ArrayList<Rent> SearchBookList;
	private SearchBookFrame bFrame;
	
	public SearchBookButton() {

		initcomponents();

	}

	private void initcomponents() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(15);

		btnSearch = new JButton("검색");
		btnSearch.addMouseListener(this);
		add(btnSearch);

		btnExit = new JButton("닫기");
		btnExit.addMouseListener(this);
		add(btnExit);
	}

	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == btnSearch) {
			btnSearch_mouseClicked(e);
		}
		if (e.getSource() == btnExit) {
			btnExit_mouseClicked(e);
		}
	}

	private void btnExit_mouseClicked(MouseEvent e) {
		bFrame.dispose();
	}

	
	public void btnSearch_mouseClicked(MouseEvent e) {


	}
	
	public void activeBookCode() {
//		System.out.println("난 도서코드함수다");
		// 라디오버튼 체크
//	      String radioChk = false;
//	      
//	      if( radioChk == true ) { // 도서명
//	         
//	      }else { // 도서코드
//	         
//	      }

		// System.out.println("검색함");

		// 텍스트필드에 입력된 도서코드 값 가져옴.
		String getTfBook = SearchBookFrame.tfBook.getText();
//	      System.out.println(getTfBook);

		// bookImpl에서 던져진 db값 가져옴
		bService = new BookManagementService();
		bookDtoList = (ArrayList<Book>) bService.getBookDtoList();

		// 도서코드를 기준으로 도서코드가 있는지 체크
		boolean bookCodeChk = false;
		String bookName = "";
		String bookCode = "";
		String bookPublisher = "";
		String bookAuthor = "";
		int bookPrice = 0;

		for (Book b : bookDtoList) {
			if (getTfBook.equalsIgnoreCase(b.getNo())) {
				bookCodeChk = true;
				bookCode = b.getNo();
				bookName = b.getBookName();
				bookPublisher = b.getPublisher();
				bookAuthor = b.getAuthor();
				bookPrice = b.getPrice();
			}
		}

		String bookPrice2 = Integer.toString(bookPrice);

		// 체크된 값을 기준으로 구분처리
		if (bookCodeChk == true) {
			// 도서 코드로 조회하여 멤버가 있으면
			// System.out.println("검색됨");

			// 도서코드, 도서명, 출판사, 저자, 가격 입력

			SearchBookPanel.tfBno.setText(bookCode);
			SearchBookPanel.tfBname.setText(bookName);
			SearchBookPanel.tfBpu.setText(bookPublisher);
			SearchBookPanel.tfBau.setText(bookAuthor);
			SearchBookPanel.tfBpr.setText(bookPrice2);

			// 출납테이블에서 대여 현황 읽어와 [대여정보,SearchBooktable]에 표시한다.
//			sService = new SearchBookManagementService(); // 초기화를 해야 최신값을 쓸수있다 ?
//			SearchBookList = (ArrayList<Rent>) sService.getSearchBookManagementList();

//			SearchBookFrame.table = new SearchBookTable();
//			SearchBookFrame.table.setBookSearchManagementList(SearchBookList);
//			SearchBookFrame.scrollPane.setViewportView(SearchBookFrame.table);

			// 총대여횟수
			// 대여정보의 사람의 수 = 해당도서가 총 대여한 실적 표시...!!
			// System.out.println(SearchBookFrame.table.getRowCount());
			// String count = Integer.toString(SearchBookFrame.table.getRowCount());
			
			int count1 = SearchBookFrame.table.getRowCount();
			String count2 = Integer.toString(count1);

			SearchBookTotalCountPanel.tfCount.setText(count2);

		} else {
			// 멤버가 없으면
			JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			clearMemberTf();
		}
	}
	
	
	
	public void activeBookName() {

		// 텍스트필드에 입력된 도서코드 값 가져옴.
		String getTfBook = SearchBookFrame.tfBook.getText();
//	      System.out.println(getTfBook);

		// bookImpl에서 던져진 db값 가져옴
		bService = new BookManagementService();
		bookDtoList = (ArrayList<Book>) bService.getBookDtoList();

		// 도서코드를 기준으로 도서코드가 있는지 체크
		boolean bookNameChk = false;
		String bookName = "";
		String bookCode = "";
		String bookPublisher = "";
		String bookAuthor = "";
		int bookPrice = 0;

		for (Book b : bookDtoList) {
			if (getTfBook.equalsIgnoreCase(b.getBookName())) {
				bookNameChk = true;
				bookCode = b.getNo();
				bookName = b.getBookName();
				bookPublisher = b.getPublisher();
				bookAuthor = b.getAuthor();
				bookPrice = b.getPrice();
			}
		}

		String bookPrice2 = Integer.toString(bookPrice);

		// 체크된 값을 기준으로 구분처리
		if (bookNameChk == true) {
			// 도서 코드로 조회하여 멤버가 있으면
			// System.out.println("검색됨");

			// 도서코드, 도서명, 출판사, 저자, 가격 입력

			SearchBookPanel.tfBno.setText(bookCode);
			SearchBookPanel.tfBname.setText(bookName);
			SearchBookPanel.tfBpu.setText(bookPublisher);
			SearchBookPanel.tfBau.setText(bookAuthor);
			SearchBookPanel.tfBpr.setText(bookPrice2);

			int count1 = SearchBookFrame.table.getRowCount();
			String count2 = Integer.toString(count1);

			SearchBookTotalCountPanel.tfCount.setText(count2);

		} else {
			// 멤버가 없으면
			JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			clearMemberTf();
		}
	}
	
	
	
	private void clearMemberTf() {
		SearchBookPanel.tfBno.setText("");
		SearchBookPanel.tfBname.setText("");
		SearchBookPanel.tfBpu.setText("");
		SearchBookPanel.tfBau.setText("");
		SearchBookPanel.tfBpr.setText("");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnExit() {
		return btnExit;
	}
	
	public void setbFrame(SearchBookFrame bFrame) {
		this.bFrame = bFrame;
	}
}
