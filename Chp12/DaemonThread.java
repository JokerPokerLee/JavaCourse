public class DaemonThread extends Thread{
	public DaemonThread(String s){
		super(s);
	}
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+","+i);
		}
	}
	public static void main(String[] args) {
		DaemonThread dt=new DaemonThread("ÊØ»¤Ïß³Ì");
		dt.setDaemon(true);
		dt.start();
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+","+i);
		}
	}
}
