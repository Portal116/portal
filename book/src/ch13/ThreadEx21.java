package ch13;

public class ThreadEx21 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx21();
		new Thread(r).start();
		new Thread(r).start();
	}
}
class RunnableEx21 implements Runnable{
	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random()*3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
	}
}
class Account{
	private int balance = 1000;
	
	public int getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public synchronized void withdraw(int money) {
		// TODO Auto-generated method stub
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			balance -= money;
		}
	}
}