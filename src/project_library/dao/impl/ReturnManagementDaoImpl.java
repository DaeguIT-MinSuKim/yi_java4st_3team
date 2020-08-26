package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.dao.ReturnManagementDao;
import project_library.dto.Rent;

public class ReturnManagementDaoImpl implements ReturnManagementDao {

	private static final ReturnManagementDaoImpl instance = new ReturnManagementDaoImpl();


	public static ReturnManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Rent> selectReturnManagementByAll() {
		String sql = "SELECT M.*, B.*, R.* FROM MEMBER M, BOOK B, RENT R WHERE M.MEMBER_NO = R.MEMBER_NO AND B.BOOK_NO = R.BOOK_NO";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) { //executeQuery()로 DB값 호출
			
			if (rs.next()) {
				List<Rent> list = new ArrayList<>();
				do {
					list.add(getReturnManagement(rs));
				} while (rs.next()); // 모두 삽입 완료되면 종료
				//System.out.println(list);
				return list;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	private Rent getReturnManagement(ResultSet rs) throws SQLException {
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
		
		return new Rent(MEMBER_NO, MEMBER_NAME, TEL, TOTAL_RENT, BOOK_NO, BOOK_NAME,
				AUTHOR, PUBLISHER, PRICE, IS_RENT, TOTAL_COUNT, IDX,
				MEMBER_NO2, BOOK_NO2, RENT_DATE, RETURN_DATE);
	}

	@Override
	public Rent selectReturnManagementByNo(Rent dto) {
		return null;
	}

	@Override
	public int insertReturnManagement(Rent dto) {
		return 0;
	}

	@Override
	public int updateReturnManagement(Rent dto) {
		return 0;
	}

	@Override
	public int deleteReturnManagement(Rent dto) {
		return 0;
	}

}
