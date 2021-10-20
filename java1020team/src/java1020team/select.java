package java1020team;

import java.sql.Connection;

public class select {

	public void select(String b_id) {
		getConn();

		try {
			sql = "select*from book where b_id=?";

			pmst = conn.prepareStatement(sql);
			//result를 rs로 축약했습니다.
			rs = psmt.executeQuery();

			while (rs.next()) {
					String getb_id = rs.getString(1);
					System.out.println(getb_id + "  " + getb_title + "  " + getb_author + "  " + getb_publisher + "  "
							+ getb_price);	
			}
		} catch (Exception e) {

		} finally {
			close();
		}
		
	}
	public void selectAll() {
		getConn();

		try {
			sql = "select*from book";

			pmst = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String getb_id = rs.getString(1);
				String getb_title = rs.getString(2);
				String getb_author = rs.getString(3);
				String getb_publisher = rs.getString(4);
				int getb_price = rs.getInt(5);
				System.out.println(getb_id + "  " + getb_title + "  " + getb_author + "  " + getb_publisher + "  "
						+ getb_price);	
		}
	}
}
