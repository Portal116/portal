package operationEx;

import java.util.*;

public class Ex11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�����Ը� �Է����ּ���(kg) : ");
		double weight = sc.nextDouble();
		
		System.out.print("Ű�� �Է����ּ���(cm) : ");
		double height = sc.nextDouble();
		
		System.out.println(weight <(height-100)*0.9 ? "����" : "��");
	}
}