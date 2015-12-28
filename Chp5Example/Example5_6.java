public class Example5_6{
	public static void main(String args[]){
		SubClass sub=new SubClass();
		sub.doSomething();
	}
}
class SuperClass{
	int x;
	SuperClass(){
		x=3;
		System.out.println("in SuperClass:x="+x);
	}
	void doSomething(){
		System.out.println("in SuperClass.doSomething()");
	}
}
class SubClass extends SuperClass{
	int x;	//子类成员变量隐藏了父类的成员变量
	SubClass(){
		x=5;
		System.out.println("in SubClass:x="+x);
	}
	//子类的成员方法覆盖了父类的成员方法
	void doSomething(){
		super.doSomething();	//用super来访问父类被隐藏的成员变量或调用父类被覆盖的方法；
		System.out.println("in SubClass.doSomething()");
		System.out.println("super.x="+super.x+";sub.x="+x);
	}
}