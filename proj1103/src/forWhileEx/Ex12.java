package forWhileEx;

import java.util.*;

public class Ex12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = (int)(Math.random()*100) + 1;
		
		int count = 0;
		while(true) {
			System.out.print("1�� 100������ ������ �Է��ϼ��� : ");
			int yourAns = sc.nextInt();
			
			if(yourAns>100 || yourAns<1)
				continue;
			
			count++;
			if(yourAns > ans)
				System.out.println("�� ���� ������ �ٽ� �õ��ϼ���.");
			else if(yourAns < ans)
				System.out.println("�� ū ������ �ٽ� �õ��ϼ���.");
			else {
				System.out.println("�����Դϴ�. �õ�Ƚ���� " + count + "���Դϴ�.");
				break;
			}	
		}
	}
}