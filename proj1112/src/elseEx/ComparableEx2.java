package elseEx;

import java.util.*;

public class ComparableEx2 {
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new SortFruit());
		
		treeSet.add(new Fruit("포도",3000));
		treeSet.add(new Fruit("수박",10000));
		treeSet.add(new Fruit("딸기",6000));
		treeSet.add(new Fruit("바나나",5000));
		
		Iterator<Fruit> it = treeSet.iterator();
		while(it.hasNext()) {
			Fruit f = it.next();
			System.out.println(f.name + " " + f.price);
		}
	}
}
class Fruit{
	String name;
	int price;
	
	public Fruit(String name, int price) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
	}
}
class SortFruit implements Comparator<Fruit>{
	@Override
	public int compare(Fruit f1, Fruit f2) {
		// TODO Auto-generated method stub
		return f1.price - f2.price;
	}	
}