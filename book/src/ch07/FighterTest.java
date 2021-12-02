package ch07;

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		if(f instanceof Unit)
			System.out.println("f는 Unit클래스");
		if(f instanceof Fightable)
			System.out.println("f는 Fightable클래스");
		if(f instanceof Movable)
			System.out.println("f는 Movable클래스");
		if(f instanceof Attackable)
			System.out.println("f는 Attackable클래스");
		if(f instanceof Object)
			System.out.println("f는 Object클래스");
	}
}
class Unit{
	int currentHP;
	int x;
	int y;
}
interface Movable{
	void move(int x, int y);
}
interface Attackable{
	void attack(Unit u);
}
interface Fightable extends Movable, Attackable{
	
}
class Fighter extends Unit implements Fightable{

	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub
		System.out.println("attack");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(x + " " + y + "move");
	}
	
}