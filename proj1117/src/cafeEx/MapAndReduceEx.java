package cafeEx;

import java.util.*;

public class MapAndReduceEx {
	public static void main(String[] args) {
//		cafe1386
		List<Student> StudentList = 
		Arrays.asList(new Student("ȫ�浿",10),
					new Student("�ſ��",20),
					new Student("���̼�",30));
		double d = StudentList.stream().mapToInt(Student::getScore).average().getAsDouble();
		System.out.println(d);
		int s = StudentList.stream().mapToInt(Student::getScore).sum();
		System.out.println(s);
	}
}
class Student{
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}