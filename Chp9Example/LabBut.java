import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LabBut extends JFrame{
	private JLabel lab1,lab2;
	private JButton but1,but2;
	public LabBut(){
		super("Label and Button");
		Container c = getContentPane();
		c.setLayout(new FlowLayout(100,100,10));
		Icon icon = new ImageIcon("1.jpg");
		Icon icon1=new ImageIcon("2.jpg");
		Icon icon2=new ImageIcon("3.jpg");
		lab1 = new JLabel("Label with text and image",icon,SwingConstants.CENTER);
		lab1.setToolTipText("This is a label");
		lab1.setHorizontalTextPosition(SwingConstants.CENTER);
		lab1.setVerticalTextPosition(SwingConstants.BOTTOM);
		c.add(lab1);
		but1 = new JButton("Button1 with function");
		c.add(but1);
		but2 = new JButton("Button2 with function",icon2);
		but2.setRolloverIcon(icon1);
		c.add(but2);
		but1.addActionListener(new listener());
		but2.addActionListener(new listener());
		setSize(360,200);
		show();
	}
	public static void main(String args[]){
		LabBut lb = new LabBut();
		lb.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	private class listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,"You pressed:"+e.getActionCommand());
		}
	}
}