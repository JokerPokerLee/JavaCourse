import java.awt.*;
import javax.swing.*;
public class Flows extends JFrame{
	private JButton but1,but2,but3;
	public Flows(){
		super("FlowLayout");
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		Container c = getContentPane();
		c.setLayout(layout);
		layout.setHgap(8);
		but1= new JButton("left");
		but2= new JButton("center");
		but3= new JButton("right");
		c.add(but1); c.add(but2); c.add(but3);
		setSize(300,100);
		show();
	}
	public static void main(String args[]){
		Flows app = new Flows();
	}
}