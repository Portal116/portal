package ch13;

import javax.swing.*;
import java.util.*;

public class ThreadEx7 {
	public static void main(String[] args) throws Exception {
		ThreadEx7_1 th1 = new ThreadEx7_1();
//		String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
//		System.out.println("입력하신 값은 " + input + "입니다.");
		
		ThreadEx7_2 r = new ThreadEx7_2();
		Thread th2 = new Thread(r);
		
		th1.setPriority(1);
		th2.setPriority(10);
		
		
		System.out.println(th1.getThreadGroup());
		System.out.println(th2.getThreadGroup());
		
		System.out.println(th1.isDaemon());
		System.out.println(th2.isDaemon());
		
		th1.setDaemon(true);
		System.out.println(th1.isDaemon());
		System.out.println(th2.isDaemon());
		
		Map th1map = th1.getAllStackTraces();
		Set th1k = th1map.keySet();
		Iterator<Thread> it = th1k.iterator();
		while(it.hasNext()) {
			Thread t = it.next();
			System.out.println(t);
		}
			
		th1.start();
		th2.start();
	}
}
class ThreadEx7_1 extends Thread {
	public void run() {
		for(int i=5000;i>0;i--) {
			System.out.print("ㅡ");
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
class ThreadEx7_2 implements Runnable {
	@Override
	public void run() {
		for(int i=5000;i>0;i--) {
			System.out.print("ㅣ");
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}