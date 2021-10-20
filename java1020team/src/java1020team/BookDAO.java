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
	   Book book = null;

	   // executeUpdate()의 결과를 담아줄 수 있는 변수.
	   int cnt = 0;
	   // Sql문을 저정하는 변수
	   String sql;

	   // 데이터베이스를 연결하는 메소드.
	   public void getConnect() {

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url = "jdbc:oracle:thin:@192.168.1.230:1521:xe";
	         String user = "hr";
	         String password = "hr";
	         conn = DriverManager.getConnection(url, user, password);

	      } catch (Exception e) {
	         System.out.println("연결오류");
	         e.printStackTrace(); // => 오류메세지 출력해주는 메소드. 무엇에 대한 오류메세지인가 출력해줌.

	      }
	   }

	   // 데이터베이스를 종료해주는 메소드.
	   public void close() {

	      try {
	         // 5.DB연결 종료 -> 종료는 연결한 순서의 역순으로 종료할것.
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

	      sql = "insert into Book values(?,?,?,?,?)";

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

	   public void select(String id) {
	      
	      getConnect();

	      try {
	         sql = "select * from book where b_id=?";

	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, id);
	         rs = psmt.executeQuery();

	         while (rs.next()) {
	            String getb_id = rs.getString(1);
	            String getb_title = rs.getString(2);
	            String getb_author = rs.getString(3);
	            String getb_publisher = rs.getString(4);
	            int getb_price = rs.getInt(5);
	            System.out.println(
	                  getb_id + "  " + getb_title + "  " + getb_author + "  " + getb_publisher + "  " + getb_price);
	         }

	      } catch (Exception e) {

	         e.printStackTrace();

	      } finally {
	         close();

	      }

	   }

	   public void selectAll() {
	      
	      getConnect();

	      try {
	         sql = "select * from book";

	         psmt = conn.prepareStatement(sql);
	         rs = psmt.executeQuery();

	         while (rs.next()) {
	            String getb_id = rs.getString(1);
	            String getb_title = rs.getString(2);
	            String getb_author = rs.getString(3);
	            String getb_publisher = rs.getString(4);
	            int getb_price = rs.getInt(5);
	            System.out.println(
	                  getb_id + "  " + getb_title + "  " + getb_author + "  " + getb_publisher + "  " + getb_price);
	         }
	      } catch (Exception e) {

	         e.printStackTrace();

	      } finally {
	         close();
	      }
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

	      getConnect();
	      
	      try {
	         String sql = "delete from book where b_id = ? ";

	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, b_id);

	         cnt = psmt.executeUpdate();

	      } catch (Exception e) {

	         e.printStackTrace();

	      } finally {
	         close();
	      }

	      return cnt;
	   }

	}
