package project_library.rentalManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.rentalManagement.dto.RentalManagement;

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
		String no = rs.getString("BOOK_NO");
		String name = rs.getString("BOOK_NAME");
		String aut = rs.getString("AUTHOR");
		String pub = rs.getString("PUBLISHER");
		Integer pri = rs.getInt("PRICE");
		boolean rent = rs.getBoolean("IS_RENT");
		Integer count = rs.getInt("TOTAL_COUNT");
		return new rentalManagement(no, name, aut, pub, pri, rent, count);
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
