import java.util.Date;
import java.net.*;
import java.io.*;
public class URLConnectionEx{
	public static void main(String args[]){
		String urlName="http://202.38.64.11/~renkx/AppEx1.html";
		if(args.length>0)urlName=args[0];
		new URLConnectionEx().display(urlName);
	}
	public void display(String urlName){
		try{
			URL url=new URL(urlName);
			URLConnection uc=url.openConnection();
			System.out.println(	"Date:"+new Date(uc.getDate())+
								"\r\nFile Type:"+uc.getContentType()+
								"\r\nUpdate:"+new Date(uc.getLastModified()));
			int c,len;
			len=uc.getContentLength();
			System.out.println("File Length:"+len);
			if(len>0){
				System.out.println("File Content:");
				InputStream in=uc.getInputStream();
				int i=len;
				while(((c=in.read())!=-1)&&(i>0)){
					System.out.print((char)c);
					i--;
				}
			}
		}catch(MalformedURLException e){System.out.println(e.toString());
		}catch(IOException e){System.out.println(e.toString());}
	}
}