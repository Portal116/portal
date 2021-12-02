package operationEx;

import java.util.*;

public class Ex12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("초를 입력해주세요 : ");
		int tot = sc.nextInt();
		
		int hour = tot/3600;
		int min = (tot%3600)/60;
		int sec = tot%60;
		
		System.out.println(hour + "시간 " + min + "분 " + sec + "초 입니다.");
	}
}