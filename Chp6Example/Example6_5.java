//栈踪迹范例
class useException extends Exception{
	public useException(){
		super("自定义异常");
	}
}
public class Example6_5{
	public static void m1() throws useException{
		m2();
	}
	public static void m2() throws useException{
		throw new useException();
	}
	public static void main(String args[]){
		try{
			m1();
		}catch(useException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("异常类型:"+e.getClass().getName());
		}
	}
}