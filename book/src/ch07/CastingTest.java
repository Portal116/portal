package ch07;

public class CastingTest {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		Car ab = new Ambulance();
		
		fe.water();
		car = fe;
//		car.water();
		fe2 = (FireEngine)car;
		fe2.water();
		
		fe.drive();
		fe.stop();
		fe.water();
		
		Ambulance ab2 =(Ambulance)ab;
		ab2.siren();
	}
}
class FireEngine extends Car{
	void water() {
		System.out.println("water!!");
	}
}
class Ambulance extends Car{
	void siren() {
		System.out.println("siren~~~~~");
	}
}
class Car{
	String color;
	int door;
	
	void drive(){
		System.out.println("drive, Brrr~");
	}
	void stop() {
		System.out.println("stop!!");
	}
}