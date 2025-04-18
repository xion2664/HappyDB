package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DTO.CardDTO;

public class CardDAO {
	private DBConnectionMgr pool = null;
	
	private static CardDAO instance;
	
	public CardDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception e){
			System.out.println("Error: 커넥팅 얻기 실패");
		}
	}
	
	public static CardDAO getInstance() {
		if(instance == null)
			instance = new CardDAO();
		return instance;
	}
	
	// 명함 추가
	public int insertCard(CardDTO cardDTO) {
		String sql = "INSERT INTO card(name, mobile, tel, address, email, company, staff, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardDTO.getName());
			pstmt.setString(2, cardDTO.getMobile());
			pstmt.setString(3, cardDTO.getTel());
			pstmt.setString(4, cardDTO.getAddress());
			pstmt.setString(5, cardDTO.getEmail());
			pstmt.setString(6, cardDTO.getCompany());
			pstmt.setString(7, cardDTO.getStaff());
			pstmt.setString(8, cardDTO.getUserId());
			return pstmt.executeUpdate(); // 1 반환
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
		return -1; // error
	}
	
	// 명함 삭제
	public int deleteCard(String userId, int n) {
		String sql = "DELETE FROM card WHERE userid = ? and id = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, n);
			return pstmt.executeUpdate(); // 1 반환
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
		return -1; // 오류
	}
	
	// 명함 리스트
	public List<CardDTO> getCardList(String userId){
		List<CardDTO> cardList = new ArrayList<CardDTO>();
		String sql = "SELECT * FROM card WHERE userid = ? ORDER BY id DESC";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CardDTO card = new CardDTO(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8),
							rs.getInt(9)
						);
				cardList.add(card);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return cardList;
	}
	

	// 검색
	public List<CardDTO> searchCardList(String userId, String key, String cri){
		List<CardDTO> cardList = new ArrayList<CardDTO>();
		String sql = "SELECT * FROM card WHERE "+ cri +" LIKE '%" + key + "%' AND userid = \""+ userId +"\"";
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CardDTO card = new CardDTO(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getInt(9)
					);
				cardList.add(card);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, stmt, rs);
		}
		return cardList;
	}
	
	// update 카드 정보 얻기
	public CardDTO getCard(String userId, int n){
		CardDTO card = null;
		String sql = "SELECT * FROM card WHERE userid = ? and id = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, n);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				card = new CardDTO(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8),
							rs.getInt(9)
						);
				return card;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return card;
	}
	
	// 명함 수정
	public int updateCard(CardDTO card , int key) {
		String sql = "UPDATE card set name=?, mobile=?, tel=?, address=?, email=?, company=?, staff=?"
				+ "WHERE userid = ? and id = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, card.getName());
			pstmt.setString(2, card.getMobile());
			pstmt.setString(3, card.getTel());
			pstmt.setString(4, card.getAddress());
			pstmt.setString(5, card.getEmail());
			pstmt.setString(6, card.getCompany());
			pstmt.setString(7, card.getStaff());
			pstmt.setString(8, card.getUserId());
			pstmt.setInt(9, key);
			return pstmt.executeUpdate(); // 1 반환
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
		return -1; // 오류
	}
}
