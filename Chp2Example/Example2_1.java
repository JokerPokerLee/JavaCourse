//自加自减以及字符串连接操作
public class Example2_1 {
	public static void main(String[] args)
	{
		int x1=10,x2=10,x3=10,x4=10;
		{
			int y1,y2,y3,y4;
			y1=++x1;	
			y2=x2++;	
			y3=--x3;	
			y4=x4--;	
			System.out.println("y1="+y1+" y2="+y2+" y3="+y3+" y4="+y4);
			System.out.println("x1="+x1+" x2="+x2+" x3="+x3+" x4="+x4);
		}
		{
			int d1=x1/x3;
			System.out.println(d1);}
			{String s1="my";
			String s2="java";
			char c1='s';
			System.out.println(s1+s2);
			System.out.println(s1+c1);
			System.out.println(s1+5);
		}
	}
}