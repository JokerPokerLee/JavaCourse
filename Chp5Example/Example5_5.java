class Point{
	protected int x,y;
	public Point(){
		x=0;
		y=0;
		System.out.println("点的构建"+this.toString());
	}
	public Point(int a,int b){
		x=a;
		y=b;
		System.out.println("点的构建"+this.toString());
	}
	public String toString(){
		return "["+x+","+y+"]";
	}
}
class Circle extends Point{
	protected double radius;
	public Circle(){
		super();	//使用super关键字调用父类的构造方法；
		radius=0;
		System.out.println("圆的构建"+this.toString());
	}
	public Circle(int a,int b,int r){
		super(a,b);
		radius=r;
		System.out.println("圆的构建"+this.toString());
	}
	public String toString(){
		return "圆心="+super.toString()+"半径="+radius;
	}
}
public class Example5_5{
	public static void main(String args[]){
		Circle circle1=new Circle();
		Circle circle2=new Circle(3,4,5);
	}
}