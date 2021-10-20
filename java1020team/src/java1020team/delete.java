package java1020team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {

	public static void main(String[] args) {
		// �ǽ� �� ��� �� SQL�� : insert(����), select(��ȸ), update(����), delete(����)
		// �� CRUD

		// JDBC(Java Database Connectivity)
		// : Java�� DB�� �����Ͽ� �����͸� �аų� �� �� ����ϴ� API

		// �����ͺ��̽� ���� ����
		// 1.����Ŭ ����̹� �ε�
		// 2.DB ����
		// 3.������ SQL�� �غ�
		// 4.SQL�� ����
		// 5.DB ���� ����

		// 0.ojbdc6.jar ������ Java Project�� ����!
		// �� ������Ʈ ������ Ŭ�� �� Build Path �� ConfigureBuild Path Ŭ��
		// �� Libraries �� �̵� �� ModulePath Ŭ�� �� 'Add JARs' ��ư Ŭ��
		// �� ojdbc6.jar ������ ��ġ�� ����

		// try~catch�� : ����ó���� �����ϴ� ����
		// try�� : ������ ������ �ۼ�
		// catch�� : try������ ������ �߻��� �κ��� ��Ƴ��� ����
		// finally�� : try������ ������ �� �� catch������ ������ �������� ������ �����ϴ� ����

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 1.����Ŭ ����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.DB����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("DB���Ἲ��!");
			} else {
				System.out.println("DB�������...T^T");
			}

			String sql = "delete from book where b_id = ? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);

			psmt.executeUpdate();

		} catch (ClassNotFoundException e) {

			System.out.println("Ŭ���� ��� ��Ÿ �Ǵ� ojdbc6.jar���� ���� �ٽ� Ȯ��!");

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				// 5.DB��������(����� ��ü�� �������� ����)
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
