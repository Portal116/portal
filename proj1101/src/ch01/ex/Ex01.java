package ch01.ex;

import java.util.*;

public class Ex01 {
	public static void main(String[] args) {
		int input1;
		Scanner sc = new Scanner(System.in);
		System.out.print("실수를 입려가세요 ===> ");
		double pi = sc.nextDouble();
		// float PI = sc.nextFloat(); 입력받을 때 3.14f처럼 굳이 f 붙일 필요 없음
		System.out.printf("실수형 ===> %.9f\n", pi);;

		String pipi = sc.next();
		String pipi2 = sc.nextLine();
		System.out.println(pipi);
		System.out.println(pipi2);
	}
}