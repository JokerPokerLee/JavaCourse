import java.util.concurrent.locks.*;
import java.util.concurrent.*;
import java.util.*;
class Producer extends Thread{
	private BlockingQueue<String> bq;
	public Producer(BlockingQueue<String> bq){
		this.bq=bq;
	}
	public void run(){
		String[] sArr=new String[]{"��Ʒ1","��Ʒ2","��Ʒ3"};
		for(int i=0;i<3;i++){
			//System.out.println(getName()+"������������!");
			try{
				Thread.sleep(200);
				bq.put(sArr[i%3]);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(getName()+"�������,���룺"+bq);
		}
	}
}
class Consumer extends Thread{
	private BlockingQueue<String> bq;
	public Consumer(BlockingQueue<String> bq){
		this.bq=bq;
	}
	public void run(){
		while(true){
//		String[] sArr=new String[]{"��Ʒ1","��Ʒ2","��Ʒ3"};
//		for(int i=0;i<9999;i++){
//			System.out.println(getName()+"��������ȡ��!");
			try{
				Thread.sleep(200);
				bq.take();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(getName()+"�л���ȡ�����"+bq);
		}
	}
}
public class BlockingQueueEx{
	public static void main(String[] args) {
		BlockingQueue<String> bq=new ArrayBlockingQueue<>(1);
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		new Consumer(bq).start();
	}
}