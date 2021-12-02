package cafe1369;

import java.util.*;

public class AsListEx {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�");
		for(String name : list1)
			System.out.println(name);
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value : list2)
			System.out.println(value);
		
		int ido = list1.indexOf("���ڹ�");
		System.out.println("���ڹ� " + ido);
		
		ido = list1.lastIndexOf("���ڹ�");
		System.out.println("���ڹ� " + ido);
		
		ido = list1.lastIndexOf("������");
		System.out.println("������ " + ido);

		List<String> list = Arrays.asList("asdf", "fdd", "sdsdf", "ffff");
		list.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).forEach(System.out::println);
	}
}