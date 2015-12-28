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
	int five=1,ten=0,twenty=0;
	public synchronized  void sellTicket(int receiveMoney){
		if(receiveMoney==5){
			five++;
			System.out.println(Thread.currentThread().getName()+"给我五元钱，售票一张，无找零");
		}
		else if(receiveMoney==10){
			while(five<1){
				try{
					System.out.println(Thread.currentThread().getName()+" 请您一旁等待");
					wait();
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
					wait();
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
		notifyAll();
	}
}
public class TicketEx{
	public static void main(String args[]){
		Cinema a = new Cinema();
		a.A.start();
		a.B.start();
		a.C.start();
	}
}