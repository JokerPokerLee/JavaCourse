class MyThread extends Thread{
	String message;
	int count;
	MyThread(String message){
		this.message=message;
	}
	public void run(){
		for(int i=0;i<10;i++){
			count++;
			System.out.println(message+" "+count);
		}
	}
}
public class ThreadTest{
	public static void main(String args[]){
		MyThread t1=new MyThread("�����ȼ��߳�");
		t1.start();
		t1.setPriority(Thread.MIN_PRIORITY);		
		MyThread t2=new MyThread("�����ȼ��߳�");
		t2.start();
		t2.setPriority(Thread.NORM_PRIORITY);
		MyThread t3=new MyThread("�����ȼ��߳�");
		t3.start();
		t3.setPriority(Thread.MAX_PRIORITY);
		
	}
}