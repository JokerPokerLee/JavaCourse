public class Example6_2{
	static void throwmethod() throws IllegalAccessException{
		System.out.println("throw an exception in throwmethod");
		//�׳��������쳣����
		throw new IllegalAccessException();
	}
	public static void main(String args[]){
		try{
			throwmethod();
		}catch(IllegalAccessException e){
			System.out.println("catch an exception:"+e+"�Ƿ����ʴ����쳣");
		}
	}
}