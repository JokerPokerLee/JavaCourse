import java.io.*;
import java.net.*;
public class ServerEx{
	public static final int SERVERPORT = 6666;
	public static void main(String args[]){
		try{
			ServerSocket ss=new ServerSocket(SERVERPORT);
			System.out.println("System start:"+ss);
			Socket incoming=ss.accept();
			System.out.println("System connecting and accepted:"+incoming);
			BufferedReader in=new BufferedReader(new InputStreamReader(incoming.getInputStream()));
			PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(incoming.getOutputStream())),true);
			System.out.println("Input quit to exit...");
			while(true){
				String line=in.readLine();
				if(line==null) break;
				else if(line.trim().equals("quit")){
					System.out.println("Client has inputted quit");
					System.out.println("System closing...");
					break;
				}
				System.out.println("The message from client:"+line);
				out.println("you said:"+line);
			}
			incoming.close();			
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}