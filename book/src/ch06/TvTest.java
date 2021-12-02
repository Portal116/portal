package ch06;

public class TvTest {
	public static void main(String[] args) {
//		//TvTest
//		Tv t;
//		t = new Tv();
//		t.channel = 7;
//		t.channelDown();
//		System.out.println("현재 채널은 " + t.channel + " 입니다.");
		
//		//TvTest2
//		Tv t1 = new Tv();
//		Tv t2 = new Tv();
//		System.out.println("t1의 channel 값은 " + t1.channel + " 입니다.");
//		System.out.println("t2의 channel 값은 " + t2.channel + " 입니다.");
//		
//		t1.channel = 7;
//		System.out.println("t1의 channel 값을 7로 변경하였습니다.");
//
//		System.out.println("t1의 channel 값은 " + t1.channel + " 입니다.");
//		System.out.println("t2의 channel 값은 " + t2.channel + " 입니다.");
		
//		//TvTest3
//		Tv t1 = new Tv();
//		Tv t2 = new Tv();
//		System.out.println("t1의 channel 값은 " + t1.channel + " 입니다.");
//		System.out.println("t2의 channel 값은 " + t2.channel + " 입니다.");
//		
//		t2 = t1;
//		t1.channel = 7;
//		System.out.println("t1의 channel 값을 7로 변경하였습니다.");
//		
//		System.out.println("t1의 channel 값은 " + t1.channel + " 입니다.");
//		System.out.println("t2의 channel 값은 " + t2.channel + " 입니다.");
		
		//TvTest4
		Tv[] tvArr = new Tv[3];
		
		for(int i=0;i<tvArr.length;i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i+10;
		}
		
		for(int i=0;i<tvArr.length;i++) {
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel=%d%n",i,tvArr[i].channel);
		}
	}
}
class Tv{
	String color;
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}