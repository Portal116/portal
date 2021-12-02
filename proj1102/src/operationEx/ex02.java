package operationEx;

import java.util.*;

public class ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 2개를 입력하세요 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		
		if(a%2 == 0)
			System.out.println("짝수");
		else
			System.out.println("홀수");
	}
}
