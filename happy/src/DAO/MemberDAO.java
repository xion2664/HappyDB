package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.MemberDTO;

public class MemberDAO {
	private DBConnectionMgr pool = null;
	
	private static MemberDAO instance;
	
	public MemberDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception e){
			System.out.println("Error: 커넥트 얻기 실패");
		}
	}
	
	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}
	
	// 회원가입
	public int join(MemberDTO user) {
		String sql = "INSERT INTO user(name, userId, pwd) VALUES (?, ?, ?)";
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId());
			pstmt.setString(3, user.getPassword());
			return pstmt.executeUpdate(); // 1 반환
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}
		return -1; // 오류
	}
	
	// 중복 id 체크
	public boolean idCheck(String userId) {
		String sql = "SELECT id FROM user WHERE userId = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rs.getString(1).equals(userId);
				return true; // 중복된 아이디 존재
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return false; // 중복된 아이디 없음
	}
	
	// 로그인
	public int login(String userID, String userPassword) {
		String sql = "SELECT pwd FROM user WHERE userId = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; // 로그인 성공
				}
				else
					return 0; // 비밀먼호 오류
			}
			return -1; // 로그인 실패
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return -2; // DB 오류
	}
}
