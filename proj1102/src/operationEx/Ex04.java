package operationEx;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Ǽ� 2���� �Է��ϼ��� : ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		System.out.println(a+b);
		System.out.println((a+b)/2);
		
		int newA = (int)a;
		int newB = (int)b;
		System.out.println((double) (newA + newB));
		System.out.println((double)(newA + newB)/2);
	}
}