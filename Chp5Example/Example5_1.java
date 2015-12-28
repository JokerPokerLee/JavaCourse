//在类内部创建对象，可以访问自己的私有变量和私有方法
class Example5_1{
	private int books;
	Example5_1(){
		books=15;
	}
	private int getnum(){
		return books;
	}
	public static void main(String args[]){
		Example5_1 t1=new Example4_1();
		t1.books=30;
		int m=t1.getnum();
		System.out.println("books="+m);
	}
}