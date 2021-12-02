package cafe1369;

import java.util.*;

public class AsListEx {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("홍길동", "신용권", "김자바");
		for(String name : list1)
			System.out.println(name);
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value : list2)
			System.out.println(value);
		
		int ido = list1.indexOf("김자바");
		System.out.println("김자바 " + ido);
		
		ido = list1.lastIndexOf("김자바");
		System.out.println("김자바 " + ido);
		
		ido = list1.lastIndexOf("가가가");
		System.out.println("가가가 " + ido);

		List<String> list = Arrays.asList("asdf", "fdd", "sdsdf", "ffff");
		list.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).forEach(System.out::println);
	}
}