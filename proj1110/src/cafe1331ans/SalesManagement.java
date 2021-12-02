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
	int salesAmount;
	int income;
}

class SeoulBranch extends Branch{
	int salesAmount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��������";
	}
}
class KyunginBranch extends Branch{
	int salesAmount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��������";
	}
}
class KangwonBranch extends Branch{
	int salesAmount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��������";
	}
}
class JejuBranch extends Branch{
	int salesAmount;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��������";
	}
}
class Business{
	Scanner sc = new Scanner(System.in);
	Branch sb = new SeoulBranch();
	Branch kb = new KyunginBranch();
	Branch wb = new KangwonBranch();
	Branch jb = new JejuBranch();
	//���� ��Ȳ ���ϱ�
	void SalesStatus(Branch branch) {
		if(branch.productName.equals("��ǻ��"))
			branch.price = 2000000;
		else if(branch.productName.equals("������"))
			branch.price = 500000;
	}
	//ù �޴�
	void title() {
		int menuSelect;
		while(true) {
			System.out.println("--------------------");
			System.out.println("  �Ǹŷ� ���� ������Ʈ");
			System.out.println("--------------------");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("����? ");
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
					System.out.println("1~3�߿� �������ּ���.");
					break;
			}
		}	
	}
	//���� �Է�
	void branchInput() {
		System.out.println("�����?");
		System.out.println("1. �������� 2. �������� 3. �������� 4. ��������");
		System.out.print("������? ");
		int branchSelect = sc.nextInt();
		switch(branchSelect) {
			case 1:
				input(sb);
				break;
			case 2:
				input(kb);
				break;
			case 3:
				input(wb);
				break;
			case 4:
				input(jb);
				break;
			default:
				System.out.println("�����ȣ�� Ʋ�Ƚ��ϴ�.");
		}
	}
	//���� �Է�
	void input(Branch branch) {
		while(true) {
			System.out.print("��ǰ��? ");
			branch.productName = sc.next();
			
			System.out.print(branch.toString() + " "
					+ branch.productName + " �Ǹŷ���? ");
			branch.salesAmount = sc.nextInt();
			
			SalesStatus(branch);
			System.out.print("��� �Է��Ͻðڽ��ϱ�? ");
			char ch = sc.next().charAt(0);
			
			if(ch != 'y' && ch != 'Y')
				break;
		}
	}
	//���
	void output() {
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