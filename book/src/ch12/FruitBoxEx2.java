package ch12;

import java.util.*;

public class FruitBoxEx2 {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Toy> toyBox = new FruitBox<Toy>();
//		t extends에 toy가 없으므로 사용 불가
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		appleBox.add(new Grape());
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox-" + fruitBox);
		System.out.println("appleBox-" + appleBox);
		System.out.println("grapeBox-" + grapeBox);
	}
}
interface Eatable{}
class Fruit implements Eatable{
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
class Toy{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Toy";
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
	int size() {
		return list.size();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return list.toString();
	}
}
class FruitBox<T extends Fruit & Eatable> extends Box<T>{}