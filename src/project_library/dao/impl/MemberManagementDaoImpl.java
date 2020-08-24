package project_library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_library.conn.JdbcUtil;
import project_library.dao.MemberManagementDao;
import project_library.dto.Member;

public class MemberManagementDaoImpl implements MemberManagementDao {

	private static final MemberManagementDaoImpl instance = new MemberManagementDaoImpl();

	private MemberManagementDaoImpl() {

	}

	public static MemberManagementDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Member> selectMemberByAll() {
		String sql = "SELECT MEMBER_NO , MEMBER_NAME , TEL , TOTAL_RENT FROM MEMBER";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Member> list = new ArrayList<>();
				do {
					list.add(getMember(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	private Member getMember(ResultSet rs) throws SQLException {
		String no = rs.getString("MEMBER_NO");
		String name = rs.getString("MEMBER_NAME");
		String tel = rs.getString("TEL");
		return new Member(no, name, tel);
	}

	@Override
	public Member selectMemberByNo(Member mdto) {

		return null;
	}

	@Override
	public int insertMember(Member mdto) {
		String sql = "INSERT INTO MEMBER values(?, ?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, mdto.getNo());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getTel());
			pstmt.setInt(4, mdto.getRent());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int updateMember(Member mdto) {
		String sql = "UPDATE MEMBER SET MEMBER_NAME = ?, TEL = ?, TOTAL_RENT = ? WHERE MEMBER_NO = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getTel());
			pstmt.setInt(3, mdto.getRent());
			pstmt.setString(4, mdto.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteMember(Member mdto) {
		String sql = "DELETE FROM MEMBER WHERE MEMBER_NO = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, mdto.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
