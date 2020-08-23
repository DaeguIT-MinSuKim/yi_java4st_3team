package project_library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project_library.conn.JdbcUtil;
import project_library.ui.frame.RentalManagementFrame;

public class TransactionService {
	/* 트랜잭션을 위해  */
	public void transAddTtileAndDepartment(
			//RentalManagementFrame rentalManagementFrame // 대여관리 
		) {
		
		String tSql = "INSERT INTO TITLE VALUES(?, ?)";
		String dSql = "INSERT INTO DEPARTMENT VALUES(?, ?, ?)";
		
		Connection con = null;
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false); // 트랜잭션 완료되면 한번 커밋해야하기 때문에 false로 닫아놓음
			
//			try(PreparedStatement tPstmt = con.prepareStatement(tSql)){
//				//  
//				tPstmt.setInt(1, title.getNo());
//				tPstmt.setString(2, title.getName());
//				tPstmt.executeUpdate();
//			}
//			try(PreparedStatement dstmt = con.prepareStatement(dSql)){
//				dstmt.setInt(1, dept.getNo());
//				dstmt.setString(2, dept.getName());
//				dstmt.setInt(3, dept.getFloor());
//				dstmt.executeUpdate();
////				System.out.println("예외 발생");
////				throw new SQLException("예외 발생 되었음");				
//			}
//			
//			con.commit(); // 한번에 커밋
//			con.setAutoCommit(true);  // 커밋완료 후 자동 커밋으로 돌려놓음
//			System.out.println(con.getAutoCommit()); // 자동커밋 확인
			
			
		} catch (SQLException e) {
			ProcessRollback(con, e);
		}
	}

	private void ProcessRollback(Connection con, SQLException e) {
		try {
			//에러떴을 경우이기 때문에 롤백처리 해줘야함
			System.out.println("ROLLBACK");
			con.rollback();
			con.setAutoCommit(true);  // 커밋완료 후 자동 커밋으로 돌려놓음
			System.out.println(con.getAutoCommit()); // 자동커밋 확인
		} catch (SQLException ee) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException(e);
	}
	
	public void transRemoveTtileAndDepartment(
			//RentalManagementFrame rentalManagementFrame // 대여관리 
		) {
		
		String tSql = "DELETE FROM TITLE WHERE TITLE_NO = ?";
		String dSql = "DELETE FROM DEPARTMENT WHERE DEPT_NO = ?";
		
		
		Connection con = null;
        try {
            con = JdbcUtil.getConnection();
            con.setAutoCommit(false);
            System.out.println(con.getAutoCommit());
            
//            try(PreparedStatement tPstmt = con.prepareStatement(tSql)){
//                tPstmt.setInt(1, title.getNo());
//                tPstmt.executeUpdate();
//            }
//            
//            try(PreparedStatement dstmt = con.prepareStatement(dSql)){
//                dstmt.setInt(1, dept.getNo());
//                dstmt.executeUpdate();
////                System.out.println("예외 발생");
////                throw new SQLException("예외 발생 되었음");
//            }
//            con.commit();
//            con.setAutoCommit(true);
//            System.out.println(con.getAutoCommit());
            
        } catch (SQLException e) {
            ProcessRollback(con, e);
        }
	}
}
