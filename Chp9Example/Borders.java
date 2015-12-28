import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Borders extends JFrame implements ActionListener{
	private JButton b[ ];
	private String names[ ] = {"NORTH","SOUTH","WEST","EAST","CENTER"};
	private BorderLayout layout;
	public Borders(){
		super("BorderLayout");
		layout = new BorderLayout(5,5);
		Container c = getContentPane();
		c.setLayout(layout);
		b = new JButton[names.length];
		for(int i=0;i<names.length;i++){
			b[i] = new JButton(names[i]);
			b[i].addActionListener(this);
		}
		c.add(b[0],BorderLayout.NORTH);
		c.add(b[1],BorderLayout.SOUTH);
		c.add(b[2],BorderLayout.WEST);
		c.add(b[3],BorderLayout.EAST);
		c.add(b[4],BorderLayout.CENTER);
		setSize(400,300);
		show();
	}
	public void actionPerformed(ActionEvent e){
		for(int i=0;i<b.length;i++){
			if(e.getSource()==b[i])
				b[i].setVisible(false);
			else
				b[i].setVisible(true);
		}
		layout.layoutContainer(getContentPane());
	}
	public static void main(String args[]){
		Borders bb = new Borders();
		bb.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}