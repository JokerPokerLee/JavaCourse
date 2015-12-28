import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
public class ClientTalkEx extends Frame implements ActionListener{
	Label l=new Label("Client talking contents:");
	Panel p=new Panel();
	TextField tf=new TextField(12);
	TextArea ta=new TextArea();
	Socket client;
	InputStream in;
	OutputStream out;
	public ClientTalkEx(){
		super("Client talking window");
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
			client=new Socket(InetAddress.getLocalHost(),4000);
			ta.append("The name of Server is:"+client.getInetAddress().getHostName()+"\n");
			in=client.getInputStream();
			out=client.getOutputStream();
		}catch(IOException e){
		}
		while(true){
			try{
				byte[] buf=new byte[256];
				in.read(buf);
				String str=new String(buf);
				ta.append("\nServer said:"+str);
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
			ta.append("\nClient(local) said:"+str);
		}catch(IOException ioe){
		}
	}
	public static void main(String args[]){
		new ClientTalkEx();
	}
}