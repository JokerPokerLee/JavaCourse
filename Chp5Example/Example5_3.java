//构造方法链范例
public class Example5_3 extends Employee{
	public static void main(String args[]){
		new Example5_3();
	}
	public Example5_3(){
		System.out.println("类Example5_3的无参构造方法");
	}
}
class Employee extends Person{
	public Employee(){
		System.out.println("类Employee的无参构造方法");
	}
}
class Person{
	public Person(){
		System.out.println("类Person的无参构造方法");
	}
}