package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.dao.SearchMemberManagementDao;
import project_library.dto.Rent;

public class SearchMemberManagementDaoImpl implements SearchMemberManagementDao {

	private static final SearchMemberManagementDaoImpl instance = new SearchMemberManagementDaoImpl();

	
	private SearchMemberManagementDaoImpl() {
	}

	public static SearchMemberManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Rent> selectSearchBookManagementByAll() {
		String sql = "SELECT B.BOOK_NO, B.BOOK_NAME, R.RENT_DATE , R.RETURN_DATE, (" + 
	      		"CASE WHEN R.RENT_DATE+3 < R.RETURN_DATE THEN 'Y' " + 
	      		"WHEN R.RENT_DATE+3 >= R.RETURN_DATE THEN 'N' " + 
	      		"ELSE '반납하지 않음' END " + 
	      		") AS IS_DELAY " + 
	      		"FROM MEMBER M, BOOK B, RENT R "; 
	      		
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			if (rs.next()) {
				List<Rent> list = new ArrayList<>();
				do {
					list.add(getBook(rs));
				} while (rs.next());
				//System.out.println(list);
				return list;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	private Rent getBook(ResultSet rs) throws SQLException {
		String BOOK_NO = rs.getString("BOOK_NO");
		String BOOK_NAME = rs.getString("BOOK_NAME");
		String RENT_DATE = rs.getString("RENT_DATE");
		String RETURN_DATE = rs.getString("RETURN_DATE");
		String IS_DELAY = rs.getString("IS_DELAY");
		
		return new Rent(BOOK_NO, BOOK_NAME,RENT_DATE, RETURN_DATE, IS_DELAY);
	}
	 @Override
	   public List<Rent> selectSearchMemberByNo(String memberCode) {
	      String sql = "SELECT B.BOOK_NO, B.BOOK_NAME, R.RENT_DATE , R.RETURN_DATE, (" + 
	      		"CASE WHEN R.RENT_DATE+3 < R.RETURN_DATE THEN 'Y' " + 
	      		"WHEN R.RENT_DATE+3 >= R.RETURN_DATE THEN 'N' " + 
	      		"ELSE '반납하지 않음' END " + 
	      		") AS IS_DELAY " + 
	      		"FROM MEMBER M, BOOK B, RENT R " + 
	      		"WHERE M.MEMBER_NO = R.MEMBER_NO AND B.BOOK_NO = R.BOOK_NO " + 
	      		"AND R.MEMBER_NO = ?";
	      try (Connection con = JdbcUtil.getConnection(); 
	            PreparedStatement pstmt = con.prepareStatement(sql)) {
	    	  	pstmt.setString(1, memberCode);
	           
	         try (ResultSet rs = pstmt.executeQuery()) {
	        	 
	            if (rs.next()) {
	            	List<Rent> list = new ArrayList<>();
	            	
	            	do {
	            		list.add(getBook(rs));
	            	} while(rs.next());
	               return list;
	            }
	         }
	      } catch (SQLException e) {
	         throw new RuntimeException(e);
	      }
	      return null;
	      
	   }
}
