class StaticOut{
	static class StaticIn{
		public StaticIn(){
			System.out.println("This is the constructor of In");
		}
	}
}
class subClass extends StaticOut.StaticIn{ }
public class CreateStaticInnerInstance{
	public static void main(String[] args){
		StaticOut.StaticIn si=new StaticOut.StaticIn();
		new subClass();
	}
}