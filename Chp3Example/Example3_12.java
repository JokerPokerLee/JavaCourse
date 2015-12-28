//无标号的break例程
//寻找数组arrayOfInts中是否有12，并给出12第一次出现的位置。
public class Example3_12 {    
    public static void main(String[] args){
    	int[] arrayOfInts = { 32, 87, 3, 589, 12, 1076,2000, 8, 622, 127 };
    	int searchfor = 12;
    	int i;
    	boolean foundIt = false;
    	for (i = 0; i < arrayOfInts.length; i++) {
    		if (arrayOfInts[i] == searchfor) {
    			foundIt = true;
    			break;  //跳出最内层循环
    					//因只有一层循环，因此将跳出循环体，从if语句开始执行
    		}
    	}
		if (foundIt){
			System.out.println("Found " + searchfor + " at index " + i);
		}else{
			System.out.println(searchfor + " not in the array");
		}
	}
}