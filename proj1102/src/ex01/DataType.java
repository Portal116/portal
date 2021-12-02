package ex01;

import java.util.*;

public class DataType {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.printf("10진수 : %d\n",num);
		System.out.printf("10진수 : %x\n",num);
		System.out.printf("10진수 : %o\n",num);
	}
}