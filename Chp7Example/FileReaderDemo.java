//»º³åÁ÷
import java.io.*;
public class FileReaderDemo{
	public static void main(String args[])throws Exception{
		//FileReader fr=new FileReader("FileReaderDemo.java");
		//BufferedReader br=new BufferedReader(fr);
		BufferedReader br=new BufferedReader(new FileReader("FileReaderDemo.java"));
		String s;
		while((s=br.readLine())!=null){
			System.out.println(s);
		}
		br.close();
	}
}