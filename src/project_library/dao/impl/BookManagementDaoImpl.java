package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.dao.BookManagementDao;
import project_library.dto.Book;

public class BookManagementDaoImpl implements BookManagementDao {

	private static final BookManagementDaoImpl instance = new BookManagementDaoImpl();

	private BookManagementDaoImpl() {

	}

	public static BookManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Book> selectBookByAll() {
		String sql = "SELECT BOOK_NO, BOOK_NAME, AUTHOR, PUBLISHER, PRICE, IS_RENT, TOTAL_COUNT FROM BOOK";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Book> list = new ArrayList<>();
				do {
					list.add(getBook(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	private Book getBook(ResultSet rs) throws SQLException {
		String no = rs.getString("BOOK_NO");
		String name = rs.getString("BOOK_NAME");
		String aut = rs.getString("AUTHOR");
		String pub = rs.getString("PUBLISHER");
		Integer pri = rs.getInt("PRICE");
		boolean rent = rs.getBoolean("IS_RENT");
		Integer count = rs.getInt("TOTAL_COUNT");
		return new Book(no, name, aut, pub, pri, rent, count);
	}

	@Override
	public Book selectBookByNo(Book bdto) {

		return null;
	}

	@Override
	public int insertBook(Book bdto) {

		return 0;
	}

	@Override
	public int updateBook(Book bdto) {

		return 0;
	}

	@Override
	public int deleteBook(Book bdto) {

		return 0;
	}

}
