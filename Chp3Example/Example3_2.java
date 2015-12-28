import java.util.*;
public class Example3_2{
	public static void main(String args[]){
		int number=new Random().nextInt();
		if(number%2==0)
			System.out.println(number+"is even.");
		else
			System.out.println(number+"is odd.");
	}
}