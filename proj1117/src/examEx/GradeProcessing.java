package examEx;

public class GradeProcessing {
	public static void main(String[] args) {
		Sungjuk s1 = new Sungjuk(2021, "�ڹ�", 100, "��ǻ�Ͱ���");
		Sungjuk s2 = new Sungjuk(2020, "C", 80, "�������");
		Sungjuk s3 = new Sungjuk(2018, "HTML", 100, "������");
		

		System.out.println("�й�\t�����\t����\t������");
		System.out.println("--------------------------------");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}

class Sungjuk {
	int hakbun;
	String stuSubject;
	int stuJumsu;
	String stuMajor;

	public Sungjuk(int hakbun, String stuSubject, int stuJumsu, String stuMajor) {
		this.hakbun = hakbun;
		this.stuSubject = stuSubject;
		this.stuJumsu = stuJumsu;
		this.stuMajor = stuMajor;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return hakbun + "\t" + stuSubject + "\t" + stuJumsu + "\t" + stuMajor;
	}
}