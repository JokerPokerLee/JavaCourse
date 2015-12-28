import java.util.concurrent.*;
import java.util.*;

public class CallableAndFuture implements Callable{  
//public class CallableAndFuture {  
	public Integer call() throws Exception{
		return new Random().nextInt(100);
	}
    public static void main(String[] args) { 
		CallableAndFuture callable=new CallableAndFuture();
		
		/*
        Callable callable = new Callable(){  
            public Integer call() throws Exception {  
                return new Random().nextInt(100);  
            }  
        };*/  
        FutureTask future = new FutureTask(callable);  
        new Thread(future).start();  
		
        try {  
            //Thread.sleep(5000);// 可能做一些事情  
            System.out.println(future.get());  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }  
    }  
}  