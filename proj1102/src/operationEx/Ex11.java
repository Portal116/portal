package operationEx;

import java.util.*;

public class Ex11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몸무게를 입력해주세요(kg) : ");
		double weight = sc.nextDouble();
		
		System.out.print("키를 입력해주세요(cm) : ");
		double height = sc.nextDouble();
		
		System.out.println(weight <(height-100)*0.9 ? "정상" : "비만");
	}
}