package cafe1369;

import java.util.*;

public class ToArrayEx {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("����");
		list.add("LA");
		list.add("����");
		list.add("LA");
		list.add("�λ�");
		
		String[] arr = list.toArray(new String[list.size()]);
		
		for(String num : arr)
			System.out.print(num + " ");
		
		System.out.println();
		System.out.println(arr[0]);
		System.out.println(arr[4]);
		
		arr[4] = "��õ";
		System.out.println(arr[4]);
	}
}
