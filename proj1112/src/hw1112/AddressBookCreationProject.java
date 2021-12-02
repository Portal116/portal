package hw1112;

import java.util.*;

public class AddressBookCreationProject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("����� �� ������ �ּ��� / choose your language");
			System.out.print("�ѱ��� 0, English 1 : ");
			int languageSelect = sc.nextInt();
			System.out.println("-------------------------------------------------");
			
			AddressBook ab = null;
			switch(languageSelect) {
				case 0:
					ab = new AddressBookKor();
					break;
				case 1:
					ab = new AddressBookEng();
					break;
				default:
					System.out.println("�߸��� �����Դϴ�. 0,1 �߿� �������ּ���. �ʱ� �޴��� ���ư��ϴ�.");
					System.out.println("-------------------------------------------------");
					continue;
			}
			while(true)
				ab.displayMenu();
		}
	}
}
class Record{
	protected String name;
	protected String address;
	
	public Record(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
abstract class AddressBook{
	Vector<Record> vr = new Vector<Record>();
	Scanner sc = new Scanner(System.in);
	
	String nameTemp;
	String addressTemp;
	
	abstract void addRecord(); 
	abstract void getRecord();
	abstract void delRecord();
	abstract void displayMenu();
}
class AddressBookEng extends AddressBook{
	@Override
	public void addRecord() {
		// TODO Auto-generated method stub
		
		System.out.print("Insert name : ");
		nameTemp = sc.nextLine();
		System.out.print("Insert Address : ");
		addressTemp = sc.nextLine();
		System.out.println(nameTemp + "'s address " + addressTemp + " added.");
		System.out.println("-------------------------------------------------");
		Record rc = new Record(nameTemp, addressTemp);
		vr.add(rc);
	}
	@Override
	public void getRecord() {
		// TODO Auto-generated method stub
		System.out.print("Enter a name to search for : ");
		nameTemp = sc.nextLine();
		for(int i=0;i<vr.size();i++) {
			if(nameTemp.equals(vr.get(i).getName())) {
				System.out.println(vr.get(i).getName() + "'s address is " + vr.get(i).getAddress());
				System.out.println("-------------------------------------------------");
				return;
			}
		}
		System.out.println("Could not found " + nameTemp + "'s address.");
		System.out.println("-------------------------------------------------");
	}
	@Override
	public void delRecord() {
		// TODO Auto-generated method stub
		System.out.print("Enter your name to delete the address : ");
		nameTemp = sc.nextLine();
		for(int i=0;i<vr.size();i++) {
			if(nameTemp.equals(vr.get(i).getName())) {
				System.out.println(vr.get(i).getName() + "'s address " + vr.get(i).getAddress() + " deleted.");
				System.out.println("-------------------------------------------------");
				vr.remove(i);
				return;
			}
		}
		System.out.println("Could not found " + nameTemp + "'s address.");
		System.out.println("-------------------------------------------------");
	}
	@Override
	public void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("[MENU]");
		System.out.println("0. Add new record");
		System.out.println("1. Search");
		System.out.println("2. Delete");
		System.out.println("3. Quit");
		System.out.print("Select Menu : ");
		
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("-------------------------------------------------");
		
		switch(choice) {
			case 0:
				addRecord();
				break;
			case 1:
				getRecord();
				break;
			case 2:
				delRecord();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong number. Please select from 0 to 3. Return to previous menu.");
				System.out.println("-------------------------------------------------");
				break;
		}
	}	
}
class AddressBookKor extends AddressBook{
	@Override
	public void addRecord() {
		// TODO Auto-generated method stub
		System.out.print("������ �Է����ּ��� : ");
		nameTemp = sc.nextLine();
		System.out.print("�ּҸ� �Է����ּ��� : ");
		addressTemp = sc.nextLine();
		System.out.println(nameTemp + "�� �ּ� " + addressTemp + "�� �߰��Ǿ����ϴ�.");
		System.out.println("-------------------------------------------------");
		Record rc = new Record(nameTemp, addressTemp);
		vr.add(rc);
	}
	@Override
	public void getRecord() {
		// TODO Auto-generated method stub
		System.out.print("�˻��Ͻ� ������ �Է����ּ��� : ");
		nameTemp = sc.nextLine();
		for(int i=0;i<vr.size();i++) {
			if(nameTemp.equals(vr.get(i).getName())) {
				System.out.println(vr.get(i).getName() + " �� �ּҴ� " + vr.get(i).getAddress() + "�Դϴ�.");
				System.out.println("-------------------------------------------------");
				return;
			}
		}
		System.out.println(nameTemp + "���� �ּҰ� ��Ͽ� �����ϴ�.");
		System.out.println("-------------------------------------------------");
	}
	@Override
	public void delRecord() {
		// TODO Auto-generated method stub
		System.out.print("�ּҸ� ���� ������ �Է����ּ��� : ");
		nameTemp = sc.nextLine();
		for(int i=0;i<vr.size();i++) {
			if(nameTemp.equals(vr.get(i).getName())) {
				System.out.println(vr.get(i).getName() + " �� �ּ� " + vr.get(i).getAddress() + "�� �����߽��ϴ�.");
				System.out.println("-------------------------------------------------");
				vr.remove(i);
				return;
			}
		}
		System.out.println(nameTemp + "���� �ּҰ� ��Ͽ� �����ϴ�.");
		System.out.println("-------------------------------------------------");
	}
	@Override
	public void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("[�� ��]");
		System.out.println("0. �� ������ �߰�");
		System.out.println("1. �˻�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.print("�޴��� �����ϼ��� : ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("-------------------------------------------------");
		
		switch(choice) {
			case 0:
				addRecord();
				break;
			case 1:
				getRecord();
				break;
			case 2:
				delRecord();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("�߸��� �����Դϴ�. 0~3�߿� �������ּ���. ���� �޴��� ���ư��ϴ�.");
				System.out.println("-------------------------------------------------");
				break;
		}
	}
}