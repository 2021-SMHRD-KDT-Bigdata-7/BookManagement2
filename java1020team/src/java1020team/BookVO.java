package java1020team;

public class BookVO {
 
	String b_id;
	String b_title;
	String b_author;
	String b_publisher;
	int b_price;
	
	public BookVO() {}
	
	public BookVO(String b_id, String b_title, String b_author, String b_publisher, int b_price) {
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_author = b_author;
		this.b_publisher = b_publisher;
		this.b_price = b_price;
	}



	public String getB_id() {
		return b_id;
	}




	public String getB_title() {
		return b_title;
	}



	public String getB_author() {
		return b_author;
	}



	public String getB_publisher() {
		return b_publisher;
	}



	public int getB_price() {
		return b_price;
	}
	
	
	@Override
	public String toString() {
		return "BookVO [b_id=" + b_id + ", b_title=" + b_title + ", b_author=" + b_author + ", b_publisher="
				+ b_publisher + ", b_price=" + b_price + "]";
	}
	

	
	

}