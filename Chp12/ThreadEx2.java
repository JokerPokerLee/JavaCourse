import java.util.*;
public class ThreadEx2 extends Thread{
	String s;
	int m,i=0;
	ThreadEx2(String s){
		this.s=s;
	}
	public void run(){
		try{
			sleep((new Random().nextInt(100))*10);
			System.out.println(s+"finished");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		ThreadEx2 a=new ThreadEx2("a  ");
		ThreadEx2 b=new ThreadEx2("b  ");
		a.start();b.start();
		System.out.println("main is finished");
	}
}