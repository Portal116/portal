package operationEx;

import java.util.*;

public class Ex12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ʸ� �Է����ּ��� : ");
		int tot = sc.nextInt();
		
		int hour = tot/3600;
		int min = (tot%3600)/60;
		int sec = tot%60;
		
		System.out.println(hour + "�ð� " + min + "�� " + sec + "�� �Դϴ�.");
	}
}