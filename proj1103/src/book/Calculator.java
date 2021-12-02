package book;

import java.util.*;

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계산할 부호는? : ");
		String sign = sc.nextLine();
		
		System.out.print("계산할 정수 2개를 입력하세요 : ");
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
					System.out.println("나누기가 불가능합니다");
					return;
				}
				ans = a/b;
				break;
			default:
				System.out.println("정확한 기호를 입력해주세요");
				return;
		}
		System.out.println(a + sign + b + " = " + ans);
	}
}