package bookEx;

public class AbstractEx2 {
	public static void main(String[] args) {
//		Marine m = new Marine();
//		Tank t = new Tank();
//		Dropship d = new Dropship();
//		
//		m.stimpack();
//		m.move(10, 20);
//		m.stop();
//		
//		t.move(30, 40);
//		t.stop();
//		t.changeMode();
//		
//		d.load();
//		d.move(100, 200);
//		d.unload();
		
		Unit m = new Marine();
		Unit t = new Tank();
		Unit d = new Dropship();
		m.move(100, 200);
		((Marine) m).stimpack();
	}
}
abstract class Unit{
	int x,y;
	abstract void move(int x, int y);
	abstract void stop();
}

class Marine extends Unit{
	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		// ������ ��ġ�� �̵�
		System.out.println("Marine move " + x + "," + y);
	}
	
	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("Marine stop");
	}

	void stimpack() {
		// ������ ���
		System.out.println("use stimpack");
	}
	
}
class Tank extends Unit{
	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		// ������ ��ġ�� �̵�
		System.out.println("Tank move " + x + "," + y);
	}
	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("Tank stop");
	}
	void changeMode() {
		// ���ݸ�� ��ȯ
		System.out.println("change attack mode");
	}
}
class Dropship extends Unit{
	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		// ������ ��ġ�� �̵�
		System.out.println("Dropship move " + x + "," + y);
	}
	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("Dropship stop");
	}
	void load() {
		// ���õ� ����� �¿�
		System.out.println("in");
	}
	void unload() {
		// ���õ� ����� ����
		System.out.println("out");
	}
}