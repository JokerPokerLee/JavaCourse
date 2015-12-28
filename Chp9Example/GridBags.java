import java.awt.*;
import javax.swing.*;
public class GridBags extends JFrame{
	public static void main(String args[]){
		Frame f = new Frame("GridBagLayout");
		GridBagLayout g1 = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		f.setLayout(g1);
		Button but1 = new Button("Data input");
		Button but2 = new Button("Data modified");
		Button but3 = new Button("Data query");
		Button but4 = new Button("Data print");
		Button but5 = new Button("Data delete");
		con.weightx = 1.2;
		g1.setConstraints(but1,con);		
		g1.setConstraints(but2,con);
		g1.setConstraints(but3,con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		g1.setConstraints(but4,con);
		g1.setConstraints(but5,con);
		f.add(but1);f.add(but2);f.add(but3);f.add(but4);f.add(but5);
		f.setSize(250,100);
		f.setBackground(Color.cyan);
		f.setVisible(true);
	}
}