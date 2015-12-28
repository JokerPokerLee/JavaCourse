public class ThreadJoin{
	public static void main(String argsp[]){
		TJoin a = new TJoin();
		a.threadA.start();
		a.threadB.start();
	}
}
class TJoin implements Runnable{
	Thread threadA,threadB;
	String content[]={"各就位","预备","跑"};
	public TJoin(){
		threadA=new Thread(this);
		threadB=new Thread(this);
		threadB.setName("发令员");
	}
	public void run(){
		if(Thread.currentThread()==threadA){
			System.out.println("等待"+threadB.getName()+"发令");
			try{threadB.join();}
			catch(InterruptedException e){return;}
			System.out.println("开始跑!");
		}
		else if(Thread.currentThread()==threadB){
			System.out.println(threadB.getName()+"发令:");
			for(int i=0;i<content.length;i++){
				System.out.println(content[i]);
				try{threadB.sleep(1000);}
				catch(InterruptedException e){return;}
			}
		}
	}
}