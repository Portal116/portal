package bookEx;

public class AbstractEx {
	public static void main(String[] args) {
	}
}
abstract class Play{
	boolean pause;
	int currentPos;
	Play(){
		pause = false;
		currentPos = 0;
	}
	abstract void play(int pos);
	abstract void stop();
	void play() {
		play(currentPos);
	}
	void pause() {
		if(pause) {
			pause = false;
			play(currentPos);
		} else {
			pause = true;
			stop();
		}
	}
	abstract void print();
}
abstract class TvPlay extends Play{
	abstract void tvScreen();
	abstract void tvSize();
}
class AudioPlayer extends Play{	
	@Override
	void play(int pos) {
		// TODO Auto-generated method stub
		System.out.println("À½¾ÇÀ» Àç»ýÇÏ±â");
	}
	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("À½¾ÇÀ» ¸ØÃß±â");
	}
	@Override
	void print() {
		// TODO Auto-generated method stub
		
	}	
}
class RealPlayer extends TvPlay{

	@Override
	void tvScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void tvSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void play(int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void print() {
		// TODO Auto-generated method stub
		
	}
}