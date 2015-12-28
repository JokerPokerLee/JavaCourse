class Outer{
	class Inner{
		public Inner(){}
		public Inner(String s){
			System.out.println(s);
		}
	}
}
class subClass extends Outer.Inner{
	public subClass(Outer o){
		o.super("hello");
	}
}
public class CreateInnerInstance{
	public static void main(String[] args) {
		Outer.Inner in=new Outer().new Inner("test");
		new subClass(new Outer());
	}
}
