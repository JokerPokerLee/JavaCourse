import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CardsExam extends JFrame{
	private JButton but1,but2,but3;
	private Icon icon1,icon2,icon3;
	private CardLayout layout;
	private Container c;
	public CardsExam(){
		super("CardLayout");
		layout = new CardLayout(10,10);
		c = getContentPane();
		icon1 = new ImageIcon("1.jpg");
		icon2 = new ImageIcon("2.jpg");
		icon3 = new ImageIcon("3.jpg");
		but1 = new JButton("Button1",icon1);c.add(but1);
		but1.addActionListener(new listener());
		but2 = new JButton("Button2",icon2);c.add(but2);
		but2.addActionListener(new listener());
		but3 = new JButton("Button3",icon3);c.add(but3);
		but3.addActionListener(new listener());
		c.setLayout(layout);
		setSize(300,150);
		show();
	}
	private class listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==but1||e.getSource()==but2||e.getSource()==but3)
				layout.next(c);
		}
	}
	public static void main(String args[]){
		CardsExam cc = new CardsExam();
	}
}