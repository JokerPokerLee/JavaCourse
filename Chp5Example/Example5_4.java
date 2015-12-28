public class Example5_4{
	int number;
	public Example5_4(int n){
		this.count();	//this指代当前使用构造方法的对象exa
		number=n;
		this.count();
	}
	void count(){
		System.out.println("The number is "+number);
	}
	public static void main(String args[]){
		Example5_4 exa=new Example5_4(5);
	}
}