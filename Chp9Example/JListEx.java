import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class JListEx extends JFrame{
	private JList images;
	private JLabel label;
	private String names[]={"1.jpg","2.jpg","3.jpg"};
	private Icon icons[]={new ImageIcon(names[0]),new ImageIcon(names[1]),new ImageIcon(names[2])};
	public JListEx(){
		super("JList Example");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		images=new JList(names);
		images.setVisibleRowCount(2);
		images.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.add(new JScrollPane(images));
		label=new JLabel(icons[0]);
		c.add(label);
		images.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				label.setIcon(icons[images.getSelectedIndex()]);
			}
		});		
		setSize(200,200);
		show();
	}
	public static void main(String args[]){
		JListEx jl=new JListEx();
		jl.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}