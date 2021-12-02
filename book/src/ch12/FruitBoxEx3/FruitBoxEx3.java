package ch12.FruitBoxEx3;

import java.util.*;

public class FruitBoxEx3 {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
	}
}

class Fruit{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fruit";
	}
}
class Apple extends Fruit{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Apple";
	}
}
class Grape extends Fruit{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Grape";
	}
}
class Juice{
	String name;
	Juice(String name){
		this.name = name + "Juice";
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
class Juicer{
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp = "";
		for(Fruit f : box.getList())
			tmp += f + " ";
		return new Juice(tmp);
	}
}
class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {
		list.add(item);
	}
	T get(int i) {
		return list.get(i);
	}
	ArrayList<T> getList(){
		return list;
	}
	int size() {
		return list.size();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return list.toString();
	}
}
class FruitBox<T extends Fruit> extends Box<T>{}