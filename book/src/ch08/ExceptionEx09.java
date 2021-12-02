package ch08;

public class ExceptionEx09 {
	public static void main(String[] args) {
		try {
			Exception e = new Exception("고의로 발생시켰음");
			throw e;
//			throw new Exception("고의로 발생시켰음") 위 2줄 통합버전
		} catch (Exception e) {
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료됨");
	}
}