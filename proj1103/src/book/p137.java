package book;

import java.util.*;

public class p137 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ 1�� �Է� : ");
		int x = sc.nextInt();
		if(x>=90 && x<=100)
			System.out.println("���� x�� 90�̻� 100����");
		if(x<0 || x>100)
			System.out.println("���� x�� 0���� �۰ų� 100���� ŭ");
		if(x%3 == 0 && x%2 !=0)
			System.out.println("���� x�� 3�� ������� 2�� ����� �ƴ�");
		
		System.out.println("���� �ϳ��� �Է��ϼ��� : ");
		char ch = sc.next().charAt(0);
		if(ch == ' ' || ch == '\t' || ch == '\n')
			System.out.println("���ڰ� ���� or �� or ���๮��");
		if(ch >= 'A' && ch <= 'Z')
			System.out.println("�빮��");
		if(ch >= 'a' && ch <= 'z')
			System.out.println("�ҹ���");
		
		System.out.println("���ڿ� �ϳ��� �Է��ϼ��� : ");
		String str = sc.next();
		if(str.equals("yes"))
			System.out.println("���ڿ��� yes");
		if(str.equalsIgnoreCase("yes"))
			System.out.println("���ڿ��� ��ҹ��� ������� yes");
	}
}

/*

System.out.print("������ 1�� �Է� : ");
int number = sc.nextInt();

if(number >= 0)
	System.out.println("���� �����Դϴ�.");
else
	System.out.println("���� �����Դϴ�.");

if(number%5 == 0)
	System.out.println(number + "�� 5�� ����Դϴ�.");
else
	System.out.println(number + "�� 5�� ����� �ƴմϴ�.");
*/