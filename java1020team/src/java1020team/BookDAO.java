package java1020team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public int insert(String b_id, String b_title, String b_author, String b_publisher, int b_price) {

		getConnect();

		sql = "insert into member2 values(?,?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);
			psmt.setString(2, b_title);
			psmt.setString(3, b_author);
			psmt.setString(4, b_publisher);
			psmt.setInt(5, b_price);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	
	public BookVO select( ) {
		
			
			return 0;
		}

	public BookVO selectAll() {

		return 0;
	}

	public int update(String b_id, int b_price) {
		getConnect();

		try {
			String sql = "update book set b_price =? where b_id =? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(2, b_id);
			psmt.setInt(1, b_price);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int delete(String b_id) {

		try {
			String sql = "delete from book where b_id = ? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);

			psmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			close();
		}
		return cnt;

	}

}
