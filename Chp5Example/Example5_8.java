public class Example5_8{
	public static void main(String args[]){
		B b=new B();
		double d=b.area(12);
		System.out.println(d);
	}
}
class A{
	protected int r=10;
	public double area(){
		return r*r;
	}
}
class B extends A{
	//合法覆盖父类的方法
	public double area(){
		return 3.14*r*r/4;
	}
	//在覆盖基础上重载自身方法
	public double area(int x){
		return 3.14*r*x/4;
	}
}