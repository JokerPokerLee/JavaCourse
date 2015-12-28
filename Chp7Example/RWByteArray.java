//字节数组输入流与字节数组输出流
import java.io.*;
public class RWByteArray{
	public static void main(String args[])throws IOException{
		byte[] b1=new byte[]{'a','r','r','a','y','1'};
		byte[] b2=new byte[64];
		ByteArrayInputStream in=new ByteArrayInputStream(b1);
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		int c;
		while((c=in.read())!=-1){
			out.write(c);
		}
		b2=out.toByteArray();
		if(in!=null)in.close();
		if(out!=null)out.close();
		for(int i=0;i<b2.length;i++)
			System.out.print((char)b2[i]);		
	}
}