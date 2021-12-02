package practice;

import java.util.Scanner;
import java.util.Vector;

public class GradeManagement {
	public static void main(String[] args) {
		MenuPrint mp = new MenuPrint();
		mp.menuOutput();
	}
}

abstract class Grade {
	Scanner sc = new Scanner(System.in);
	String subjectName; // �����
	int rawScore; // ������
	int midtermExam; // �߰����
	int finalExam; // �⸻���
	int perScore; // ������

	abstract void print(); // ��� ���
}

class Elemental extends Grade {
	@Override
	void print() {
		// TODO Auto-generated method stub
		this.rawScore = this.midtermExam + this.finalExam + this.perScore;
		System.out.println("����� : " + this.subjectName);
		System.out.printf("���� - �߰���� : %d, �⸻��� : %d, ������ : %d%n", this.midtermExam, this.finalExam, this.perScore);
		System.out.println("���� : " + this.rawScore);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�ʵ��л�";
	}
}

class Middle extends Grade {
	String teacher; // ��米��
	int attScore; // �⼮����
	int volScore; // ��������
	
	@Override
	void print() {
		// TODO Auto-generated method stub
		this.rawScore = this.midtermExam + this.finalExam + this.perScore + this.attScore + this.volScore;
		System.out.println("����� : " + this.subjectName);
		System.out.println("��米�� : " + this.teacher);
		System.out.printf("���� - �߰���� : %d, �⸻��� : %d, ������ : %d, �⼮���� : %d, �������� : %d%n", this.midtermExam,
				this.finalExam, this.perScore, this.attScore, this.volScore);
		System.out.println("���� : " + this.rawScore);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "���л�";
	}
}
class High extends Grade {
	String teacher; // ��米��
	int attScore; // �⼮����
	int volScore; // ��������
	double standardDeviation; // ǥ������

	void print() {
		// TODO Auto-generated method stub		
		this.rawScore = this.midtermExam + this.finalExam + this.perScore + this.attScore + this.volScore;
		this.standardDeviation = 23.12;
		System.out.println("����� : " + this.subjectName);
		System.out.println("��米�� : " + this.teacher);
		System.out.printf("���� - �߰���� : %d, �⸻��� : %d, ������ : %d, �⼮���� : %d, �������� : %d%n", this.midtermExam,
				this.finalExam, this.perScore, this.attScore, this.volScore);
		System.out.println("���� : " + this.rawScore);
		System.out.println("ǥ������ : " + this.standardDeviation);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "����л�";
	}
}

class MenuPrint {
	Vector<Grade> vs = new Vector<>();
	Scanner sc = new Scanner(System.in);

	public void menuOutput() {
		while (true) {
			System.out.println("--------------------");
			System.out.println("   ���� ���� ������Ʈ");
			System.out.println("--------------------");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("����? ");
			int choice = sc.nextInt();
			if (choice == 1) {
				inputData();
			} else if (choice == 2) {
				summary();
			} else if (choice == 3)
				System.exit(0);
			else {
				System.out.println("1~3�߿� �������ּ���.");
			}
		}
	}
	public void inputData() {
		System.out.println("���� �б��ΰ���?");
		System.out.println("1. �ʵ��б� 2. ���б� 3. ����б�");
		System.out.print("������? ");
		int schoolSelect = sc.nextInt();
		Grade g = null;
		switch(schoolSelect) {
			case 1:
				g = new Elemental();
				break;
			case 2:
				g = new Middle();
				break;
			case 3:
				g = new High();
				break;
		}
		
		System.out.print("�������? ");
		g.subjectName = sc.next();
		System.out.print("�߰���� ������? ");
		g.midtermExam = sc.nextInt();
		System.out.print("�⸻��� ������? ");
		g.finalExam = sc.nextInt();
		System.out.print("������ ������? ");
		g.perScore = sc.nextInt();
		if(g instanceof Middle) {
			System.out.print("�⼮ ������? ");
			((Middle)g).attScore = sc.nextInt();
			System.out.print("����������? ");
			((Middle)g).volScore = sc.nextInt();
			System.out.print("��������? ");
			((Middle)g).teacher = sc.next();
		}
		if(g instanceof High) {
			System.out.print("�⼮ ������? ");
			((High)g).attScore = sc.nextInt();
			System.out.print("����������? ");
			((High)g).volScore = sc.nextInt();
			System.out.print("��������? ");
			((High)g).teacher = sc.next();
		}
		vs.add(g);
	}
	public void summary() {
		for(int i=0;i<vs.size();i++) {
			System.out.println("---------------------------------------------------------------");
			System.out.println(vs.get(i).toString() + " �����Դϴ�.");
			System.out.println("---------------------------------------------------------------");
			vs.get(i).print();
			System.out.println("---------------------------------------------------------------");
		}
	}
}