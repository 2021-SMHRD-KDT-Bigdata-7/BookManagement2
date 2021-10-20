package java1020team;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BookDAO dao = new BookDAO();

		int cnt = 0;

		System.out.println("[Java �������� ���α׷�]");

		while (true) {
			System.out.print("[1]������� [2]������ȸ [3]�������� [4]�������� [5]���� >> ");

			int menu = sc.nextInt();

			if (menu == 1) {

				System.out.print("���� ���̵� : ");
				String b_id = sc.next();

				System.out.print("������ : ");
				String b_title = sc.next();

				System.out.print("���� : ");
				String b_author = sc.next();

				System.out.print("���ǻ� : ");
				String b_publisher = sc.next();

				System.out.print("���� : ");
				int b_price = sc.nextInt();

				// DAO Ŭ������ �ִ� insert()�� �����Ҽ� �ִ� ��ü�����ϱ�
				cnt = dao.insert(b_id, b_title, b_author, b_publisher, b_price);

				if (cnt > 0) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("���� ����");
				}

			} else if (menu == 2) {
				System.out.print("[1] Ư������ �˻� [2] ��ü �˻� >> ");
				int sel = sc.nextInt();
				
				if (sel == 1) {
					System.out.print("�˻� ���̵� >> ");
					String id = sc.next();
					dao.select(id);
				} else if (sel == 2) {
					dao.selectAll();
				} 
			}else if (menu == 3) {

					System.out.print("������ ���� ���̵� : ");
					String b_id = sc.next();

					System.out.print("���� : ");
					int b_price = sc.nextInt();

					cnt = dao.update(b_id, b_price);

					if (cnt > 0) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					} else {
						System.out.println("���� ����.");
					}
				} else if (menu == 4) {

					System.out.print("������ ���� ���̵� : ");
					String b_id = sc.next();

					cnt = dao.delete(b_id);
					if (cnt > 0) {
						System.out.println("���� �Ϸ�.");
					} else {
						System.out.println("���� ����.");
					}
				} else {
					System.out.println("���α׷� ����");
					break;
				}
			}  // while
		}
}
