public class BankEx{
	public static void main(String args[]) throws InterruptedException{
		BankSave bs=new BankSave();
		Operator o1=new Operator(bs,"丈夫");
		Operator o2=new Operator(bs,"妻子");
		Thread t1=new Thread(o1);
		Thread t2=new Thread(o2);
		t1.start();
		t2.start();
		Thread.currentThread().sleep(500);
	}
}
class BankSave{
	private static int money=10000;
	public void add(int i){
		money=money+i;
		System.out.println("丈夫存入"+i+"元，余额"+money+"元");
	}
	public void get(int i){
		if(i<=money){
			money=money-i;
			System.out.println("妻子取走"+i+"元，余额"+money+"元");
		}
		else System.out.println("余额不足");
	}
	public int showMoney(){
		return money;
	}
}
class Operator implements Runnable{
	String name;
	BankSave bs;
	public Operator(BankSave bs,String name){
		this.bs=bs;
		this.name=name;
	}
	//synchronized
	public  static void oper(String name,BankSave bs){
		if(name.equals("丈夫")){
			try{
				for(int i=0;i<5;i++){
					Thread.sleep(5);
//					Thread.currentThread().sleep((int)(Math.random()*300));
					bs.add(1000);
				}
			}catch(InterruptedException e){
				return;
			}
		}
		else try{
			for(int i=0;i<5;i++){
					Thread.sleep(5);
//					Thread.currentThread().sleep((int)(Math.random()*300));
					bs.get(1000);
				}
			}catch(InterruptedException e){
				return;
			}
	}
	public void run(){
		oper(name,bs);
	}
}