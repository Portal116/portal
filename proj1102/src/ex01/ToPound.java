package ex01;

import java.util.*;

public class ToPound {
	double kg;
	public static void main(String[] args) {
		
	}
	
	double inputMethod() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*********");
		System.out.println("���� ��ȯ ���α׷�");
		System.out.println("*********");
		System.out.println("��ȯ�� kg��?");
		kg = sc.nextDouble();
		return kg;
	}
	
	void printMethod() {
		System.out.println("�Է¹��� kg");
	}
	
	double pound(double d) {
		return d*2.2;
	}
}