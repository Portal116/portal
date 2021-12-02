package book;

import java.util.*;

public class p137 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 1개 입력 : ");
		int x = sc.nextInt();
		if(x>=90 && x<=100)
			System.out.println("정수 x가 90이상 100이하");
		if(x<0 || x>100)
			System.out.println("정수 x가 0보다 작거나 100보다 큼");
		if(x%3 == 0 && x%2 !=0)
			System.out.println("정수 x가 3의 배수지만 2의 배수는 아님");
		
		System.out.println("문자 하나를 입력하세요 : ");
		char ch = sc.next().charAt(0);
		if(ch == ' ' || ch == '\t' || ch == '\n')
			System.out.println("문자가 공백 or 탭 or 개행문자");
		if(ch >= 'A' && ch <= 'Z')
			System.out.println("대문자");
		if(ch >= 'a' && ch <= 'z')
			System.out.println("소문자");
		
		System.out.println("문자열 하나를 입력하세요 : ");
		String str = sc.next();
		if(str.equals("yes"))
			System.out.println("문자열이 yes");
		if(str.equalsIgnoreCase("yes"))
			System.out.println("문자열이 대소문자 상관없이 yes");
	}
}

/*

System.out.print("정수값 1개 입력 : ");
int number = sc.nextInt();

if(number >= 0)
	System.out.println("양의 정수입니다.");
else
	System.out.println("음의 정수입니다.");

if(number%5 == 0)
	System.out.println(number + "는 5의 배수입니다.");
else
	System.out.println(number + "는 5의 배수가 아닙니다.");
*/