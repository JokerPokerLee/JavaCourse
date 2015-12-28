import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JToolBarEx extends JFrame implements ActionListener{
	JButton b1,b2,b3;
	JToolBar jt;
	JTextArea ta;
	JScrollPane sp;
	JPanel p;
	public JToolBarEx(){
		super("JToolBar Example");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		b1=new JButton(new ImageIcon("1.jpg"));b1.addActionListener(this);
		b2=new JButton(new ImageIcon("2.jpg"));b2.addActionListener(this);
		b3=new JButton(new ImageIcon("3.jpg"));b3.addActionListener(this);
		jt=new JToolBar();
		jt.add(b1);jt.add(b2);jt.add(b3);
		ta=new JTextArea(6,30);
		sp=new JScrollPane(ta);
		p=new JPanel();
		setContentPane(p);
		p.setLayout(new BorderLayout());
		p.setPreferredSize(new Dimension(300,150));
		p.add(jt,BorderLayout.NORTH);
		p.add(sp,BorderLayout.CENTER);
		show();
	}
	public void actionPerformed(ActionEvent e){
		String s="";
		if(e.getSource()==b1) s="You have pressed button at left!Please Continue!\n";
		if(e.getSource()==b2) s="You have pressed button at center!Please Continue!\n";
		if(e.getSource()==b3) s="You have pressed button at right!Please Continue!\n";
		ta.append(s);
		ta.setBackground(Color.pink);
	}
	public static void main(String args[]){
		new JToolBarEx();
	}
}