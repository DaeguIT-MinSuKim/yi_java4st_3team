package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

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
		String sql = "SELECT M.*, B.*, R.* FROM MEMBER M, BOOK B, RENT R WHERE M.MEMBER_NO = R.MEMBER_NO AND B.BOOK_NO = R.BOOK_NO ORDER BY R.BOOK_NO";
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
	public int updateReturnManagement_isRent(Rent dto) {
		String sql = "UPDATE BOOK SET IS_RENT = 1 WHERE BOOK_NO = ?";
		
		/* 대여가능여부 > 대여가능으로 변경, 도서코드 기준으로 */
		try(Connection con = JdbcUtil.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(sql)){
    			pstmt.setString(1, dto.getBookCode());
    		return pstmt.executeUpdate();
    	}catch (SQLException e){
    		throw new RuntimeException(e);
    	}
	}

	@Override
	public int updateReturnManagement_returnDate(Rent dto) {
		/* 반납일 삽입, IDX 기준으로 */
		String sql = "UPDATE RENT SET RETURN_DATE = ? WHERE IDX = ?";
		String from = dto.getReturnDate() + " 00:00:00";
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){

			try {
				Date RDate = transFormat.parse(from);
				pstmt.setTimestamp(1, new Timestamp(RDate.getTime()) );
				pstmt.setInt(2, dto.getIdx());
			} catch (ParseException e){
				e.printStackTrace();
			}
    		return pstmt.executeUpdate();
    	}catch (SQLException e){
    		throw new RuntimeException(e);
    	}
	}
	
	@Override
	public int deleteReturnManagement(Rent dto) {
		return 0;
	}

}
