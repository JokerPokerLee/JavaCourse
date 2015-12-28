import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
public class ServerTalkEx extends Frame implements ActionListener{
	Label l=new Label("Server talking contents:");
	Panel p=new Panel();
	TextField tf=new TextField(12);
	TextArea ta=new TextArea();
	ServerSocket server;
	Socket client;
	InputStream in;
	OutputStream out;
	public ServerTalkEx(){
		super("Server talking window");
		setSize(280,270);
		p.add(l);
		p.add(tf);
		tf.addActionListener(this);
		add("North",p);
		add("Center",ta);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		show();
		try{
			server=new ServerSocket(4000);
			client=server.accept();
			ta.append("The name of client is:"+client.getInetAddress().getHostName()+"\n");
			in=client.getInputStream();
			out=client.getOutputStream();
		}catch(IOException e){
		}
		while(true){
			try{
				byte[] buf=new byte[256];
				in.read(buf);
				String str=new String(buf);
				ta.append("\nclient said:"+str);
			}catch(IOException e){
			}
		}
	}
	public void actionPerformed(ActionEvent e){
		try{
			String str=tf.getText();
			byte[] buf=str.getBytes();
			tf.setText(null);
			out.write(buf);
			ta.append("\nServer(local) said:"+str);
		}catch(IOException ioe){
		}
	}
	public static void main(String args[]){
		new ServerTalkEx();
	}
}