package operationEx;

import java.util.*;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("무게를 입력하세요(kg) : ");
		double weight = sc.nextDouble();
		
		double poundWeight = weight/0.453592;
		
		//System.out.println(String.format("%.3f", poundWeight));
		
		poundWeight = Math.round(poundWeight*1000);
		poundWeight /= 1000;
		System.out.println(poundWeight);
	}
}