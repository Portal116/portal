package cafe1331else;

import java.util.*;

public class CommunicationFee {
	public static void main(String[] args) {
		Output op = new Output();
		op.menuOutput();
	}
}
class Output{
	Vector<GradeCode> vg = new Vector<>();
	Scanner sc = new Scanner(System.in);
	public void menuOutput() {
		while (true) {
			System.out.println("--------------------");
			System.out.println("  무선 통신 요금 계산기");
			System.out.println("--------------------");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("선택? ");
			int choice = sc.nextInt();
			System.out.println();
			if (choice == 1) {
				inputData();
			} else if (choice == 2) {
				Calculator();
			} else if (choice == 3)
				System.exit(0);
			else {
				System.out.println("1~3중에 선택해주세요.");
			}
		}
	}
	private void inputData() {
		// TODO Auto-generated method stub
		System.out.print("고객명을 입력해주세요 : ");
		String name = sc.next();
		System.out.print("등급코드를 입력해주세요 : ");
		char grade = sc.next().charAt(0);
		System.out.print("사용시간을 입력해주세요 : ");
		int useHour = sc.nextInt();
		System.out.println();
		
		GradeCode gc = null;
		switch(grade) {
			case 'A': case 'a':
				gc = new A();
				break;
			case 'B': case 'b':
				gc = new B();
				break;
			case 'C': case 'c':
				gc = new C();
				break;
			case 'D': case 'd':
				gc = new D();
				break;
		}
		gc.setCustomerName(name);
		gc.setUse(useHour);
		vg.add(gc);
	}
	private void Calculator() {
		// TODO Auto-generated method stub
		System.out.println("고객명\t등급코드\t시간당단가\t기본요금\t사용시간\t할인요금\t이번달통신요금");
		System.out.println("----------------------------------------------------------");
		for(int i=0;i<vg.size();i++) {
			int monthFee = vg.get(i).getPayPerHour() * vg.get(i).getUse() + (int)(vg.get(i).getBaseRate()*0.9);
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%d%n",
					vg.get(i).getCustomerName(), vg.get(i).toString(),
					vg.get(i).getPayPerHour(), vg.get(i).getBaseRate(),
					vg.get(i).getUse(), (int)(vg.get(i).getBaseRate()*0.1),
					monthFee);			
		}
	}
}
class GradeCode{
	private String customerName; //고객 이름
	private int payPerHour; //시간당 단가
	private int baseRate; //기본요금
	private int use; //사용시간
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getPayPerHour() {
		return payPerHour;
	}
	public int getBaseRate() {
		return baseRate;
	}
	public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
	}
}
class A extends GradeCode{
	private int payPerHour = 86; //시간당 단가
	private int baseRate = 10000; //기본요금
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "A";
	}
	public int getPayPerHour() {
		return payPerHour;
	}
	public int getBaseRate() {
		return baseRate;
	}
}
class B extends GradeCode{
	private int payPerHour = 81; //시간당 단가
	private int baseRate = 12000; //기본요금
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "B";
	}
	public int getPayPerHour() {
		return payPerHour;
	}
	public int getBaseRate() {
		return baseRate;
	}	
}
class C extends GradeCode{
	private int payPerHour = 104; //시간당 단가
	private int baseRate = 15000; //기본요금
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "C";
	}
	public int getPayPerHour() {
		return payPerHour;
	}
	public int getBaseRate() {
		return baseRate;
	}	
}
class D extends GradeCode{
	private int payPerHour = 52; //시간당 단가
	private int baseRate = 20000; //기본요금
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "D";
	}
	public int getPayPerHour() {
		return payPerHour;
	}
	public int getBaseRate() {
		return baseRate;
	}	
}