package book;

import java.util.*;

public class monthEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		String season = null;
		switch(month) {
			case 3: case 4: case 5:
				season = "��";
				break;
			case 6: case 7: case 8:
				season = "����";
				break;
			case 9: case 10: case 11:
				season = "����";
				break;
			case 12: case 1: case 2:
				season = "�ܿ�";
				break;
			default:
				System.out.println("1~12 �߿��� �Է����ּ���.");
				System.exit(0);
		}
		System.out.println("������ ������ " + season + "�Դϴ�.");
	}
}