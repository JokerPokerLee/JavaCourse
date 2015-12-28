abstract class Device{
	private String name;
	public Device(){}
	public Device(String name){
		this.name=name;
	}
	public abstract double getPrice();
	public String getName(){
		return name;
	}
}
public class AnonymousInner{
	public void test(Device d){
		System.out.println(d.getName()+","+d.getPrice());
	}
	public static void main(String[] args) {
		AnonymousInner ai=new AnonymousInner();
		ai.test(new Device("mouse"){
			public double getPrice(){
				return 67.8;
			}
		});
		Device d=new Device(){
			{
				System.out.println("匿名内部类的初始化模块：");
			}
			public double getPrice(){
				return 777;
			}
			public String getName(){
				return "Monitor";
			}
		};
		ai.test(d);
	}
}
