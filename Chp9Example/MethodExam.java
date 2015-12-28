import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class CompExam extends JFrame implements ItemListener{
	JComboBox list;
	JTextArea text;
	CompExam(String s){
		super(s);
		setSize(260,270);
		setLocation(120,120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		text = new JTextArea(12,12);
		list = new JComboBox();
		list.setBackground(Color.pink);
		text.setForeground(Color.blue);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontName[] = ge.getAvailableFontFamilyNames();
		for(int i=0;i<fontName.length;i++)	list.addItem(fontName[i]);
		Container c = getContentPane();
		c.add(list,BorderLayout.NORTH);
		c.add(text,BorderLayout.CENTER);
		list.addItemListener(this);
		setVisible(true);
		setBounds(100,120,300,200);
		validate();
	}
	public void itemStateChanged(ItemEvent e){
		String name = (String)list.getSelectedItem();
		Font f = new Font(name,Font.BOLD,24);
		text.setFont(f);
		text.setText("Font test example");
	}
}
public class MethodExam{
	public static void main(String args[]){
		CompExam con =new CompExam("Example");
	}
}