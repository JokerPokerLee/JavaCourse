import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class ChatClient extends Applet implements Runnable,ActionListener{
	TextField tf=new TextField(30);
	TextArea ta=new TextArea();
	InputStream in;
	OutputStream out;
	public void init(){
		setSize(280,270);
		tf.addActionListener(this);
		add("North",tf);
		add("Center",ta);
		//ta.setEditable(false);
		try{
			Socket client=new Socket(InetAddress.getLocalHost(),4000);
			ta.append("The name of Server is:"+client.getInetAddress().getHostName()+"\n");
			in=client.getInputStream();
			out=client.getOutputStream();
		}catch(IOException e){
		}
		new Thread(this).start();
	}
	public void actionPerformed(ActionEvent e){
		try{
			String str=tf.getText();
			byte[] buf=str.getBytes();
			tf.setText(null);
			out.write(buf);
		}catch(IOException ioe){
		}
	}
	public void run(){
		try{
			while(true){
				byte[] buf=new byte[256];
				in.read(buf);
				String s=new String(buf);
				if(s!=null) ta.append("\n"+s);
			}
		}catch(Exception e){
			ta.append("The server is down...");
			tf.setVisible(false);
		}
	}
	public void stop(){
		try{
			String exit="leave...";
			byte[] buf=exit.getBytes();
			out.write(buf);
		}catch(IOException e){
		}
	}
}