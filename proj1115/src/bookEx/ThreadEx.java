package bookEx;

public class ThreadEx {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		ThreadEx1_2 r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		
		t1.start(); // CPU���� �����ϵ��� ��Ź�ϱ�
		t2.start();
		t1 = new ThreadEx1_1();
		t1.start(); //�ѹ� �����Ų�� �ٽ� �����ų �� �����Ƿ� �ٽ� �����ؾ� ��
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