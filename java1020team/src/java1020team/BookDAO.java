package java1020team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	
	// executeUpdate()�� ����� ����� �� �ִ� ����.
	int cnt = 0;
	// Sql���� �����ϴ� ����
	String sql;

	// �����ͺ��̽��� �����ϴ� �޼ҵ�.
	public void getConnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB ����

			String url = "jdbc:oracle:thin:@192.168.1.230:1521:xe";
			String user = "hr";
			String password = "hr";

			// url, user, password
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// Excption = ��� ������ ����ټ� �ִ� ���� ���� ������.
			System.out.println("�������");
			e.printStackTrace(); // => �����޼��� ������ִ� �޼ҵ�. ������ ���� �����޼����ΰ� �������.

		}
	}

	// �����ͺ��̽��� �������ִ� �޼ҵ�.
	public void close() {

		try {
			// 5.DB���� ���� -> ����� ������ ������ �������� �����Ұ�.
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (psmt != null) {
				conn.close();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
		public int insert(BookVO ) {
			
			
			return 0;
		}
		public BookVO select(String ) {
		
			
			return 0;
		}
		public BookVO selectAll() {
		
			
			return 0;
		}
		public int update(String , int) {
		
			
			return 0;
		}
		public int delete(String ) {

			
			return 0;
		}
}
