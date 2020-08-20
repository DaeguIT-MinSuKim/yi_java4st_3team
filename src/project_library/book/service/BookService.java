package project_library.book.service;

import java.util.List;

import project_library.book.dao.BookDao;
import project_library.book.dao.BookDaoImpl;
import project_library.book.dto.Book;

public class BookService {
	private BookDao dao = BookDaoImpl.getInstance();

	public List<Book> getBookDtoList() {
		return dao.selectBookByAll();
	}

	public void insertBook(Book bdto) {
		dao.insertBook(bdto);
	}

	public void modifyBook(Book bdto) {
		dao.updateBook(bdto);
	}

	public void removeBook(Book bdto) {
		dao.deleteBook(bdto);
	}
}
