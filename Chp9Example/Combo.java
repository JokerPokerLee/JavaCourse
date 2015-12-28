import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Combo extends JFrame{
	private JComboBox images;
	private JLabel label;
	private String names[]={"1.jpg","2.jpg","3.jpg"};
	private Icon icons[]={new ImageIcon(names[0]),new ImageIcon(names[1]),new ImageIcon(names[2])};
	public Combo(){
		super("JComboBox Example");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		images=new JComboBox(names);
		images.setMaximumRowCount(2);
		images.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				label.setIcon(icons[images.getSelectedIndex()]);
			}
		});
		c.add(images);
		label=new JLabel(icons[0]);
		c.add(label);
		setSize(450,200);
		show();
	}
	public static void main(String args[]){
		Combo cb=new Combo();
		cb.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}