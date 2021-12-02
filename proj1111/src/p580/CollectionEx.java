package p580;

import java.util.*;

public class CollectionEx {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		list1.add(1);
		list1.add("a");
		list1.add(true);
		list1.add('c');
		list1.add(new A());
		list1.add("a");
		
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		System.out.println();
		
		list1.add(3, 88);
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		System.out.println();
		
		list1.remove(0);
		list1.remove(true);
		list1.remove("a");
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		
		if(list1.isEmpty())
			System.out.println("자료가 없음");
		else
			System.out.println("자료가 있음");
		
		Iterator it = list1.iterator();
		while(it.hasNext()) {
			
		}
	}
}
class A{
	
}