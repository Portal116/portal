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
		
		String name = "홍길동";
		String name1 = null;
		
		if(Objects.isNull(name1))
			System.out.println("널이면 입력한 메소드로 가라");
		else
			System.out.println("자료 변수 넣어라");
		if(Objects.nonNull(name))
			System.out.println("널이 아니면 입력한 메소드로 가라");
		else
			System.out.println("자료 변수 넣어라");
		
		String aa = Objects.requireNonNull(name);
		System.out.println(aa);
		
		int a = 10;
		int oa = Objects.requireNonNull(a);
		System.out.println(oa);
		try {
			Objects.requireNonNull(null, "아무것도 넣지 않음");
		} catch (Exception e) {
			System.out.println("예외처리");
		}
		
		
	}
}