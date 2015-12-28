//带标号的continue例程
//在字符串searchMe中寻找是否存在字串substring
public class Example3_15{
	public static void main(String[] args) {
		String searchMe = "Look for a substring in me";
		String substring = "sub";
		boolean foundIt = false;
		int max = searchMe.length() - substring.length();
	test:
		for (int i = 0; i <= max; i++) {
			int n = substring.length();
			int j = i;
			int k = 0;
			while (n-- != 0) {
				if (searchMe.charAt(j++) != substring.charAt(k++)) {
					continue test;	//在字串比较过程中，当发现第一个不相同的字母，就没有必要再向下比较，
									//跳至母串的下一个字母重新开始循环
				}
			}
			foundIt = true;
			break test;	//因为只是检验是否存在字串，所以一经发现，就不再向下比较，跳出test语句块。
		}
		System.out.println(foundIt ? "Found it" : "Didn't find it");
	}
}