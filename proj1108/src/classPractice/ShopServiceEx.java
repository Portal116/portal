package classPractice;

public class ShopServiceEx { //Ŭ���� �������� 4��
	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		if(obj1 == obj2)
			System.out.println("���� ��ü");
		else
			System.out.println("�ٸ� ��ü");
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