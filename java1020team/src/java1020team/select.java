package java1020team;

import java.sql.Connection;

public class select {

	public void select() {
		getConn();

		try {
			sql = "select*from book";

			pmst = conn.prepareStatement(sql);
			//result�� rs�� ����߽��ϴ�.
			rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.print("[1]Ư��������ȸ  [2]��ü������ȸ>> ");
				int num = sc.nextInt();
				if (num == 1) {
					String getb_id = rs.getString(1);

					System.out.println(getb_id + "  " + getb_title + "  " + getb_author + "  " + getb_publisher + "  "
							+ getb_price);
				} else if(num ==2) {
					System.out.println(sql);
				} else {
					System.out.println("���� ��ȸ�� �����Ͽ����ϴ�.");
					break;
				}
			}
		} catch (Exception e) {

		} finally {
			close();
		}
		
	}
}
