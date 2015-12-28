//µÝ¹éÀý³Ì
class Example4_9{
	static long fac(int n){
		if(n==1) return 1;
		else return n*fac(n-1);
	}
	public static void main(String args[]){
		int k=10;
		System.out.println(fac(k));
	}
}