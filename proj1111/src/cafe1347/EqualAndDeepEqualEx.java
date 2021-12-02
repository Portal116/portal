package cafe1347;

import java.util.*;

public class EqualAndDeepEqualEx {
	public static void main(String[] args) {
		Integer o1 = 1000;
		Integer o2 = 1000;
		
		System.out.println(Objects.equals(o1, o2));
		System.out.println(Objects.equals(null, null));
		
		Integer[] arr1 = {1,2};
		Integer[] arr2 = {1,3};
		System.out.println(Objects.equals(arr1, arr2));
		System.out.println(Objects.deepEquals(arr1, arr2));
		
		String name = "ȫ�浿";
		String name1 = null;
		
		if(Objects.isNull(name1))
			System.out.println("���̸� �Է��� �޼ҵ�� ����");
		else
			System.out.println("�ڷ� ���� �־��");
		if(Objects.nonNull(name))
			System.out.println("���� �ƴϸ� �Է��� �޼ҵ�� ����");
		else
			System.out.println("�ڷ� ���� �־��");
		
		String aa = Objects.requireNonNull(name);
		System.out.println(aa);
		
		int a = 10;
		int oa = Objects.requireNonNull(a);
		System.out.println(oa);
		try {
			Objects.requireNonNull(null, "�ƹ��͵� ���� ����");
		} catch (Exception e) {
			System.out.println("����ó��");
		}
		
		
	}
}