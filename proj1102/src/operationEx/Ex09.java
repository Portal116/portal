package operationEx;

import java.util.*;

public class Ex09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �� �Է��ϱ�(1~12) : ");
		int mon = sc.nextInt();
		
		if(mon > 12) {
			System.out.println("1~12 �߿� �Է����ּ���.");
			System.exit(0);
		}
		String s;
		
		s = (mon <= 6) ? "��ݱ�" : "�Ϲݱ�";
		System.out.println(s + "�Դϴ�.");
	}
}