package classPractice;

public class MemberMain { //Ŭ���� ��������
	public static void main(String[] args) {
		Member user1 = new Member("ȫ�浿", "hong");
		Member user2 = new Member("���ڹ�", "java");
		MemberService ms = new MemberService();
		if(ms.login(user1.id, user1.password))
			System.out.println("�α��� �Ǿ����ϴ�.");
		else
			System.out.println("id Ȥ�� password�� Ʋ�Ƚ��ϴ�.");
		ms.logout(user1.id);
	}
}
class Member{
	String name;
	String id;
	String password = "12345";
	int age;
	
	public Member() {}
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
}
class MemberService{
	public boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345"))
			return true;
		else
			return false;
	}
	public void logout(String id) {
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}
}