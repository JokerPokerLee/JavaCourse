class UseException extends Exception{
	int n=0;
	UseException(){
		n++;
	}
	UseException(String s){
		super(s);
		n++;
	}
	String show(){return "selfDefinedExceptionObj:"+n;}
}
public class Example6_4{
	static void Test() throws UseException{
		UseException e = new UseException("selfDefinedExceptionObj");
		throw e;
	}
	public static void main(String args[]){
		try{
			Test();
		}catch(UseException e){
			System.out.println(e.show());
		}
	}
}