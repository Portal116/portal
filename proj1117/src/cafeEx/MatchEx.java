package cafeEx;

import java.util.*;

public class MatchEx {
	public static void main(String[] args) {
		int[] intArr = {2,4,6,7};
		
//		int aa = Arrays.stream(intArr)
//					.filter(a -> a%2 == 0)
//					.peek(b -> System.out.println())
//					.sum();
//		System.out.println(aa);
		
//		boolean aaa = Arrays.stream(intArr)
//				.allMatch(a -> a%2 == 0);
//		System.out.println(aaa);
		
		List<Integer> list = Arrays.asList();
		
		double avg = list.stream()
				.mapToInt(Integer::intValue)
				.average()
				.getAsDouble();
		System.out.println(avg);
	}
}