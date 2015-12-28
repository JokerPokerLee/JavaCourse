public class  YieldTest extends Thread{
	public YieldTest(String name){
		super(name);
	}
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println(getName()+","+i);
			if(i==20){
				Thread.yield();
			}
		}
	}
	public static void main(String[] args) throws Exception{
		YieldTest yt1=new YieldTest("�߼�");
		YieldTest yt2=new YieldTest("�ͼ�");
		//yt2.setPriority(MIN_PRIORITY);
		yt1.start();
		yt2.start();
	}
}
