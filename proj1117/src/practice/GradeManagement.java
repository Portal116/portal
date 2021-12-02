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
	String subjectName; // 과목명
	int rawScore; // 원점수
	int midtermExam; // 중간고사
	int finalExam; // 기말고사
	int perScore; // 수행평가

	abstract void print(); // 결과 출력
}

class Elemental extends Grade {
	@Override
	void print() {
		// TODO Auto-generated method stub
		this.rawScore = this.midtermExam + this.finalExam + this.perScore;
		System.out.println("과목명 : " + this.subjectName);
		System.out.printf("시험 - 중간고사 : %d, 기말고사 : %d, 수행평가 : %d%n", this.midtermExam, this.finalExam, this.perScore);
		System.out.println("점수 : " + this.rawScore);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "초등학생";
	}
}

class Middle extends Grade {
	String teacher; // 담당교사
	int attScore; // 출석점수
	int volScore; // 봉사점수
	
	@Override
	void print() {
		// TODO Auto-generated method stub
		this.rawScore = this.midtermExam + this.finalExam + this.perScore + this.attScore + this.volScore;
		System.out.println("과목명 : " + this.subjectName);
		System.out.println("담당교사 : " + this.teacher);
		System.out.printf("시험 - 중간고사 : %d, 기말고사 : %d, 수행평가 : %d, 출석점수 : %d, 봉사점수 : %d%n", this.midtermExam,
				this.finalExam, this.perScore, this.attScore, this.volScore);
		System.out.println("점수 : " + this.rawScore);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "중학생";
	}
}
class High extends Grade {
	String teacher; // 담당교사
	int attScore; // 출석점수
	int volScore; // 봉사점수
	double standardDeviation; // 표준편차

	void print() {
		// TODO Auto-generated method stub		
		this.rawScore = this.midtermExam + this.finalExam + this.perScore + this.attScore + this.volScore;
		this.standardDeviation = 23.12;
		System.out.println("과목명 : " + this.subjectName);
		System.out.println("담당교사 : " + this.teacher);
		System.out.printf("시험 - 중간고사 : %d, 기말고사 : %d, 수행평가 : %d, 출석점수 : %d, 봉사점수 : %d%n", this.midtermExam,
				this.finalExam, this.perScore, this.attScore, this.volScore);
		System.out.println("점수 : " + this.rawScore);
		System.out.println("표준편차 : " + this.standardDeviation);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "고등학생";
	}
}

class MenuPrint {
	Vector<Grade> vs = new Vector<>();
	Scanner sc = new Scanner(System.in);

	public void menuOutput() {
		while (true) {
			System.out.println("--------------------");
			System.out.println("   성적 관리 프로젝트");
			System.out.println("--------------------");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("선택? ");
			int choice = sc.nextInt();
			if (choice == 1) {
				inputData();
			} else if (choice == 2) {
				summary();
			} else if (choice == 3)
				System.exit(0);
			else {
				System.out.println("1~3중에 선택해주세요.");
			}
		}
	}
	public void inputData() {
		System.out.println("무슨 학교인가요?");
		System.out.println("1. 초등학교 2. 중학교 3. 고등학교");
		System.out.print("선택은? ");
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
		
		System.out.print("과목명은? ");
		g.subjectName = sc.next();
		System.out.print("중간고사 성적은? ");
		g.midtermExam = sc.nextInt();
		System.out.print("기말고사 성적은? ");
		g.finalExam = sc.nextInt();
		System.out.print("수행평가 성적은? ");
		g.perScore = sc.nextInt();
		if(g instanceof Middle) {
			System.out.print("출석 점수는? ");
			((Middle)g).attScore = sc.nextInt();
			System.out.print("봉사점수는? ");
			((Middle)g).volScore = sc.nextInt();
			System.out.print("선생님은? ");
			((Middle)g).teacher = sc.next();
		}
		if(g instanceof High) {
			System.out.print("출석 점수는? ");
			((High)g).attScore = sc.nextInt();
			System.out.print("봉사점수는? ");
			((High)g).volScore = sc.nextInt();
			System.out.print("선생님은? ");
			((High)g).teacher = sc.next();
		}
		vs.add(g);
	}
	public void summary() {
		for(int i=0;i<vs.size();i++) {
			System.out.println("---------------------------------------------------------------");
			System.out.println(vs.get(i).toString() + " 성적입니다.");
			System.out.println("---------------------------------------------------------------");
			vs.get(i).print();
			System.out.println("---------------------------------------------------------------");
		}
	}
}