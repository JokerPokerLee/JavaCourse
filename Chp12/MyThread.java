import java.util.*;
/*
public class MyThread extends Thread{
	public void run(){
		System.out.println(new Random().nextInt(100));
	}
	public static void main(String[] args) {
		new MyThread().start();
	}
}*/
class Task implements Runnable{
	public void run(){
		System.out.println(new Random().nextInt(100));
	}
}
public class MyThread{
	public static void main(String[] args) {
		Task t1=new Task();
		new Thread(t1).start();
	}
}
