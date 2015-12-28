import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JPanelEx extends JFrame{
	public JPanelEx(){
		super("JPanel Example");
		final int SIZE=3;
		Container c=getContentPane();
		c.setLayout(new BorderLayout(30,30));
		JPanel jp1=new JPanel();
		jp1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Button Group 0"));
		jp1.setLayout(new FlowLayout());
		for(int i=0;i<SIZE;i++) jp1.add(new JButton("boxes[0]:"+i));
		JPanel jp2=new JPanel();
		jp2.setLayout(new GridLayout(3,1));
		for(int i=0;i<SIZE;i++) jp2.add(new JButton("boxes[1]:"+i));
		JPanel jp3=new JPanel();
		jp3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Button Group 2"));
		jp3.setLayout(new FlowLayout());
		for(int i=0;i<SIZE;i++) jp3.add(new JButton("boxes[2]:"+i));
		c.add(jp1,BorderLayout.NORTH);
		c.add(jp2,BorderLayout.CENTER);
		c.add(jp3,BorderLayout.SOUTH);
		setSize(350,300);
		show();
	}
	public static void main(String args[]){
		JPanelEx jp=new JPanelEx();
		jp.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}