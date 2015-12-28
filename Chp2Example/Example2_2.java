//Î»ÔËËã²Ù×÷
public class Example2_2 {
	public static void main(String[] args) 
	{
		int x1=-124,x2=55;
		int y1=-52,y2=-45;
		int z=15;
		System.out.println(~x1);
		System.out.println(Integer.toBinaryString(~x1));
		System.out.println(x1&y1);
		System.out.println(Integer.toBinaryString(x1&y1));
		System.out.println(x1|y1);
		System.out.println(Integer.toBinaryString(x1|y1));
		System.out.println(z<<2);
		System.out.println(Integer.toBinaryString(z<<2));
		System.out.println(x2>>2);
		System.out.println(Integer.toBinaryString(x2>>2));
		System.out.println(y2>>2);
		System.out.println(Integer.toBinaryString(y2>>2));
		System.out.println(x2>>>2);
		System.out.println(Integer.toBinaryString(x2>>>2));
		System.out.println(y2>>>2);
		System.out.println(Integer.toBinaryString(y2>>>2));
	}
}