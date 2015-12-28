//方法的调用例程
public class Example4_4{
	static double scircle(int r){
		double ss;
		ss=3.14*r*r;
		return(ss);
	}
	static void area(int a,int b){
		int s;
		s=a*b;
		System.out.println(s);
	}
	public static void main(String args[]){
		int x=5,y=4;
		double result=scircle(x);
		System.out.println(result);
		area(x,y);
		System.out.println(scircle(y));
	}
}		