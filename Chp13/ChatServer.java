import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ChatServer{
	public static void main(String args[]){
		ServerSocket server;
		Vector chatters=new Vector();
		System.out.println("listening...");
		try{
			server=new ServerSocket(4000);
			int cid=0;
			while(true){
				Socket client=server.accept();
				System.out.println("accepted");
				ServerThread st=new ServerThread(client,chatters);
				st.setID(cid++);
				chatters.addElement(st);
				new Thread(st).start();
				for(int i=0;i<chatters.size();i++){
					ServerThread stTemp=(ServerThread)chatters.elementAt(i);
					stTemp.write("<#>Welcome "+st.getID()+" to enter chatroom!");
				}
			}
		}catch(IOException e){
		}
	}
}
class ServerThread implements Runnable{
	Vector chatters;
	Socket subClient;
	InputStream in;
	OutputStream out;
	int id;
	public ServerThread(Socket client, Vector chatThreads){
		subClient=client;
		chatters=chatThreads;
		try{
			in=client.getInputStream();
			out=client.getOutputStream();
		}catch(IOException e){
		}
	}
	public void run(){
		System.out.println("Thread is running");
		try{
			while(true){
				byte[] buf=new byte[256];
				in.read(buf);
				String s=new String(buf);
				if(s==null) break;
				if(s.trim().equals("quit"))
					for(int i=0;i<chatters.size();i++){
						ServerThread stTemp=(ServerThread)chatters.elementAt(i);
						stTemp.write("***"+getID()+" leave..."+"***");
					}
				else
					for(int i=0;i<chatters.size();i++){
						ServerThread stTemp=(ServerThread)chatters.elementAt(i);
						stTemp.write("<"+getID()+">"+s);
					}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		chatters.removeElement(this);
		try{
			subClient.close();
		}catch(Exception e){
		}
	}
	public void write(String msg){
		synchronized(out){
			try{
				byte[] buf=new byte[256];
				buf=msg.getBytes();
				out.write(buf);
				System.out.println(msg);
			}catch(IOException e){
			}
		}
	}
	public int getID(){
		return id;
	}
	public void setID(int cid){
		id=cid;
	}
}