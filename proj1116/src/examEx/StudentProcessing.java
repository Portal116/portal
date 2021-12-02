package examEx;

public class StudentProcessing {
	public static void main(String[] args) {
		Student s1 = new HighSchool("홍길동", "010-111", 10000, "자바", "A");
		Student s2 = new HighSchool("김유신", "010-222", 20000, "C", "B");
		Student s3 = new HighSchool("최경희", "010-333", 50000, "HTML", "A");
		
		System.out.println("학생명\t전화번호\t등록금\t과목명\t등급");
		System.out.println("------------------------------------");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
class Student{
	String name;
	String phoneNum;
	int tuition;
	
	public Student(String name, String phoneNum, int tuition) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.tuition = tuition;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\t" + phoneNum + "\t" + tuition;
	}	
}
class HighSchool extends Student{
	String subject;
	String grade;
	
	public HighSchool(String name, String phoneNum, int tuition, String subject, String grade) {
		super(name, phoneNum, tuition);
		this.subject = subject;
		this.grade = grade;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t" + subject + "\t" + grade; 
	}
}