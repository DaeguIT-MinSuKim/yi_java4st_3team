package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project_library.dto.Book;
import project_library.service.BookManagementService;
import project_library.ui.component.BookManagementButton;
import project_library.ui.component.BookManagementPanel;
import project_library.ui.component.BookManagementTable;

@SuppressWarnings("serial")
public class BookManagementFrame extends JFrame {

	private JPanel contentPane;
	public static BookManagementPanel pBPanel;
	private BookManagementButton pBBtns;
	private JPanel pBTable;
	private JScrollPane scrollPane;
	public static BookManagementTable bookTable;
	public static ArrayList<Book> bookList;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookManagementFrame frame = new BookManagementFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public BookManagementFrame() {

		BookManagementService bService = new BookManagementService();
		bookList = (ArrayList<Book>) bService.getBookDtoList();
		/*
		 * bList = new ArrayList<Book>(); bList.add(new Book("B001", "리눅스 시스템 구축",
		 * "신윤환", "북수홀릭", 33000, true, 0)); bList.add(new Book("B002", "HTML5 + CSS3",
		 * "고경희", "이지스퍼블리싱", 25000, true, 0)); bList.add(new Book("B003", "자바스크립트 기본 편",
		 * "고경희", "이지스퍼블리싱", 25000, true, 0)); bList.add(new Book("B004",
		 * "자바스크립트 + 제이쿼리 입문", "정인용", "이지스퍼블리싱", 20000, true, 0)); bList.add(new
		 * Book("B005", "Java의 정석", "남궁성", "도우출판", 25000, true, 0)); bList.add(new
		 * Book("B006", "오라클로 배우는 데이터베이스", "이지훈", "이지스퍼블리싱", 25000, true, 0));
		 * bList.add(new Book("B007", "자바 프로젝트 필수 유틸리티", "전민수", "한빛미디어", 35000, true,
		 * 0)); bList.add(new Book("B008", "자바 프로그래밍 입문", "박은종", "이지스퍼블리싱", 25000, true,
		 * 0)); bList.add(new Book("B009", "C 언어 입문", "김성엽", "이지스퍼블리싱", 25000, true,
		 * 0));
		 */
		initComponents();

		bookTable = new BookManagementTable();
		bookTable.setBookList(bookList);
		scrollPane.setViewportView(bookTable);

		pBPanel.setEditalbeFalseTf();
	}

	private void initComponents() {
		setTitle("도서 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pBPanel = new BookManagementPanel();
		pBPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(pBPanel);

		pBBtns = new BookManagementButton();
		pBBtns.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(pBBtns);

		pBTable = new JPanel();
		pBTable.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "[ 도서 목록 ]", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(pBTable);
		pBTable.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pBTable.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(bookTable);
	}

}
