package ex01;

import java.util.*;

public class ToPound {
	double kg;
	public static void main(String[] args) {
		
	}
	
	double inputMethod() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*********");
		System.out.println("단위 변환 프로그램");
		System.out.println("*********");
		System.out.println("변환할 kg은?");
		kg = sc.nextDouble();
		return kg;
	}
	
	void printMethod() {
		System.out.println("입력받은 kg");
	}
	
	double pound(double d) {
		return d*2.2;
	}
}