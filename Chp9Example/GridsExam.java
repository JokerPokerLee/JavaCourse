import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GridsExam extends JFrame{
	private JButton b[ ];
	private String names[ ] = {"1-1","1-2","1-3","2-1","2-2","2-3"};
	private Container c;
	private GridLayout layout;
	public GridsExam(){
		super("GridLayout");
		layout = new GridLayout(2,3,14,16);
		c = getContentPane();
		c.setLayout(layout);
		c.setBackground(Color.pink);
		b = new JButton[names.length];
		for(int i=0;i<names.length;i++){
			b[i] = new JButton(names[i]);
			c.add(b[i]);
		}
		setSize(350,160);
		show();
	}
	public static void main(String args[]){
		GridsExam gg = new GridsExam();
		gg.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}