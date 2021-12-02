package cafe1369;

import java.util.*;

public class ToArrayEx {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("LA");
		list.add("대전");
		list.add("LA");
		list.add("부산");
		
		String[] arr = list.toArray(new String[list.size()]);
		
		for(String num : arr)
			System.out.print(num + " ");
		
		System.out.println();
		System.out.println(arr[0]);
		System.out.println(arr[4]);
		
		arr[4] = "인천";
		System.out.println(arr[4]);
	}
}
