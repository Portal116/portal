package classPractice;

public class MemberMain { //클래스 연습문제
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
		Member user2 = new Member("김자바", "java");
		MemberService ms = new MemberService();
		if(ms.login(user1.id, user1.password))
			System.out.println("로그인 되었습니다.");
		else
			System.out.println("id 혹은 password가 틀렸습니다.");
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
		System.out.println("로그아웃 되었습니다.");
	}
}