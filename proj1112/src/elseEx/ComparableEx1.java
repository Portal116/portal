package elseEx;

import java.util.*;

public class ComparableEx1 {
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>();
		
		treeSet.add(new Person("a",45));
		treeSet.add(new Person("k",55));
		treeSet.add(new Person("d",35));
		treeSet.add(new Person("c",15));
		
		Iterator<Person> it = treeSet.iterator();
		while(it.hasNext()) {
			Person p = it.next();
			System.out.println(p.age);
		}
	}
}
class Person implements Comparable<Person>{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return o.age - this.age;
//		if(this.age < o.age)
//			return -1;
//		else if(this.age == o.age)
//			return 0;
//		else
//			return 1;
	}
}