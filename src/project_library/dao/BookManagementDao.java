package project_library.dao;

import java.util.List;

import project_library.dto.Book;

public interface BookManagementDao {
	List<Book> selectBookByAll();

	Book selectBookByNo(Book bdto);

	int insertBook(Book bdto);

	int updateBook(Book bdto);

	int deleteBook(Book bdto);

}
