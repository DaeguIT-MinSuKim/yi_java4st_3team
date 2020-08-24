package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.dao.RentalManagementDao;
import project_library.dto.Book;
import project_library.dto.Rent;

public class RentalManagementDaoImpl implements RentalManagementDao {

	private static final RentalManagementDaoImpl instance = new RentalManagementDaoImpl();


	public static RentalManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Rent> selectRentalManagementByAll() {
		String sql = "SELECT * FROM BOOK WHERE IS_RENT = 1";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Rent> list = new ArrayList<>();
				do {
					list.add(getRentalManagement(rs));
					//System.out.println(list);
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	private Rent getRentalManagement(ResultSet rs) throws SQLException {
		String BOOK_NO = rs.getString("BOOK_NO");
		String BOOK_NAME = rs.getString("BOOK_NAME");
		String AUTHOR = rs.getString("AUTHOR");
		String PUBLISHER = rs.getString("PUBLISHER");
		int PRICE = Integer.parseInt(rs.getString("PRICE"));
		int TOTAL_COUNT = Integer.parseInt(rs.getString("TOTAL_COUNT"));
		return new Rent(BOOK_NO, BOOK_NAME, AUTHOR, PUBLISHER, PRICE, TOTAL_COUNT);
	}

	@Override
	public Rent selectRentalManagementByNo(Rent dto) {
		return null;
	}

	@Override
	public int insertRentalManagement(Rent dto) {
		String sql = "INSERT INTO RENT VALUES(IDXNUM.NEXTVAL, ?, ?, SYSDATE, NULL)";
		
		try(Connection con = JdbcUtil.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(sql)){
    			pstmt.setString(1, dto.getMemberCode());
    			pstmt.setString(2, dto.getBookCode());
    		return pstmt.executeUpdate();
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
	}

	/* 수정 */
	@Override
	public int updateRentalManagement_book(Rent dto) {
		String sql = "UPDATE BOOK" + 
				"SET TOTAL_COUNT = TOTAL_COUNT + 1, IS_RENT = 0" + 
				"WHERE BOOK_NO = ?"; 
		
		try(Connection con = JdbcUtil.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(sql)){
    			pstmt.setString(1, dto.getBookCode());
    		return pstmt.executeUpdate();
    	}catch (SQLException e){
    		throw new RuntimeException(e);
    	}
	}
	
	@Override
	public int updateRentalManagement_member(Rent dto) {
		String sql = "UPDATE MEMBER" + 
				"SET TOTAL_RENT = TOTAL_RENT + 1" + 
				"WHERE MEMBER_NO = ?";
		
    	try(Connection con = JdbcUtil.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(sql)){
    			pstmt.setString(1, dto.getMemberCode());
    		return pstmt.executeUpdate();
    	}catch (SQLException e){
    		throw new RuntimeException(e);
    	}
	}
	/* //수정 */

	/*
	@Override
	public int deleteRentalManagement(Rent dto) {
		return 0;
	}*/

}
