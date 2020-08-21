package project_library.book.management;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project_library.book.component.BookButton;
import project_library.book.component.BookPanel;
import project_library.book.component.BookTable;
import project_library.book.dto.Book;
import project_library.book.service.BookService;

@SuppressWarnings("serial")
public class BookManagement extends JFrame {

	private JPanel contentPane;
	public static BookPanel pBPanel;
	private BookButton pBBtns;
	private JPanel pBTable;
	private JScrollPane scrollPane;
	public static BookTable table;
	public static ArrayList<Book> bookList;

	public BookManagement() {
		BookService bService = new BookService();
		bookList = (ArrayList<Book>) bService.getBookDtoList();
		
/*
		bList = new ArrayList<Book>();
		bList.add(new Book("B001", "리눅스 시스템 구축", "신윤환", "북수홀릭", 33000, true, 0));
		bList.add(new Book("B002", "HTML5 + CSS3", "고경희", "이지스퍼블리싱", 25000, true, 0));
		bList.add(new Book("B003", "자바스크립트 기본 편", "고경희", "이지스퍼블리싱", 25000, true, 0));
		bList.add(new Book("B004", "자바스크립트 + 제이쿼리 입문", "정인용", "이지스퍼블리싱", 20000, true, 0));
		bList.add(new Book("B005", "Java의 정석", "남궁성", "도우출판", 25000, true, 0));
		bList.add(new Book("B006", "오라클로 배우는 데이터베이스", "이지훈", "이지스퍼블리싱", 25000, true, 0));
		bList.add(new Book("B007", "자바 프로젝트 필수 유틸리티", "전민수", "한빛미디어", 35000, true, 0));
		bList.add(new Book("B008", "자바 프로그래밍 입문", "박은종", "이지스퍼블리싱", 25000, true, 0));
		bList.add(new Book("B009", "C 언어 입문", "김성엽", "이지스퍼블리싱", 25000, true, 0));
*/
		initComponents();

		table = new BookTable();
		table.setBookList(bookList);
		scrollPane.setViewportView(table);

		pBPanel.setEditalbeFalseTf();
	}

	private void initComponents() {
		setTitle("도서 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pBPanel = new BookPanel();
		pBPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(pBPanel);

		pBBtns = new BookButton();
		pBBtns.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(pBBtns);

		pBTable = new JPanel();
		pBTable.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "[ 도서 목록 ]", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pBTable);
		pBTable.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pBTable.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(table);
	}

}
