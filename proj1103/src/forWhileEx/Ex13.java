package forWhileEx;

import java.util.*;

public class Ex13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tot = 0;
		boolean flag = true;
		while(flag) {
			System.out.print("�հ踦 ���� ���ڸ� �Է��ϼ���(�������� 0�� �Է�) : ");
			int num = sc.nextInt();
			
			tot += num;

			if(num == 0)
				flag = false;
		}
		System.out.println(tot);
	}
}