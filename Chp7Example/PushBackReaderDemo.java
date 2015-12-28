//字符回退流
import java.io.*;
public class PushBackReaderDemo{
	public static void main(String args[]) throws IOException{
		String s="if(a==4)a=0;\n";
		char buff[]=new char[s.length()];
		s.getChars(0,s.length(),buff,0);
		CharArrayReader in=new CharArrayReader(buff);
		PushbackReader f=new PushbackReader(in);
		int c;
		while((c=f.read())!=-1){
			switch(c){
				case '=':
					if((c=f.read())=='=')
						System.out.print("等于");
					else{
						System.out.print("赋值为");
						f.unread(c);
					}
					break;
				default:
					System.out.print((char)c);
					break;
			}
		}
	}
}