public class Example6_3{
	static void setN(int n){
		System.out.println("set n="+n);
		try{
			if(n==0){
				System.out.println("no exception");
				return;
			}
			else if(n==4){
				int i=0;
				int j=4/i;
			}
			else if(n==8){
				int iArray[]=new int[4];
				iArray[10]=3;
			}
		}catch(ArithmeticException e){
			System.out.println("catched exception is "+e);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("catched exception is"+e.getMessage());
		}catch(Exception e){
			System.out.println("other exceptions");
		}finally{
			System.out.println("finally block");//运行结果表明无论发生异常与否，都会执行finally块中的语句
		}
	}
	public static void main(String args[]){
		setN(0);
		setN(4);
		setN(8);
		System.out.println("end!");
	}
}