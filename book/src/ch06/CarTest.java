package ch06;

public class CarTest {
	public static void main(String[] args) {
//		Car c1 = new Car();
//		c1.color = "white";
//		c1.gearType = "auto";
//		c1.door = 4;
//		
//		Car c2 = new Car("white", "auto", 4);
//		
//		Car c1 = new Car();
//		Car c2 = new Car("blue");
		
		Car c1 = new Car();
		Car c2 = new Car(c1);
		System.out.println("c1 의 color = " + c1.color
				+ ", gearType = " + c1.gearType + ", door = "
				+ c1.door);
		System.out.println("c2 의 color = " + c2.color
				+ ", gearType = " + c2.gearType + ", door = "
				+ c2.door);
		
		c1.door = 100;
		System.out.println("c1.door = 100; 수정 후");
		System.out.println("c1 의 color = " + c1.color
				+ ", gearType = " + c1.gearType + ", door = "
				+ c1.door);
		System.out.println("c2 의 color = " + c2.color
				+ ", gearType = " + c2.gearType + ", door = "
				+ c2.door);
	}
}
class Car{
	String color;
	String gearType;
	int door;
	
	Car(){
		this("white","auto",4);
	}
	Car(Car c){
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}
	Car(String color){
		this(color,"auto",4);
	}
	Car(String c, String g, int d){
		color = c;
		gearType = g;
		door = d;
	}
}