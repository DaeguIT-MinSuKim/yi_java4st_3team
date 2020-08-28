package project_library.service;

import project_library.dao.BookStatusManagementDao;
import project_library.dao.impl.BookStatusManagementDaoImpl;

public class BookStatusManagementService {

	private BookStatusManagementDao dao = BookStatusManagementDaoImpl.getInstance();

	public int selectTotalBook() {
		return dao.selectTotalBook();
	}

	public int selectTotalOverdueBook() {
		return dao.selectTotalOverdueBook();
	}

	public int selectTotalRentalBook() {
		return dao.selectTotalRentalBook();
	}

}
