package cafeEx;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorEx {
	public static void main(String[] args) {
		List<Student1> totalList = 
				Arrays.asList(new Student1("홍길동", 10, Student1.Sex.MALE),
							new Student1("김수애", 6, Student1.Sex.FEMALE),
							new Student1("신용권", 10, Student1.Sex.MALE),
							new Student1("박수미", 6, Student1.Sex.FEMALE));
		
		List<Student1> maleList =
				totalList.stream()
						.filter(s -> s.getSex() == Student1.Sex.MALE)
						.collect(Collectors.toList());
		maleList.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		List<Student1> femaleList =
				totalList.stream()
						.filter(s -> s.getSex() == Student1.Sex.FEMALE)
						.collect(Collectors.toList());
		femaleList.stream().forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		Set<Student1> femaleSet = 
				totalList.stream()
						.filter(s -> s.getSex() == Student1.Sex.FEMALE)
						.collect(Collectors.toCollection(()->new HashSet<Student1>()));
		femaleSet.stream().forEach(s->System.out.println(s.getName()));
	}
}
class Student1{
	public enum Sex {MALE, FEMALE};
	public enum City {Seoul, Busan};
	
	private String name;
	private int score;
	private Sex sex;
	private City city;
	
	public Student1(String name, int score, Sex sex) {
		this.name = name;
		this.score = score;
		this.sex = sex;
	}
	public Student1(String name, int score, Sex sex, City city) {
		this.name = name;
		this.score = score;
		this.sex = sex;
		this.city = city;
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
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}	
}