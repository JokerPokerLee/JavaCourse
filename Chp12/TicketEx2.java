import java.util.concurrent.locks.*;
class Cinema implements Runnable{
	Thread A,B,C;
	TicketSeller seller;
	Cinema(){
		A=new Thread(this);B=new Thread(this);C=new Thread(this);
		A.setName("A");B.setName("B");C.setName("C");
		seller=new TicketSeller();
	}
	public void run(){
		if(Thread.currentThread()==A){seller.sellTicket(20);}
		else if(Thread.currentThread()==B){seller.sellTicket(10);}
		else if(Thread.currentThread()==C){seller.sellTicket(5);}
	}
}
class TicketSeller{
	private final Lock lock=new ReentrantLock();
	private final Condition cond=lock.newCondition();
	int five=1,ten=0,twenty=0;
	public  void sellTicket(int receiveMoney){
		lock.lock();
		try{
		if(receiveMoney==5){
			five++;
			System.out.println(Thread.currentThread().getName()+"给我五元钱，售票一张，无找零");
		}
		else if(receiveMoney==10){
			while(five<1){
				try{
					System.out.println(Thread.currentThread().getName()+" 请您一旁等待");
					cond.await();
					System.out.println(Thread.currentThread().getName()+"结束等待");
				}catch(InterruptedException e){
					return;
				}				
			}
			five--;
			ten++;
			System.out.println(Thread.currentThread().getName()+"给我十元钱，售票一张，找零五元");
		}
		else if(receiveMoney==20){
			while(five<1||ten<1){
				try{
					System.out.println(Thread.currentThread().getName()+" 请您一旁等待");
					cond.await();
					System.out.println(Thread.currentThread().getName()+"结束等待");
				}catch(InterruptedException e){
					return;
				}		
			}
			five--;
			ten--;
			twenty++;
			System.out.println(Thread.currentThread().getName()+"给我二十元钱，售票一张，找零十五元");
		}
		cond.signalAll();
		}finally{
			lock.unlock();
		}
	}
}
public class TicketEx2{
	public static void main(String args[]){
		Cinema a = new Cinema();
		a.A.start();
		a.B.start();
		a.C.start();
	}
}