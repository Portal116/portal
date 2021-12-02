package examEx;

public class StudentProcessing {
	public static void main(String[] args) {
		Student s1 = new HighSchool("ȫ�浿", "010-111", 10000, "�ڹ�", "A");
		Student s2 = new HighSchool("������", "010-222", 20000, "C", "B");
		Student s3 = new HighSchool("�ְ���", "010-333", 50000, "HTML", "A");
		
		System.out.println("�л���\t��ȭ��ȣ\t��ϱ�\t�����\t���");
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