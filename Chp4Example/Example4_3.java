//常量与静态变量
class Example4_3{
	public static void main(String args[]){
		System.out.println(Tom.MIN);
		Tom tom=new Tom();
		System.out.println(tom.MIN+tom.MAX);
	}
}
class Tom{
	final int MAX=70;
	static final int MIN=30;
}	