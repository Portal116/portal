package ex01;

import java.util.*;

public class PersonInfo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몸무게를 입력하세요 : ");
		int weight = sc.nextInt();
		System.out.print("키를 입력하세요 : ");
		final int height = sc.nextInt();
		
		System.out.println("몸무게 : " + weight + " 키 : " + height);
	}
}
