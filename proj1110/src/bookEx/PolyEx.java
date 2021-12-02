package bookEx;

public class PolyEx {
	public static void main(String[] args) {
		Play2 play = new TvPlay2();
		play.a();
	}
}
class Play2{
	void a() {
		System.out.println("play¸Þ¼Òµå");
	}
}
class TvPlay2 extends Play2{

	@Override
	void a() {
		// TODO Auto-generated method stub
		System.out.println("TvPlay");
	}	
}