package forWhileEx;

import java.util.*;

public class Ex11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����(1), ����(2), ��(3)�� �ϳ��� �Է��ϼ��� : ");
		int rsp = sc.nextInt();
		int com = (int)(Math.random()*3) + 1;
		
		System.out.println("����� " + rsp + "�Դϴ�.");
		System.out.println("��ǻ�ʹ� " + com + "�Դϴ�.");
		
		switch(rsp - com) {
			case 0:
				System.out.println("�����ϴ�.");
				break;
			case -1: case 2:
				System.out.println("��ǻ�� �¸��Դϴ�.");
				break;
			case -2: case 1:
				System.out.println("����� �¸��Դϴ�..");
				break;
		}
	}
}