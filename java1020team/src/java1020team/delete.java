package java1020team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {

	public static void main(String[] args) {
		// 실습 때 사용 할 SQL문 : insert(삽입), select(조회), update(수정), delete(삭제)
		// → CRUD

		// JDBC(Java Database Connectivity)
		// : Java와 DB를 연결하여 데이터를 읽거나 쓸 때 사용하는 API

		// 데이터베이스 연결 순서
		// 1.오라클 드라이버 로드
		// 2.DB 연결
		// 3.실행할 SQL문 준비
		// 4.SQL문 실행
		// 5.DB 연결 종료

		// 0.ojbdc6.jar 파일을 Java Project에 설정!
		// → 프로젝트 오른쪽 클릭 → Build Path → ConfigureBuild Path 클릭
		// → Libraries 탭 이동 → ModulePath 클릭 후 'Add JARs' 버튼 클릭
		// → ojdbc6.jar 파일의 위치를 설정

		// try~catch문 : 예외처리를 수행하는 구문
		// try문 : 실행할 로직을 작성
		// catch문 : try문에서 오류가 발생한 부분을 잡아내는 구문
		// finally문 : try문에서 오류가 난 후 catch문으로 가더라도 마지막에 무조건 실행하는 구문

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 1.오라클 드라이버 동적로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.DB연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("DB연결성공!");
			} else {
				System.out.println("DB연결실패...T^T");
			}

			String sql = "delete from book where b_id = ? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);

			psmt.executeUpdate();

		} catch (ClassNotFoundException e) {

			System.out.println("클래스 경로 오타 또는 ojdbc6.jar파일 설정 다시 확인!");

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				// 5.DB연결종료(사용한 객체를 역순으로 종료)
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
}
