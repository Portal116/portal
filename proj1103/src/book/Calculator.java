package book;

import java.util.*;

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����� ��ȣ��? : ");
		String sign = sc.nextLine();
		
		System.out.print("����� ���� 2���� �Է��ϼ��� : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int ans = 0;
		switch(sign) {
			case "+":
				ans = a+b;
				break;
			case "-":
				ans = a-b;
				break;
			case "*":
				ans = a*b;
				break;
			case "/":
				if(b == 0) {
					System.out.println("�����Ⱑ �Ұ����մϴ�");
					return;
				}
				ans = a/b;
				break;
			default:
				System.out.println("��Ȯ�� ��ȣ�� �Է����ּ���");
				return;
		}
		System.out.println(a + sign + b + " = " + ans);
	}
}