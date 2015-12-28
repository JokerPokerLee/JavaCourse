public class Example6_1{
	public static int Sum() throws NegativeArraySizeException{
		int s=0;
		int x[]=new int[-8];
		for(int i=0;i<4;i++){
			x[i]=2*i;
			s=s+x[i];
			}
		return s;
		}
	public static void main(String args[]){
		try{
			System.out.println(Sum());//Sum()方法未对异常进行处理，沿调用链回溯找到调用者main()，由它来进行异常捕获和处理
		}catch(NegativeArraySizeException e){
			System.out.println("异常信息:"+e.toString()+"数组负下标异常");
		}
	}
}