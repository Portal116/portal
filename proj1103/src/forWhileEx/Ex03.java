package forWhileEx;

import java.util.*;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num<0) {
			System.out.print("-");
			num = Math.abs(num);
		}
		
		do {
			System.out.print(num%10);
			num /= 10;			
		}
		while(num>0);
	}
}