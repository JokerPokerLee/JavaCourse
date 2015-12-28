//½Ó¿Ú·¶Àý
interface Shape2D{
	final double PI=3.14;
	void area();
	void perimeter();
}
class Rectangle implements Shape2D{
	int width,height;
	public Rectangle(int w,int h){
		width=w;
		height=h;
	}
	public void area(){
		System.out.println(width*height);
	}
	public void perimeter(){
		System.out.println(2*width+2*height);
	}
}
class Circle implements Shape2D{
	int radius;
	public Circle(int r){
		radius=r;
	}
	public void area(){
		System.out.println(PI*radius*radius);
	}
	public void perimeter(){
		System.out.println(2*PI*radius);
	}
}