package operationEx;

import java.util.*;

public class Ex13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ ������ �Է����ּ��� : ");
		int pencil = sc.nextInt();
		
		System.out.print("�л��� �� ������ �Է����ּ��� : ");
		int student = sc.nextInt();
		
		System.out.println("�л� �� " + pencil/student + 
				"���� ������ " + pencil%student + "���� �����ϴ�.");
	}
}