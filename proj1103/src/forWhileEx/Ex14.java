package forWhileEx;

import java.util.*;

public class Ex14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է��ϼ���. (�� : 12345) : ");
		int num = Integer.parseInt(sc.next());
		
		int sum = 0;
		while(num>0) {
			sum += num%10;
			System.out.println("sum = " + sum + " number = " + num);
			num /= 10;
		}
		System.out.println("�� �ڸ����� �� : " + sum);
	}
}