package book;

public class SwitchEx {
	public static void main(String[] args) {
		String word = "a";
		switch(word) {
			case "a":
				System.out.println("a로 시작되는 영어는 ant가 있다.");
			case "b":
				System.out.println("b로 시작되는 영어는 bear가 있다.");
			case "c":
				System.out.println("c로 시작되는 영어는 cat가 있다.");
			case "d":
				System.out.println("d로 시작되는 영어는 dog가 있다.");
		}
		String a = "ANSS";
		a = a + "\n" + "ANSS";
		System.out.printf("%s",a);
	}
}