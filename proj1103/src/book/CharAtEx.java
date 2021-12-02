package book;

import java.util.*;

public class CharAtEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char gender = sc.next().charAt(7);
		
		switch(gender) {
			case '1': case '3':
				System.out.println("남자");
				break;
			case '2': case '4':
				System.out.println("여자");
				break;
		}
	}
}