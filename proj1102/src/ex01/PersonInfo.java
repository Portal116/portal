package ex01;

import java.util.*;

public class PersonInfo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Ը� �Է��ϼ��� : ");
		int weight = sc.nextInt();
		System.out.print("Ű�� �Է��ϼ��� : ");
		final int height = sc.nextInt();
		
		System.out.println("������ : " + weight + " Ű : " + height);
	}
}
