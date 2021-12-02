package p354;

public class CastingTest {
	public static void main(String[] args) {
		//다형성으로 객체생성하기		부모클래스명 변수명 = new 자식클래스명();
		Tv t = new CaptionTv();
		//큰타입 = 부모클래스  작은타입 = 자식클래스
		t.power=true;
		t.channel=13;
		t.power();
		t.channelUp();
		t.channelDown();
		//t변수는 부모타입을 정의 되어 있기 때문에 자식 클래스의 멤버는 접근 못함
		//힙메모리에는 이미 CaptionTv의 멤버들이 올려져 있다. 
		//그래서 t변수를 자손타입으로 형변환을 해준다.  down casting : 큰타입--> 작은타입
		CaptionTv ctt = (CaptionTv) t;
		ctt.text="캡션Tv";
		ctt.caption();
	}
}
class Tv{
	boolean power;//전원상태 on, off
	int channel;
	
	void power(){ power=!power; System.out.println(power);}
	void channelUp() { ++channel;System.out.println(channel); }
	void channelDown() { --channel; System.out.println(channel);}
	
}
class CaptionTv extends Tv{
	String text;
	void caption() { System.out.println(text); }
}