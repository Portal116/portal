package operationEx;

import java.util.*;

public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 입력하기(F,f,C,c) : ");
		String word = sc.nextLine();
		
		System.out.print("온도 입력하기 : ");
		Double temparature = sc.nextDouble();
		
		if(word.equals("F") || word.equals("f"))
			temparature = (5.0 / 9.0 ) * (temparature - 32);
		else if(word.equals("C") || word.equals("c"))
			temparature = (9.0 / 5.0 ) * temparature + 32;
		else {
			System.out.println("F, f, C, c 중에서 입력을 하셔야 합니다.");
			System.exit(0);
		}
		
		System.out.println(String.format("%.1f", temparature));
		sc.close();
	}
}