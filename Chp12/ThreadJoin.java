public class ThreadJoin{
	public static void main(String argsp[]){
		TJoin a = new TJoin();
		a.threadA.start();
		a.threadB.start();
	}
}
class TJoin implements Runnable{
	Thread threadA,threadB;
	String content[]={"����λ","Ԥ��","��"};
	public TJoin(){
		threadA=new Thread(this);
		threadB=new Thread(this);
		threadB.setName("����Ա");
	}
	public void run(){
		if(Thread.currentThread()==threadA){
			System.out.println("�ȴ�"+threadB.getName()+"����");
			try{threadB.join();}
			catch(InterruptedException e){return;}
			System.out.println("��ʼ��!");
		}
		else if(Thread.currentThread()==threadB){
			System.out.println(threadB.getName()+"����:");
			for(int i=0;i<content.length;i++){
				System.out.println(content[i]);
				try{threadB.sleep(1000);}
				catch(InterruptedException e){return;}
			}
		}
	}
}