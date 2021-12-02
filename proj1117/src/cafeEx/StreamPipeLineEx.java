package cafeEx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamPipeLineEx {
	public static void main(String[] args) {
		List<Member> list = 
				Arrays.asList(new Member("홍길동", Member.MALE, 30),
							new Member("김나리", Member.FEMALE, 20),
							new Member("신용권", Member.MALE, 45),
							new Member("박수미", Member.FEMALE, 27));
		double avg = list.stream().filter(m -> m.getSex() == Member.MALE).mapToInt(Member::getAge).average().getAsDouble();
//		Member::getAge == m->m.getAge()
		System.out.println(avg);
	}
}
class Member{
	public static int MALE = 0;
	public static int FEMALE = 1;
	private String name;
	private int sex;
	private int age;
	
	Member(String name, int sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}