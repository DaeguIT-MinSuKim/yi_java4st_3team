package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.dao.SearchBookManagementDao;
import project_library.dto.Book;
import project_library.dto.Rent;

public class SearchBookManagementDaoImpl implements SearchBookManagementDao {

	private static final SearchBookManagementDaoImpl instance = new SearchBookManagementDaoImpl();

	private SearchBookManagementDaoImpl() {

	}

	public static SearchBookManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Rent> selectSearchBookManagementByAll() {
		String sql = "SELECT BOOK_NO, BOOK_NAME, AUTHOR, PUBLISHER, PRICE, IS_RENT, TOTAL_COUNT FROM BOOK";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			if (rs.next()) {
				List<Rent> list = new ArrayList<>();
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
	
	private Rent getBook(ResultSet rs) throws SQLException {
		String MEMBER_NO = rs.getString("MEMBER_NO");
		String MEMBER_NAME = rs.getString("MEMBER_NAME");
		String TEL = rs.getString("TEL");
		int TOTAL_RENT = rs.getInt("TOTAL_RENT");
		String BOOK_NO = rs.getString("BOOK_NO");
		String BOOK_NAME = rs.getString("BOOK_NAME");
		String AUTHOR = rs.getString("AUTHOR");
		String PUBLISHER = rs.getString("PUBLISHER");
		int PRICE = rs.getInt("PRICE");
		int IS_RENT = rs.getInt("IS_RENT");
		int TOTAL_COUNT = rs.getInt("TOTAL_COUNT");
		int IDX = rs.getInt("IDX");
		String MEMBER_NO2 = rs.getString("MEMBER_NO");
		String BOOK_NO2 = rs.getString("BOOK_NO");
		String RENT_DATE = rs.getString("RENT_DATE");
		String RETURN_DATE = rs.getString("RETURN_DATE");
		String IS_DELAY = rs.getString("IS_DELAY");
		
		
		return new Rent(MEMBER_NO, MEMBER_NAME, TEL, TOTAL_RENT, BOOK_NO, BOOK_NAME,
				AUTHOR, PUBLISHER, PRICE, IS_RENT, TOTAL_COUNT, IDX,
				MEMBER_NO2, BOOK_NO2, RENT_DATE, RETURN_DATE, IS_DELAY);
	}

	@Override
	public Rent selectSearchBookManagementByNo(Rent dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSearchBookManagement(Rent dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSearchBookManagement_book(Rent dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSearchBookManagement_member(Rent dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
