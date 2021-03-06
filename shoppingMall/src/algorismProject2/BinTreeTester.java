package algorismProject2;

import java.util.Scanner;

public class BinTreeTester {
	static Scanner sc = new Scanner(System.in);

	// 회원번호 이름
	static class Data {
		public static final int NO = 1;
		public static final int NAME = 2;

		private Integer no;
		private String name;

		Integer keyCode() {
			return no;
		}

		public String toString() {
			return name;
		}

		void scanData(String guide, int sw) {
			if ((sw & NO) == NO) {
				System.out.print("상품 번호 입력 : ");
				no = sc.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("상품명 : ");
				name = sc.next();
			}
		}
	}// end Data class

	enum Menu {
		ADD("삽입"), REMOVE("삭제"), SEARCH("검색"), PRINT("표시"), TERMINATE("종료");

		private final String message;

		static Menu MenuAt(int idx) {
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {
			message = string;
		}

		String getMessage() {
			return message;
		}

	} // end Menu enum

	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s ", m.ordinal() + 1, m.getMessage());
			System.out.println();
			System.out.print("메뉴 선택 : ");
			key = sc.nextInt();
		} while (key < Menu.ADD.ordinal() + 1 || key > Menu.TERMINATE.ordinal() + 1);

		return Menu.MenuAt(key - 1);
	}

	public static void main(String[] args) {
		// 392
		Menu menu;
		Data data;
		Data ptr;
		Data temp = new Data();
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

		while (true) {
			switch (menu = SelectMenu()) {
			case ADD:// 노드를 삽입
				System.out.println();
				System.out.println("상품 등록");
				data = new Data();
				data.scanData("삽입", Data.NO | Data.NAME);
				tree.add(data.keyCode(), data);
				System.out.println();
				break;
			case REMOVE:
				System.out.println();
				System.out.println("상품 삭제");
				temp.scanData("검색", Data.NO);
				tree.remove(temp.keyCode());
				System.out.println("상품 삭제 완료");
				System.out.println();
				break;
			case SEARCH:
				System.out.println();
				System.out.println("상품 검색");
				temp.scanData("검색", Data.NO);
				ptr = tree.search(temp.keyCode());
				if (ptr != null)
					System.out.println("상품명 : " + ptr);
				else
					System.out.println("해당 데이터가 없습니다");
				System.out.println();
				break;
			case PRINT:
				tree.print();
				System.out.println();
				break;
			case TERMINATE:
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}

}
