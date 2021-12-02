package operationEx;

import java.util.*;

public class CoinExchange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int[4];
		
		System.out.print("교환할 돈은? ");
		int coin = sc.nextInt();
		
		count[0] = coin/500;
		coin %= 500;
		
		count[1] = coin/100;
		coin %= 100;
		
		count[2] = coin/50;
		coin %= 50;
		
		count[3] = coin/10;
		coin %= 10;
		
		System.out.println("500원짜리 --> " + count[0] + "개");
		System.out.println("100원짜리 --> " + count[1] + "개");
		System.out.println("50원짜리 --> " + count[2] + "개");
		System.out.println("10원짜리 --> " + count[3] + "개");
		System.out.println("바꾸지 못한 잔돈 ---> " + coin + "원");
		
			
	}
}