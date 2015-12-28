//³éÏóÀà·¶Àý
import java.awt.*;
public class Example5_9{
	Shape s1=new Circle(5);
	Shape s2=new Rectangle(10,8);
}
abstract class Shape{
	final double PI=3.14;
	Color c;
	abstract double getArea();
	abstract double getPerimeter();
	Color getColor(){
		return c;
	}
	void setColor(Color newC){
		c=newC;
	}
}
class Rectangle extends Shape{
	double w,h;
	Rectangle(double w,double h){
		this.w=w;
		this.h=h;
	}
	double getArea(){
		return w*h;
	}
	double getPerimeter(){
		return 2*(w+h);
	}
}
class Circle extends Shape{
	double r;
	Circle(double r){
		this.r=r;
	}
	double getArea(){
		return PI*r*r;
	}
	double getPerimeter(){
		return 2*PI*r;
	}
}
class Triangle extends Shape{
	double a,b,c;
	double getArea(){
		double p=(a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
	double getPerimeter(){
		return a+b+c;
	}
}