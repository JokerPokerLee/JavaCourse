import java.util.concurrent.*;
public class SumTask implements Callable{
	int i,j;
	public SumTask(int i,int j){
		this.i=i;
		this.j=j;
	}
	public Integer call() throws Exception{
		int sum=0;
		for(int count=i;count<=j;count++){
			sum+=count;
		}
		return sum;
	}
	public static void main(String[] args) throws Exception{
		int sum=0;
		for(int i=0;i<10;i++){
			SumTask st=new SumTask(i*10+1,(i+1)*10);
			FutureTask ft=new FutureTask(st);
			Thread t=new Thread(ft);
			t.start();
			t.join();
			sum+=((Integer)ft.get()).intValue();
		}
		System.out.println(sum);
	}
}