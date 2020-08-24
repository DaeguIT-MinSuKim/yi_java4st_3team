package project_library.service;

import java.util.List;

import project_library.dao.BookManagementDao;
import project_library.dao.impl.BookManagementDaoImpl;
import project_library.dto.Book;

public class BookManagementService {
	private BookManagementDao dao = BookManagementDaoImpl.getInstance();

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
