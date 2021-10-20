package java1020team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			// 1. 오라클 드라이버 동적로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			
			// DB연결확인
			if(conn != null) {
				System.out.println("DB 연결성공");	
			}else {
				System.out.println("DB 연결실패");
			}
			// 3. 실행할 SQL문 작성
			//public void insert(String b_id, String b_title, String b_author, string b_publisher, int b_price)
			String sql = "insert into book values(?,?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			
			// ? 에 들어갈 데이터 설정 --> ?의 첫 시작 인덱스는 1부터
			psmt.setString(1, "도서ID");
			psmt.setString(2, "도서명");
			psmt.setString(3, "저자");
			psmt.setString(4, "출판사");
			psmt.setString(5, "가격");
			
			// 4. SQL실행
			// 실행 할 때 2가지 메소드
			// executeUpdate() : insert, update, delete와 같이 DB에 변화를 주는 SQL문장을 실행할 때!
			// executeQuery() : select문을 실행 할 때!
			psmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("클래스 경로 오타 또는 ojdbc6.jar파일 설정 다시 확인");
			
			// ClassNotFoundException 클래스를 찾을 수 없을때 발상하는 오류
			// 1. 클래스 이름이 오타나거나 경로가 잘못되었을 때
			// 2. Java Project에 ojdbc6.jar 파일 설정이 안되어 있을 때 
			
			// 오류 메세지 출력해주는 메소드
			e.printStackTrace(); 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				// 5. DB 연결종료 (사용한 객체를 역순으로 종료)
				if(psmt != null) { psmt.close(); }
				if(conn != null) { conn.close(); }
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
