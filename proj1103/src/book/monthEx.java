package book;

import java.util.*;

public class monthEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		String season = null;
		switch(month) {
			case 3: case 4: case 5:
				season = "봄";
				break;
			case 6: case 7: case 8:
				season = "여름";
				break;
			case 9: case 10: case 11:
				season = "가을";
				break;
			case 12: case 1: case 2:
				season = "겨울";
				break;
			default:
				System.out.println("1~12 중에서 입력해주세요.");
				System.exit(0);
		}
		System.out.println("현재의 계절은 " + season + "입니다.");
	}
}