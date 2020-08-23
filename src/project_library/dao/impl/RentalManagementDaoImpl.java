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
		String sql = "SELECT * FROM BOOK WHERE IS_RENT = 1";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<RentalManagement> list = new ArrayList<>();
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

	private RentalManagement getRentalManagement(ResultSet rs) throws SQLException {
		String BOOK_NO = rs.getString("BOOK_NO");
		String BOOK_NAME = rs.getString("BOOK_NAME");
		String AUTHOR = rs.getString("AUTHOR");
		String PUBLISHER = rs.getString("PUBLISHER");
		int PRICE = Integer.parseInt(rs.getString("PRICE"));
		int TOTAL_COUNT = Integer.parseInt(rs.getString("TOTAL_COUNT"));
		return new RentalManagement(BOOK_NO, BOOK_NAME, AUTHOR, PUBLISHER, PRICE, TOTAL_COUNT);
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
