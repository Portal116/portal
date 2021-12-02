package ch07;

public class FinalCardTest {
	public static void main(String[] args) {
		Card2 c = new Card2("HEART",10);
//		c.NUMBER = 5;
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);
		System.out.println(c.toString());
	}
}
class Card2{
	final String KIND;
	final int NUMBER;
	
	Card2(){
		this("HEART", 1);
	}
	Card2(String kind, int number) {
		// TODO Auto-generated constructor stub
		KIND = kind;
		NUMBER = number;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return KIND + " " + NUMBER;
	}
}