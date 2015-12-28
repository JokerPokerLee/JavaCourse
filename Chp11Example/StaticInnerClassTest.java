public class StaticInnerClassTest{
	private int prop1=5;
	private static int prop2=9;
	static class StaticInnerClass{
		private static int age=18;
		private String name="John";
		public void accessOuterProp(){			
//			System.out.println(prop1);  非法！静态成员不能访问非静态成员！
			System.out.println(prop2);
			System.out.println(new StaticInnerClassTest().prop1);
		}
	}
	public static void main(String args[]){
		System.out.println(StaticInnerClass.age);
//		System.out.println(StaticInnerClass.name);  
		System.out.println(new StaticInnerClass().name);
//		StaticInnerClass.accessOuterProp();
		new StaticInnerClass().accessOuterProp();
	}
}
