package java1020team;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
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
			String b_price = sc.nextInt();
			
			
			// DAO Ŭ������ �ִ� insert()�� �����Ҽ� �ִ� ��ü�����ϱ�
			int cnt =dao.insert(���� �־������);
			
			if(cnt > 0) {
			System.out.println("���� �Ϸ�");			
			} else {
				System.out.println("���� ����");
			}

		} else if (menu == 2) {
			dao.select();
			
		} else if (menu == 3) {

			try {
			System.out.print("������ ���� ���̵� : ");
			String b_id = sc.next();
			
			System.out.print("���� : ");
			String b_price = sc.nextInt();
			
			
			int ubt = dao.update(b_id, b_price);
			if(ubt > 0) {
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");			
				} else {
					System.out.println("���� ����.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return result;

	
		} else if (menu == 4) {

			System.out.print("������ ���� ���̵� : ");
			String b_id = sc.next();
			
		
			int dlt = dao.delete(b_id);
			if(dlt > 0) {
				System.out.println("���� �Ϸ�.");			
				} else {
					System.out.println("���� ����.");
				}

		} else {
			System.out.println("���α׷� ����");
			break;
		}
		
	}

}
