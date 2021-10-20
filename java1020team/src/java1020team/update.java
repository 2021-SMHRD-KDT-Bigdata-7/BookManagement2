package java1020team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	
	
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";		
		conn = DriverManager.getConnection(url, user, password);
		

		if(conn != null) {
			System.out.println("DB���Ἲ��!");				
		}else{
			System.out.println("DB�������!");
		}
		
		String sql = "update book set b_price =? where b_id =? ";
        //	
		
	    psmt = conn.prepareStatement(sql);		
	    psmt.setString(2, b_id);
		psmt.setString(1, b_price);
		psmt.executeUpdate();
		
		
		
		
	
	} catch (ClassNotFoundException e) {
		
		System.out.println("Ŭ���� ��� ��Ÿ �Ǵ� ojdbc6.jar���� ���� �ٽ� Ȯ��!");

		
		e.printStackTrace();
	} catch (SQLException e) {
	
		e.printStackTrace();
	}finally {
		
		try {
		
	    
		if(psmt != null) { psmt.close(); }
		if(conn != null) { conn.close(); }
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}
}


}
