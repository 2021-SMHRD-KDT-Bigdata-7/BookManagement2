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
			// 1. ����Ŭ ����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			
			// DB����Ȯ��
			if(conn != null) {
				System.out.println("DB ���Ἲ��");	
			}else {
				System.out.println("DB �������");
			}
			// 3. ������ SQL�� �ۼ�
			//public void insert(String b_id, String b_title, String b_author, string b_publisher, int b_price)
			String sql = "insert into book values(?,?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			
			// ? �� �� ������ ���� --> ?�� ù ���� �ε����� 1����
			psmt.setString(1, "����ID");
			psmt.setString(2, "������");
			psmt.setString(3, "����");
			psmt.setString(4, "���ǻ�");
			psmt.setString(5, "����");
			
			// 4. SQL����
			// ���� �� �� 2���� �޼ҵ�
			// executeUpdate() : insert, update, delete�� ���� DB�� ��ȭ�� �ִ� SQL������ ������ ��!
			// executeQuery() : select���� ���� �� ��!
			psmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Ŭ���� ��� ��Ÿ �Ǵ� ojdbc6.jar���� ���� �ٽ� Ȯ��");
			
			// ClassNotFoundException Ŭ������ ã�� �� ������ �߻��ϴ� ����
			// 1. Ŭ���� �̸��� ��Ÿ���ų� ��ΰ� �߸��Ǿ��� ��
			// 2. Java Project�� ojdbc6.jar ���� ������ �ȵǾ� ���� �� 
			
			// ���� �޼��� ������ִ� �޼ҵ�
			e.printStackTrace(); 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				// 5. DB �������� (����� ��ü�� �������� ����)
				if(psmt != null) { psmt.close(); }
				if(conn != null) { conn.close(); }
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
