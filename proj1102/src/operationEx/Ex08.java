package operationEx;

import java.util.*;

public class Ex08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		System.out.println(num/10000 + "만 " + 
				(num/1000)%10 + "천 " + 
				(num/100)%10 + "백 " +
				(num/10)%10 + "십 " +
				num%10 + "입니다.");
	}
}