class MethodOverload{
	//方法的重载
	void receive(int i){
		System.out.println("Receive an integer:"+i);
	}
	void receive(int i,int j){
		System.out.println("Receive two integer:"+i+","+j);
	}
	void receive(double d){
		System.out.println("Receive a double data:"+d);
	}
	void receive(String s){
		System.out.println("Receive a string:"+s);
	}
}
public class Example5_7{
	public static void main(String args[]){
		MethodOverload mo=new MethodOverload();
		mo.receive(1);
		mo.receive(2,3);
		mo.receive(12.45);
		mo.receive("this is a String");
	}
}