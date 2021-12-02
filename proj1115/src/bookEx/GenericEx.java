package bookEx;

public class GenericEx {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.setT("문자열1");
//		box.setT(10);
		System.out.println(box.getT());
		
		Box<Boolean> box1 = new Box<Boolean>();
		box1.setT(true);
		System.out.println(box1.getT());
		
		Box<A> box2 = new Box<A>();
		box2.setT(new A());
		System.out.println(box2.getT());
	}
}
class A{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "A클래스";
	}
	
}
class Box<T>{
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}