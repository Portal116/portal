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
			System.out.println("  ���� ��� ��� ����");
			System.out.println("--------------------");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("����? ");
			int choice = sc.nextInt();
			System.out.println();
			if (choice == 1) {
				inputData();
			} else if (choice == 2) {
				Calculator();
			} else if (choice == 3)
				System.exit(0);
			else {
				System.out.println("1~3�߿� �������ּ���.");
			}
		}
	}
	private void inputData() {
		// TODO Auto-generated method stub
		System.out.print("������ �Է����ּ��� : ");
		String name = sc.next();
		System.out.print("����ڵ带 �Է����ּ��� : ");
		char grade = sc.next().charAt(0);
		System.out.print("���ð��� �Է����ּ��� : ");
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
		System.out.println("����\t����ڵ�\t�ð���ܰ�\t�⺻���\t���ð�\t���ο��\t�̹�����ſ��");
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
	private String customerName; //�� �̸�
	private int payPerHour; //�ð��� �ܰ�
	private int baseRate; //�⺻���
	private int use; //���ð�
	
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
	private int payPerHour = 86; //�ð��� �ܰ�
	private int baseRate = 10000; //�⺻���
	
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
	private int payPerHour = 81; //�ð��� �ܰ�
	private int baseRate = 12000; //�⺻���
	
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
	private int payPerHour = 104; //�ð��� �ܰ�
	private int baseRate = 15000; //�⺻���
	
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
	private int payPerHour = 52; //�ð��� �ܰ�
	private int baseRate = 20000; //�⺻���
	
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