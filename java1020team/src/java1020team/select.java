package java1020team;

import java.sql.Connection;

public class select {

	public void select() {
		getConn();

		try {
			sql = "select*from book";

			pmst = conn.prepareStatement(sql);
			//result를 rs로 축약했습니다.
			rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.print("[1]특정도서조회  [2]전체도서조회>> ");
				int num = sc.nextInt();
				if (num == 1) {
					String getb_id = rs.getString(1);

					System.out.println(getb_id + "  " + getb_title + "  " + getb_author + "  " + getb_publisher + "  "
							+ getb_price);
				} else if(num ==2) {
					System.out.println(sql);
				} else {
					System.out.println("도서 조회를 실패하였습니다.");
					break;
				}
			}
		} catch (Exception e) {

		} finally {
			close();
		}
		
	}
}
