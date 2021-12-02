package ch07;

public class PointTest {
	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println("p3.x = " + p3.x);
		System.out.println("p3.y = " + p3.y);
		System.out.println("p3.z = " + p3.z);
	}
}

class Point {
	int x = 10;;
	int y = 20;;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	String getLocation() {
		return "x: " + x + ", y : " + y;
	}
	int calXY() {
		if(x>y)
			return x-y;
		else
			return y-x;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

class Point3D extends Point {
	int z = 30;
	
	Point3D(){
		this(100,200,300);
	}
	Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;
	}
	String getLocation() {
		return "x: " + x + ", y : " + y + ", z : " + z;
	}
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	int calXY() {
		// TODO Auto-generated method stub
		if(x>y) {
			if(y>z)
				return x-z; // x y z
			else if(z>x)
				return y-z; // z x y
			else
				return x-y; // x z y
		}
		else {
			if(x>=z)
				return y-z; // y x z
			else if(z>y)
				return x-z; // z y x
			else
				return x-y; // y z x
				
		}
	}
	
}