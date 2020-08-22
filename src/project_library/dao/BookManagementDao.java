package project_library.dao;

import java.util.List;

import project_library.dto.BookManagement;

public interface BookManagementDao {
	List<BookManagement> selectBookByAll();

	BookManagement selectBookByNo(BookManagement bdto);

	int insertBook(BookManagement bdto);

	int updateBook(BookManagement bdto);

	int deleteBook(BookManagement bdto);

}
