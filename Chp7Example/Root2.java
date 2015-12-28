//格式化输出
public class Root2 {
    public static void main(String[] args) {
    	int i=2;
    	double r=Math.sqrt(i);
    	System.out.format("The squareroot of %d is %f.%n",i,r);
    	System.out.format("%f, %1$+020.10f %n", Math.PI);
    	System.out.format("%f, %2$+020.10f %n", Math.PI,Math.PI-1);
       
    }
}