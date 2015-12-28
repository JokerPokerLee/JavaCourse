public class Cow
{
	private double weight;
	public Cow(){
	}
	public Cow(double weight){
		this.weight=weight;
	}
	private class CowLeg{
		//非法！非静态内部类里不允许定义静态成员
		/* 
		static int num=4;		
		static void getNum(){
			System.out.println(num);
		}
		*/
		private double length;
		private String color;

		public CowLeg(){
		}
		public CowLeg(double length,String color){
			this.length=length;
			this.color=color;
		}
		public void info(){
			System.out.println("当前牛腿颜色是："+color+",长度"+length);
			System.out.println("本牛腿所在的奶牛重："+weight);
		}	
	}
	public void test(){
//		System.out.println(color);   非法！此时还未有内部类对象寄生在外部类对象中，因此无法访问
		CowLeg cl=new CowLeg(1.12,"黑色");
		cl.info();
	}
	public static void main(String[] args) {
		Cow cow=new Cow(378.9);
//		new CowLeg();  非法！静态成员不能访问非静态成员
		cow.test();
	}
}
