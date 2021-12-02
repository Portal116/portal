package cafe1331ans;

import java.util.*;

public class SalesManagement {
	public static void main(String[] args) {
		Business bs = new Business();
		bs.title();
	}
}

class Branch{
	String branchName;
	String productName;
	int price;
}

class SeoulBranch extends Branch{
	int salesAmount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "서울지사";
	}
}
class KyunginBranch extends Branch{
	int salesAmount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "경인지사";
	}
}
class KangwonBranch extends Branch{
	int salesAmount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "강원지사";
	}
}
class JejuBranch extends Branch{
	int salesAmount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "제주지사";
	}
}
class Business{
	Scanner sc = new Scanner(System.in);
	//매출 현황 구하기
	void SalesStatus() {
		
	}
	//첫 메뉴
	void title() {
		int menuSelect;
		while(true) {
			System.out.println("--------------------");
			System.out.println("  판매량 관리 프로젝트");
			System.out.println("--------------------");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("선택? ");
			menuSelect = sc.nextInt();
			switch(menuSelect) {
				case 1:
					branchInput();
					break;
				case 2:
					output();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("1~3중에 선택해주세요.");
					break;
			}
		}	
	}
	//지사 입력
	void branchInput() {
		System.out.println("지사는?");
		System.out.println("1. 서울지사 2. 경인지사 3. 강원지사 4. 제주지사");
		System.out.print("선택은? ");
		int branchSelect = sc.nextInt();
		switch(branchSelect) {
			case 1:
				input(new SeoulBranch());
			case 2:
				input(new KyunginBranch());
			case 3:
				input(new KangwonBranch());
			case 4:
				input(new JejuBranch());
			default:
				
		}
	}
	//정보 입력
	void input(Branch branch) {
		while(true) {
			System.out.print("제품은? ");
			branch.productName = sc.nextLine();
			System.out.print(branch.toString() + " "
					+ branch.productName + " 판매량은? ");
		}
	}
	//출력
	void output() {
		System.out.println("----------------------------------------");
		System.out.println("\t    각 지사별 판매 현황");
		System.out.println("----------------------------------------");
		System.out.println("지사명\t제품명\t제품가격\t판매량\t매출현황");
		
		
		System.out.println("----------------------------------------");
		System.out.println();
	}
}