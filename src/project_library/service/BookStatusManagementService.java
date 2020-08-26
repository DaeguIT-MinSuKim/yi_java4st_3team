package project_library.service;

import project_library.dao.BookStatusManagementDao;
import project_library.dao.impl.BookStatusManagementDaoImpl;
import project_library.dto.Book;

public class BookStatusManagementService {
	private BookStatusManagementDao dao = BookStatusManagementDaoImpl.getInstance();

	public void selectTotalBook(Book bsta) {
		dao.selectTotalBook(bsta);
	}

	public void selectTotalOverdueBook(Book bsta) {
		dao.selectTotalOverdueBook(bsta);
	}

	public void selectTotalRentalBook(Book bsta) {
		dao.selectTotalRentalBook(bsta);
	}

}
