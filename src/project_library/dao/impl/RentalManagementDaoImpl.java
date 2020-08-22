package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.dao.RentalManagementDao;
import project_library.dto.RentalManagement;

public class RentalManagementDaoImpl implements RentalManagementDao {

	private static final RentalManagementDaoImpl instance = new RentalManagementDaoImpl();


	public static RentalManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<RentalManagement> selectRentalManagementByAll() {
		String sql = "SELECT BOOK_NO, BOOK_NAME, AUTHOR, PUBLISHER, PRICE, IS_RENT, TOTAL_COUNT FROM BOOK";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<RentalManagement> list = new ArrayList<>();
				do {
					list.add(getRentalManagement(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	private RentalManagement getRentalManagement(ResultSet rs) throws SQLException {
		String MEMBER_NO = rs.getString("MEMBER_NO");
		String BOOK_NO = rs.getString("BOOK_NO");
		String RENT_DATE = rs.getString("RENT_DATE");
		String RETURN_DATE = rs.getString("RETURN_DATE");
		return new RentalManagement(MEMBER_NO, BOOK_NO, RENT_DATE, RETURN_DATE, 0, 0);
	}

	@Override
	public RentalManagement selectRentalManagementByNo(RentalManagement dto) {
		return null;
	}

	@Override
	public int insertRentalManagement(RentalManagement dto) {
		return 0;
	}

	@Override
	public int updateRentalManagement(RentalManagement dto) {
		return 0;
	}

	@Override
	public int deleteRentalManagement(RentalManagement dto) {
		return 0;
	}

}
