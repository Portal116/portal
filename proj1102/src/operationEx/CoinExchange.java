package operationEx;

import java.util.*;

public class CoinExchange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int[4];
		
		System.out.print("��ȯ�� ����? ");
		int coin = sc.nextInt();
		
		count[0] = coin/500;
		coin %= 500;
		
		count[1] = coin/100;
		coin %= 100;
		
		count[2] = coin/50;
		coin %= 50;
		
		count[3] = coin/10;
		coin %= 10;
		
		System.out.println("500��¥�� --> " + count[0] + "��");
		System.out.println("100��¥�� --> " + count[1] + "��");
		System.out.println("50��¥�� --> " + count[2] + "��");
		System.out.println("10��¥�� --> " + count[3] + "��");
		System.out.println("�ٲ��� ���� �ܵ� ---> " + coin + "��");
		
			
	}
}