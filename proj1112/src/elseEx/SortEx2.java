package elseEx;

import java.util.*;

public class SortEx2 {
	public static void main(String[] args) {
		List<Student> list1 = new ArrayList<Student>();
		list1.add(new Student("111", "ȫ�浿3"));
		list1.add(new Student("555", "ȫ�浿2"));
		list1.add(new Student("222", "ȫ�浿5"));
		list1.add(new Student("333", "ȫ�浿7"));
		
		Student[] sa = new Student[4];
		Student[] sa1 = list1.toArray(sa);
		System.out.println(sa1[0].hakbun);
		
		Arrays.sort(sa1);
		System.out.println(Arrays.toString(sa1));
		
		
	}
}
class Student implements Comparable<Student>{
	String hakbun;
	String name;
	Student(String hakbun, String name) {
		// TODO Auto-generated constructor stub
		this.hakbun = hakbun;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.hakbun;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.hakbun.compareTo(o.hakbun);
	}
	
}
//class SortBase implements Comparator<Student>{
//	@Override
//	public int compare(Student o1, Student o2) {
//		// TODO Auto-generated method stub
//		return (o1.hakbun).compareTo(o2.hakbun);
//	}
//}