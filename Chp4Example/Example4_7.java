//参数值传递例程
public class Example4_7{
	static void swapxy(int x,int y){
		int temp;
		System.out.print("交换前:");
		System.out.println("x="+x+",y="+y);
		temp=x;x=y;y=temp;
		System.out.print("交换后");
		System.out.println("x="+x+",y="+y);
	}
	public static void main(String args[]){
		int u=30,v=50;
		System.out.print("调用前:");
		System.out.println("u="+u+",v="+v);
		swapxy(u,v);
		System.out.print("调用后");
		System.out.println("u="+u+",v="+v);
	}
}