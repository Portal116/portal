package operationEx;

import java.util.*;

public class LeapYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("윤년임을 계산할 년도 입력 : ");
		int year = sc.nextInt();
		
		if(year%400 == 0)
			System.out.println("윤년");
		else if(year%100 == 0)
			System.out.println("평년");
		else if(year%4 == 0)
			System.out.println("윤년");
		else
			System.out.println("평년");
	}
}