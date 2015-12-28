import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Boxes extends JFrame{
	public Boxes(){
		super("BoxLayout");
		final int SIZE = 3;
		Container c = getContentPane();
		c.setLayout(new BorderLayout(30,30));
		Box boxes[ ] = new Box[4];
		boxes[0] = Box.createHorizontalBox();
		boxes[1] = Box.createVerticalBox();
		boxes[2] = Box.createHorizontalBox();
		boxes[3] = Box.createVerticalBox();
		for(int i=0;i<SIZE;i++) boxes[0].add(new JButton("class"+i));
		for(int i=0;i<SIZE;i++) boxes[1].add(new JButton("grade"+i));
		for(int i=0;i<SIZE;i++) boxes[2].add(new JButton("classroom"+i));
		for(int i=0;i<SIZE;i++) boxes[3].add(new JButton("restroom"+i));
		c.add(boxes[0],BorderLayout.NORTH);
		c.add(boxes[1],BorderLayout.WEST);
		c.add(boxes[2],BorderLayout.SOUTH);
		c.add(boxes[3],BorderLayout.EAST);
		setSize(350,300);
		show();
	}
	public static void main(String args[]){
		Boxes bb = new Boxes();
		bb.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}