package java1020team;

import java.sql.Connection;
import java.sql.SQLException;

public class insert {
	
	public int insert(String id, String pw, String nick) {
		// �ϳ��� ����� ���۵Ǳ� ���� �� �����ͺ��̽� ���� �޼ҵ� ȣ���ϱ�
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
