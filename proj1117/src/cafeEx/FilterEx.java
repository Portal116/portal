package cafeEx;

import java.util.*;

public class FilterEx {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "신용권", "신용권", "신용권", "김자바", "신서진", "신민철");
		list.stream().distinct().forEach(s -> System.out.println(s));
		System.out.println("=====================");
		list.stream().distinct().filter(s->s.startsWith("신")).forEach(s -> System.out.println(s));
		
		
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
		inputList1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(word -> System.out.println(word));
	}
}