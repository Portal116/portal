package operationEx;

import java.util.*;

public class Ex08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		System.out.println(num/10000 + "�� " + 
				(num/1000)%10 + "õ " + 
				(num/100)%10 + "�� " +
				(num/10)%10 + "�� " +
				num%10 + "�Դϴ�.");
	}
}