package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project_library.conn.JdbcUtil;
import project_library.dao.BookStatusManagementDao;
import project_library.dto.Book;

public class BookStatusManagementDaoImpl implements BookStatusManagementDao {

	private static final BookStatusManagementDaoImpl instance = new BookStatusManagementDaoImpl();

	private BookStatusManagementDaoImpl() {

	}

	public static BookStatusManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public int selectTotalBook(Book bsta) {
		String sql = "SELECT COUNT(DISTINCT ?) FROM BOOK";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, bsta.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int selectTotalOverdueBook(Book bsta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectTotalRentalBook(Book bsta) {
		// TODO Auto-generated method stub
		return 0;
	}

}
