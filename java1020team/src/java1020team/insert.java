package java1020team;

import java.sql.Connection;
import java.sql.SQLException;

public class insert {
	
	public int insert(String id, String pw, String nick) {
		// 하나의 기능이 시작되기 전에 꼭 데이터베이스 연결 메소드 호출하기
		getConn();
		
		sql = "insert into member2 values(?,?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);
			psmt.setString(2, b_title);
			psmt.setString(3, b_author);
			psmt.setString(4, b_publisher);
			psmt.setString(5, b_price);
			
			result = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	

}
