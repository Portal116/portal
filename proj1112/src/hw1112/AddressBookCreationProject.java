package hw1112;

import java.util.*;

public class AddressBookCreationProject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("사용할 언어를 선택해 주세요 / choose your language");
			System.out.print("한국어 0, English 1 : ");
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
					System.out.println("잘못된 선택입니다. 0,1 중에 선택해주세요. 초기 메뉴로 돌아갑니다.");
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
		System.out.print("성함을 입력해주세요 : ");
		nameTemp = sc.nextLine();
		System.out.print("주소를 입력해주세요 : ");
		addressTemp = sc.nextLine();
		System.out.println(nameTemp + "의 주소 " + addressTemp + "가 추가되었습니다.");
		System.out.println("-------------------------------------------------");
		Record rc = new Record(nameTemp, addressTemp);
		vr.add(rc);
	}
	@Override
	public void getRecord() {
		// TODO Auto-generated method stub
		System.out.print("검색하실 성함을 입력해주세요 : ");
		nameTemp = sc.nextLine();
		for(int i=0;i<vr.size();i++) {
			if(nameTemp.equals(vr.get(i).getName())) {
				System.out.println(vr.get(i).getName() + " 의 주소는 " + vr.get(i).getAddress() + "입니다.");
				System.out.println("-------------------------------------------------");
				return;
			}
		}
		System.out.println(nameTemp + "님의 주소가 목록에 없습니다.");
		System.out.println("-------------------------------------------------");
	}
	@Override
	public void delRecord() {
		// TODO Auto-generated method stub
		System.out.print("주소를 지울 성함을 입력해주세요 : ");
		nameTemp = sc.nextLine();
		for(int i=0;i<vr.size();i++) {
			if(nameTemp.equals(vr.get(i).getName())) {
				System.out.println(vr.get(i).getName() + " 의 주소 " + vr.get(i).getAddress() + "를 삭제했습니다.");
				System.out.println("-------------------------------------------------");
				vr.remove(i);
				return;
			}
		}
		System.out.println(nameTemp + "님의 주소가 목록에 없습니다.");
		System.out.println("-------------------------------------------------");
	}
	@Override
	public void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("[메 뉴]");
		System.out.println("0. 새 내용을 추가");
		System.out.println("1. 검색");
		System.out.println("2. 삭제");
		System.out.println("3. 종료");
		System.out.print("메뉴를 선택하세요 : ");
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
				System.out.println("잘못된 선택입니다. 0~3중에 선택해주세요. 이전 메뉴로 돌아갑니다.");
				System.out.println("-------------------------------------------------");
				break;
		}
	}
}