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
	//���� ��Ȳ ���ϱ�
	void SalesStatus() {
		
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
	//���� �Է�
	void input(Branch branch) {
		while(true) {
			System.out.print("��ǰ��? ");
			branch.productName = sc.nextLine();
			System.out.print(branch.toString() + " "
					+ branch.productName + " �Ǹŷ���? ");
		}
	}
	//���
	void output() {
		System.out.println("----------------------------------------");
		System.out.println("\t    �� ���纰 �Ǹ� ��Ȳ");
		System.out.println("----------------------------------------");
		System.out.println("�����\t��ǰ��\t��ǰ����\t�Ǹŷ�\t������Ȳ");
		
		
		System.out.println("----------------------------------------");
		System.out.println();
	}
}