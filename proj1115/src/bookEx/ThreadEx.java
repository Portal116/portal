package bookEx;

public class ThreadEx {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		ThreadEx1_2 r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		
		t1.start(); // CPU에게 실행하도록 부탁하기
		t2.start();
		t1 = new ThreadEx1_1();
		t1.start(); //한번 실행시킨건 다시 실행시킬 수 없으므로 다시 생성해야 함
	}
}
class ThreadEx1_1 extends Thread{
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println(getName() + "!!!!");
		}
	}
}
class ThreadEx1_2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<50;i++) {
			System.out.println(Thread.currentThread().getName() + "~~~~");
		}
	}	
}