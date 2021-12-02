package classPractice;

public class ShopServiceEx { //클래스 연습문제 4번
	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		if(obj1 == obj2)
			System.out.println("같은 객체");
		else
			System.out.println("다른 객체");
	}
}
class ShopService{
	private static ShopService ss = new ShopService();
	private ShopService() {}
	public static ShopService getInstance() {
		// TODO Auto-generated method stub
		return ss;
	}
}