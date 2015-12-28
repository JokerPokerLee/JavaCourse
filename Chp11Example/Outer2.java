public class Outer2{
	private int h;
	public Outer2(int h){
		this.h=h;
	}
	class Inner{
		public void info(){
			System.out.println(Outer2.this.h);
		}
	}
	public static void main(String[] args) {
		Outer2 o1=new Outer2(5);
		Outer2 o2=new Outer2(9);
		Outer2.Inner i1=o1.new Inner();
		Outer2.Inner i2=o1.new Inner();
		Outer2.Inner i3=o2.new Inner();
		i1.info(); 
		i2.info(); 
		i3.info(); 
		System.out.println(i1==i2);
	}
}
