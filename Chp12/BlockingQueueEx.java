import java.util.concurrent.locks.*;
import java.util.concurrent.*;
import java.util.*;
class Producer extends Thread{
	private BlockingQueue<String> bq;
	public Producer(BlockingQueue<String> bq){
		this.bq=bq;
	}
	public void run(){
		String[] sArr=new String[]{"产品1","产品2","产品3"};
		for(int i=0;i<3;i++){
			//System.out.println(getName()+"生产者在生产!");
			try{
				Thread.sleep(200);
				bq.put(sArr[i%3]);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(getName()+"生产完成,放入："+bq);
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
//		String[] sArr=new String[]{"产品1","产品2","产品3"};
//		for(int i=0;i<9999;i++){
//			System.out.println(getName()+"消费者在取货!");
			try{
				Thread.sleep(200);
				bq.take();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(getName()+"有货，取货完成"+bq);
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