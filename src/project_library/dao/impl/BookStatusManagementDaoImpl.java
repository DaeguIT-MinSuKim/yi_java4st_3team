package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public int selectTotalBook() {
		String sql = "SELECT COUNT(DISTINCT BOOK_NO) FROM BOOK";
		int resultCount = 0;
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				resultCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultCount;
	}

	@Override
	public int selectTotalOverdueBook() {
		String sql = "SELECT COUNT('is_Delay') FROM VM_OVERDUE WHERE \"is_Delay\" = 'Y'";
		int resultCount = 0;
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				resultCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultCount;
	}

	@Override
	public int selectTotalRentalBook() {
		String sql = "SELECT COUNT(DISTINCT BOOK_NO) FROM RENT";
		int resultCount = 0;
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				resultCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultCount;
	}

}
