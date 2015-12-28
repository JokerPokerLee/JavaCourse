//不带标号的continue例程
//在字符串searchMe中统计字母p的个数
public class Example3_14 {
	public static void main(String[] args) {
		String searchMe = "peter piper picked a peck of pickled peppers";
		int max = searchMe.length();
		int numPs = 0;
		for (int i = 0; i < max; i++) {
			if (searchMe.charAt(i) != 'p')
				continue;	//如果字母不为p，则跳过本次循环的其余部分，进行下一次循环
			numPs++;
		}
		System.out.println("Found " + numPs + " p's in the string.");
	}
}