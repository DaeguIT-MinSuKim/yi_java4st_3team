package project_library.book.dao;

import java.util.List;

import project_library.book.dto.Book;

public interface BookDao {
	List<Book> selectBookByAll();

	Book selectBookByNo(Book bdto);

	int insertBook(Book bdto);

	int updateBook(Book bdto);

	int deleteBook(Book bdto);

}
