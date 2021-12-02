package operationEx;

import java.util.*;

public class Ex09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("임의의 달 입력하기(1~12) : ");
		int mon = sc.nextInt();
		
		if(mon > 12) {
			System.out.println("1~12 중에 입력해주세요.");
			System.exit(0);
		}
		String s;
		
		s = (mon <= 6) ? "상반기" : "하반기";
		System.out.println(s + "입니다.");
	}
}