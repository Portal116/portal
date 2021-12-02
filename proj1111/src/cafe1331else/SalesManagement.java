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
		return "컴퓨터";
	}	
}
class Printer extends Product{
	Printer(){
		super(500000);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "프린터";
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
	String[] branch = {"서울지사", "경인지사", "강원지사", "제주지사"};
	Vector<Branch> vbr = new Vector<>();
	Scanner sc = new Scanner(System.in);
	
	public void menuOutput() {
		while(true) {
			System.out.println("--------------------");
			System.out.println("  판매량 관리 프로젝트");
			System.out.println("--------------------");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("선택? ");
			int choice = sc.nextInt();
			if(choice == 1) {
				inputData();
			} else if(choice == 2) {
				summary();
			} else if(choice == 3)
				System.exit(0);
			else {
				System.out.println("1~3중에 선택해주세요.");
			}
		}	
	}
	
	public void inputData() {
		System.out.println("지사는?");
		System.out.println("1. 서울지사 2. 경인지사 3. 강원지사 4. 제주지사");
		System.out.print("선택은? ");
		int branchSelect = sc.nextInt();
		
		while(true) {
			System.out.print("제품은? ");
			String productName = sc.next();
			Product tmp = null;
			if(productName.equals("컴퓨터")) {
				tmp = new Computer();
			}
			else if(productName.equals("프린터"))
				tmp = new Printer();
			Branch br = new Branch(branch[branchSelect-1], tmp);
			
			System.out.printf("%s %s 판매량은? ",branch[branchSelect-1],tmp.toString());
			int sales = sc.nextInt();
			br.p.sales = sales;
			br.p.income = sales * br.p.price;
			vbr.add(br);
			
			System.out.print("계속 입력하시겠습니까? ");
			char ch = sc.next().charAt(0);
			
			if(ch != 'y' && ch != 'Y')
				break;
		}		
	}
	
	public void summary() {
		System.out.println("----------------------------------------");
		System.out.println("\t    각 지사별 판매 현황");
		System.out.println("----------------------------------------");
		System.out.println("지사명\t제품명\t제품가격\t판매량\t매출현황");
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