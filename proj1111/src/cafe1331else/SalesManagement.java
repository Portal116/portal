package cafe1331else;

import java.util.Scanner;
import java.util.Vector;

public class SalesManagement {
	public static void main(String[] args) {
		Print print = new Print();
		print.menuOutput();
		
	}
}
class Product{
	int price;
	int sales;
	int income;
	
	Product(int price){
		this.price = price;
	}
}
class Computer extends Product{
	Computer(){
		super(2000000);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��ǻ��";
	}	
}
class Printer extends Product{
	Printer(){
		super(500000);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "������";
	}	
}
class Branch{
	String name;
	Product p;
	
	Branch(String name, Product p){
		this.name = name;
		this.p = p;
	}
}
class Print{
	String[] branch = {"��������", "��������", "��������", "��������"};
	Vector<Branch> vbr = new Vector<>();
	Scanner sc = new Scanner(System.in);
	
	public void menuOutput() {
		while(true) {
			System.out.println("--------------------");
			System.out.println("  �Ǹŷ� ���� ������Ʈ");
			System.out.println("--------------------");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("����? ");
			int choice = sc.nextInt();
			if(choice == 1) {
				inputData();
			} else if(choice == 2) {
				summary();
			} else if(choice == 3)
				System.exit(0);
			else {
				System.out.println("1~3�߿� �������ּ���.");
			}
		}	
	}
	
	public void inputData() {
		System.out.println("�����?");
		System.out.println("1. �������� 2. �������� 3. �������� 4. ��������");
		System.out.print("������? ");
		int branchSelect = sc.nextInt();
		
		while(true) {
			System.out.print("��ǰ��? ");
			String productName = sc.next();
			Product tmp = null;
			if(productName.equals("��ǻ��")) {
				tmp = new Computer();
			}
			else if(productName.equals("������"))
				tmp = new Printer();
			Branch br = new Branch(branch[branchSelect-1], tmp);
			
			System.out.printf("%s %s �Ǹŷ���? ",branch[branchSelect-1],tmp.toString());
			int sales = sc.nextInt();
			br.p.sales = sales;
			br.p.income = sales * br.p.price;
			vbr.add(br);
			
			System.out.print("��� �Է��Ͻðڽ��ϱ�? ");
			char ch = sc.next().charAt(0);
			
			if(ch != 'y' && ch != 'Y')
				break;
		}		
	}
	
	public void summary() {
		System.out.println("----------------------------------------");
		System.out.println("\t    �� ���纰 �Ǹ� ��Ȳ");
		System.out.println("----------------------------------------");
		System.out.println("�����\t��ǰ��\t��ǰ����\t�Ǹŷ�\t������Ȳ");
		for(int i=0;i<vbr.size();i++) {
			Branch temp = vbr.get(i);			
			System.out.println(temp.name + "\t" + temp.p.toString()
				+ "\t" + temp.p.price + "\t" + temp.p.sales
				+ "\t" + temp.p.income);
		}
		System.out.println("----------------------------------------");
		System.out.println();
	}
}