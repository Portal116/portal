package ex1318;

import java.util.Calendar;

public class SingleTonEx {
	public static void main(String[] args) {
		System.out.println(SingleTonClass.getInstance()); // »£√‚
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
	}
}
class SingleTonClass{
	private static SingleTonClass st = new SingleTonClass();
	private SingleTonClass() {}
	static SingleTonClass getInstance() {
		return st;
	}
}