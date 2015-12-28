//等电梯例程
import java.util.*;
public class Example4_2{
	public static void main(String args[]){	
		Scanner reader=new Scanner(System.in);
		int x,y;
		x=reader.nextInt();
		y=reader.nextInt();
		WaitE p1=new WaitE(x,y);
		p1.WTime();
		WaitE.ePoint=x;
		p1.RTime();
		WaitE.ePoint=y;
		x=reader.nextInt();
		y=reader.nextInt();
		WaitE p2=new WaitE(x,y);
		p2.WTime();
		WaitE.ePoint=x;
		p2.RTime();
		WaitE.ePoint=y;
	}
}	
class WaitE {
	static int ePoint=0; 
    final int speed=10;
    int sPoint;
    int dPoint;	
    public int getEPoint(){	return ePoint;}
    public int getSpeed(){return speed;}
    WaitE(int s,int d){
    	sPoint=s;
    	dPoint=d;}
   	public void  WTime(){
   		if(sPoint==ePoint) System.out.println("不需要等待");
   		else System.out.println("需要等待"+Math.abs(ePoint-sPoint)*speed+"秒");}
	public void RTime(){
		if(dPoint==ePoint) System.out.println("处于同一层!");
		else System.out.println("到达目的楼层需"+Math.abs(ePoint-dPoint)*speed+"秒");}
}