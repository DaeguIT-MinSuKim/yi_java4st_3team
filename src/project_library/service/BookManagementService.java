package project_library.service;

import java.util.List;

import project_library.dao.BookManagementDao;
import project_library.dao.impl.BookManagementDaoImpl;
import project_library.dto.BookManagement;

public class BookManagementService {
	private BookManagementDao dao = BookManagementDaoImpl.getInstance();

	public List<BookManagement> getBookDtoList() {
		return dao.selectBookByAll();
	}

	public void insertBook(BookManagement bdto) {
		dao.insertBook(bdto);
	}

	public void modifyBook(BookManagement bdto) {
		dao.updateBook(bdto);
	}

	public void removeBook(BookManagement bdto) {
		dao.deleteBook(bdto);
	}
}
