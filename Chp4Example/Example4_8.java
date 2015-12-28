//参数引用传递例程
class Circle{
	double r;
	Circle(double r){
		this.r=r;
	}
	double getRadius(){
		return(r);
	}
	double getArea(){
		return(3.14*r*r);
	}
	void setRadius(double r){
		this.r=r;
	}
}
public class Example4_8{
	public static void main(String[] args){
		Circle myCircle = new Circle(1);
		printAreas(myCircle);
		System.out.println("Radius is "+myCircle.getRadius());
	}
	public static void printAreas(Circle c){
		System.out.println(c.getRadius()+" "+c.getArea());
		c.setRadius(c.getRadius()+1);
	}
}