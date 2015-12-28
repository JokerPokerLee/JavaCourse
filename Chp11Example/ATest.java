interface A{
	void test();
}
public class ATest{
	public static void main(String[] args){
		int age=8;
		A a=new A(){
			public void test(){
				System.out.println(age);
				age=2;
			}
		};
		a.test();
	}
}
