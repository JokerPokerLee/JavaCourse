import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

public class CopyFileJ extends JFrame{
	private JProgressBar jpb=new JProgressBar();
	private JButton jbtCopy = new JButton("Copy");
	//private JFileChooser jfc1=new JFileChooser();
	//private JFileChooser jfc2=new JFileChooser();
	private JTextField jfc1=new JTextField();
	private JTextField jfc2=new JTextField();
	int result;
	
	public CopyFileJ(){
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp2.setLayout(new BorderLayout());
		jp2.setBorder(new TitledBorder("源文件"));
		
		//jfc1.setDialogType(JFileChooser.OPEN_DIALOG);
		//jfc1.showDialog(null,"确定");
		//result=jfc1.showOpenDialog(this);
		
	
		
		jp2.add(jfc1,BorderLayout.CENTER);
		JPanel jp3=new JPanel();
		jp3.setLayout(new BorderLayout());
		jp3.setBorder(new TitledBorder("目的文件"));
		jp3.add(jfc2,BorderLayout.CENTER);
		
		jp1.setLayout(new GridLayout(2,1));
		jp1.add(jp2);
		jp1.add(jp3);
		
		JPanel jp4=new JPanel();
		jp4.add(jbtCopy);
		
		this.add(jpb,BorderLayout.NORTH);
		this.add(jp1,BorderLayout.CENTER);
		this.add(jp4,BorderLayout.SOUTH);
		
		jpb.setStringPainted(true);
		
		jbtCopy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Thread(new CopyFileTask()).start();
			}
		});
	}
	
	public static void main(String args[]){
		CopyFileJ jcf=new CopyFileJ();
		jcf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jcf.setTitle("copy file");
		jcf.setSize(400,180);
		jcf.setVisible(true);
	}	
	
	class CopyFileTask implements Runnable{
		private int currentValue;
		public void run(){
			BufferedInputStream in=null;
			BufferedOutputStream out=null;
			//File inf;
			try{
				
				//if(result==jfc1.APPROVE_OPTION){
				//	inf=jfc1.getSelectedFile();
				//}
				File inf=new File(jfc1.getText());
				File outf=new File(jfc2.getText());
				in =new BufferedInputStream(new FileInputStream(inf));				
				out =new BufferedOutputStream(new FileOutputStream(outf));
				
				long totalBytes=in.available();
				jpb.setValue(0);
				jpb.setMaximum(100);
				int r;
				long bytesRead=0;
				byte[] b=new byte[10];
				while((r=in.read(b,0,b.length))!=-1){
					out.write(b,0,r);
					bytesRead+=r;
					currentValue=(int)(bytesRead*100/totalBytes);
					jpb.setValue(currentValue);
				}
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
					if(in!=null) in.close();
					if(out!=null) out.close();
				}catch(Exception e){
					
				}
			}
		}
	}
}