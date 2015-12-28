import java.util.*;
public class PriorityTest extends Thread{
	int A[][],B[][],C[][];
	final int l=1000;
	public PriorityTest(String name){
		super(name);
	}
	/*
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println(getName()+","+getPriority()+","+i);
		}
	}
	*/
	public void run(){
		A=new int[l][l];
		B=new int[l][l];
		C=new int[l][l];
		for(int i=0;i<l;i++){
			for(int j=0;j<l;j++){
				A[i][j]=new Random().nextInt(10);
				B[i][j]=new Random().nextInt(10);
				C[i][j]=0;
			}
		}
		for(int i=0;i<l;i++){
			for(int j=0;j<l;j++){
				for(int k=0;k<l;k++){
					C[i][j]+=A[i][j]*B[j][k];
				}
			}
		}/*
		for(int i=0;i<l;i++){
			for(int j=0;j<l;j++){
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}*/
		System.out.println(getName());
	}

	public static void main(String[] args) {
		Thread.currentThread().setPriority(6);
		for(int i=0;i<30;i++){
			if(i==10){
				PriorityTest low=new PriorityTest("低优先级");
				low.start();
				System.out.println(low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if(i==20){
				PriorityTest high=new PriorityTest("高优先级");
				high.start();
				System.out.println(high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}
