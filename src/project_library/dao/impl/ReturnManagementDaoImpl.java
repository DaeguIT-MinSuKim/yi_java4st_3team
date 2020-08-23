package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.dao.ReturnManagementDao;
import project_library.dto.ReturnManagement;

public class ReturnManagementDaoImpl implements ReturnManagementDao {

	private static final ReturnManagementDaoImpl instance = new ReturnManagementDaoImpl();


	public static ReturnManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<ReturnManagement> selectReturnManagementByAll() {
		String sql = "SELECT * FROM BOOK WHERE IS_RENT = 1";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<ReturnManagement> list = new ArrayList<>();
				do {
					list.add(getReturnManagement(rs));
					//System.out.println(list);
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	private ReturnManagement getReturnManagement(ResultSet rs) throws SQLException {
		String BOOK_NO = rs.getString("BOOK_NO");
		String BOOK_NAME = rs.getString("BOOK_NAME");
		String MEMBER_CODE = rs.getString("MEMBER_CODE");
		String MEMBER_NAME = rs.getString("MEMBER_NAME");
		String RETURN_DATE = rs.getString("RETURN_DATE");
		return null; /*new ReturnManagement(BOOK_NO, BOOK_NAME, MEMBER_CODE, MEMBER_NAME, RETURN_DATE);*/
	}

	@Override
	public ReturnManagement selectReturnManagementByNo(ReturnManagement dto) {
		return null;
	}

	@Override
	public int insertReturnManagement(ReturnManagement dto) {
		return 0;
	}

	@Override
	public int updateReturnManagement(ReturnManagement dto) {
		return 0;
	}

	@Override
	public int deleteReturnManagement(ReturnManagement dto) {
		return 0;
	}

}
