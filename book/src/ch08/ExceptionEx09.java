package ch08;

public class ExceptionEx09 {
	public static void main(String[] args) {
		try {
			Exception e = new Exception("���Ƿ� �߻�������");
			throw e;
//			throw new Exception("���Ƿ� �߻�������") �� 2�� ���չ���
		} catch (Exception e) {
			System.out.println("���� �޽��� : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("���α׷��� ���� �����");
	}
}