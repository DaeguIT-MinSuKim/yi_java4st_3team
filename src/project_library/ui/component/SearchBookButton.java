package project_library.ui.component;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import project_library.dto.Book;
import project_library.dto.Member;
import project_library.dto.Rent;
import project_library.service.BookManagementService;
import project_library.service.MemberManagementService;

@SuppressWarnings("serial")
public class SearchBookButton extends JPanel implements MouseListener {
	private JButton btnSearch;
	private JButton btnExit;
	private BookManagementService bService;
	public static ArrayList<Book> bookDtoList;
	private JTextField tfBno;
	private JTextField tfBname;
	private JTextField tfBpu;
	private JTextField tfBau;
	private JTextField tfBpr;
	private JTextField tfBook;
	private SearchBookTable table;
	private JScrollPane scrollPane;
	public static ArrayList<Rent> SearchBookList;
	
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
		
		if(e.getSource() == btnSearch) {
			btnSearch_mouseClicked(e);
		}
		if(e.getSource() == btnExit) {
			btnExit_mouseClicked(e);
		}
	}
	

	private void btnExit_mouseClicked(MouseEvent e) {
		System.exit(0);
	}

	public void btnSearch_mouseClicked(MouseEvent e) {
		// 텍스트필드에 입력된 도서코드 값 가져옴.
		String getTfBook = tfBook.getText();
	
		//bookImpl에서 던져진 db값 가져옴
		bService = new BookManagementService();
		bookDtoList = (ArrayList<Book>) bService.getBookDtoList();	 
	
		 //도서코드를 기준으로 도서코드가 있는지  체크
		boolean bookCodeChk = false;
		String bookName = "";
		String bookCode ="";
		String bookPublisher ="";
		String bookAuthor ="";
		int bookPrice = 0;
		
		
		for(Book b : bookDtoList) {
			if(getTfBook.equalsIgnoreCase(b.getNo())) {
				bookCodeChk = true;
				bookCode = b.getNo();
				bookName  = b.getBookName();
				bookPublisher = b.getPublisher();
				bookAuthor = b.getAuthor();
				bookPrice = b.getPrice();
			}	
		}
		
		String bookPrice2 = Integer.toString(bookPrice);

		
		//체크된 값을  기준으로 구분처리
		if(bookCodeChk == true) {
			//도서 코드로 조회하여 멤버가 있으면
			//System.out.println("검색됨");
		
			//도서코드, 도서명, 출판사, 저자, 가격 입력
			 tfBno.setText(bookCode);
			 tfBname.setText(bookName);
			 tfBpu.setText(bookPublisher);
			 tfBau.setText(bookAuthor);
			 tfBpr.setText(bookPrice2);
			 
			 
			 //출납테이블에서 대여 현황 읽어와 [대여정보,SearchBooktable]에 표시한다.
			
			
			 
		}else {
			//멤버가 없으면
			JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			clearMemberTf();
		}
		
		
		
		
		//라디오버튼선택에따른것도 해줘야함.....
	}	
	
	private void clearMemberTf() {
		 tfBno.setText("");
		 tfBname.setText("");
		 tfBpu.setText("");
		 tfBau.setText("");
		 tfBpr.setText("");
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

}
