package project_library.dao;

import project_library.dto.Book;

public interface BookStatusManagementDao {
	int selectTotalBook(Book bsta);
	
	int selectTotalOverdueBook(Book bsta);
	
	int selectTotalRentalBook(Book bsta);

}
