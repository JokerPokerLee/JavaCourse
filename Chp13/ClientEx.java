import java.io.*;
import java.net.*;
public class ClientEx{
	public static final int SERVERPORT=6666;
	public static void main(String args[]){
		try{
			Socket s=new Socket("localhost",SERVERPORT);
			System.out.println("Socket:"+s);
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
			BufferedReader bin=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Input your message,input quit to exit...");
			while(true){
				out.println(bin.readLine());
				String str=in.readLine();
				if(str==null)break;
				System.out.println(str);
			}
			s.close();
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}