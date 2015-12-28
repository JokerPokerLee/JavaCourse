import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JDialogEx extends JFrame{
	JLabel l1=new JLabel("please click yes or no button");
	JLabel l2=new JLabel(" ");
	JButton b1=new JButton("display JDialog");
	JButton b2=new JButton("yes");
	JButton b3=new JButton("no");
	private JDialog jd=new JDialog();
	private JFrame jf;
	public JDialogEx(){
		super("JDialog Example");
		jf=new JFrame("JDialog");
		Container c=getContentPane();
		c.setBackground(Color.orange);
		c.setLayout(new GridLayout(2,1,20,20));
		c.add(b1);c.add(l2);
		Container d1=jd.getContentPane();
		d1.setLayout(new FlowLayout());
		d1.add(l1);d1.add(b2);d1.add(b3);
		b1.addActionListener(new handle());
		b2.addActionListener(new handle());
		b3.addActionListener(new handle());
		setSize(200,150);
		setVisible(true);
	}
	public class handle implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==b1){
				jd.setBounds(150,150,200,150);
				jd.show();
			}
			else if(e.getSource()==b2){
				jd.hide();
				l2.setText("You have selected yes button");
			}
			else{
				jd.hide();
				l2.setText("You have selected no button");
			}
		}
	}
	public static void main(String args[]){
		JDialogEx jde = new JDialogEx();
	}
}