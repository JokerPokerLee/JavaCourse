//带标号的break例程
//从二维数组中寻找是否存在数12，并将12第一次出现的位置打印出来
public class Example3_13 {
	public static void main(String[] args) {
		int[][] arrayOfInts = {{32,87,3,589},{12,1076,2000,8},{622,127,77,955}};
		int searchfor = 12;
		int i;
		int j = 0;
		boolean foundIt = false;
		search:
			for (i = 0; i < arrayOfInts.length; i++) {
				for (j = 0; j < arrayOfInts[i].length; j++) {
					if (arrayOfInts[i][j] == searchfor) {
						foundIt = true;
						break search;  //此处不再是跳出最内层循环，而是跳出search标记的语句块
					}
				}
			}
		if (foundIt) {
			System.out.println("Found " + searchfor + " at " + i + ", " + j);
		}
		else {
			System.out.println(searchfor + " not in the array");
		}
	}
}