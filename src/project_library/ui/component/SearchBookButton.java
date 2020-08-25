package project_library.ui.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project_library.dto.Book;
import project_library.service.BookManagementService;

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
	public SearchBookButton() {
		
		btnSearch = new JButton("검색");
		btnSearch.addMouseListener(this);
		add(btnSearch);
		
		btnExit = new JButton("닫기");
		add(btnExit);

	}
	
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnSearch) {
			btnSearch_mouseClicked(e);
		}
	}
	

	private void btnSearch_mouseClicked(MouseEvent e) {
		// 텍스트필드에 입력된 도서코드 값 가져옴.
		String getTfBook = tfBook.getText();
	
	
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
			//멤버가 있으면
			//System.out.println("검색됨");
		
			 tfBno.setText(bookCode);
			 tfBname.setText(bookName);
			 tfBpu.setText(bookPublisher);
			 tfBau.setText(bookAuthor);
			 tfBpr.setText(bookPrice2);
			 
			 
			 //출납테이블에서 대여현황을 읽어와 대여정보 테이블에 표시한다. 
			//bookImpl에서 던져진 db값 가져옴
			bService = new BookManagementService();
			bookDtoList = (ArrayList<Book>) bService.getBookDtoList();	 
			 
		
			 //라디오버튼선택에따른것도 해줘야함.....
		}
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
