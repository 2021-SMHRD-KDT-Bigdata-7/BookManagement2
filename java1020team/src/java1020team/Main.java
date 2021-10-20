package java1020team;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BookDAO dao = new BookDAO();

		int cnt = 0;

		System.out.println("[Java 도서관리 프로그램]");

		while (true) {
			System.out.print("[1]도서등록 [2]도서조회 [3]정보수정 [4]도서삭제 [5]종료 >> ");

			int menu = sc.nextInt();

			if (menu == 1) {

				System.out.print("도서 아이디 : ");
				String b_id = sc.next();

				System.out.print("도서명 : ");
				String b_title = sc.next();

				System.out.print("저자 : ");
				String b_author = sc.next();

				System.out.print("출판사 : ");
				String b_publisher = sc.next();

				System.out.print("가격 : ");
				int b_price = sc.nextInt();

				// DAO 클래스에 있는 insert()에 접근할수 있는 객체생성하기
				cnt = dao.insert(b_id, b_title, b_author, b_publisher, b_price);

				if (cnt > 0) {
					System.out.println("저장 완료");
				} else {
					System.out.println("저장 실패");
				}

			} else if (menu == 2) {
				System.out.print("[1] 특정도서 검색 [2] 전체 검색 >> ");
				int sel = sc.nextInt();
				
				if (sel == 1) {
					System.out.print("검색 아이디 >> ");
					String id = sc.next();
					dao.select(id);
				} else if (sel == 2) {
					dao.selectAll();
				} 
			}else if (menu == 3) {

					System.out.print("수정할 도서 아이디 : ");
					String b_id = sc.next();

					System.out.print("가격 : ");
					int b_price = sc.nextInt();

					cnt = dao.update(b_id, b_price);

					if (cnt > 0) {
						System.out.println("수정이 완료되었습니다.");
					} else {
						System.out.println("수정 실패.");
					}
				} else if (menu == 4) {

					System.out.print("삭제할 도서 아이디 : ");
					String b_id = sc.next();

					cnt = dao.delete(b_id);
					if (cnt > 0) {
						System.out.println("삭제 완료.");
					} else {
						System.out.println("삭제 실패.");
					}
				} else {
					System.out.println("프로그램 종료");
					break;
				}
			}  // while
		}
}
