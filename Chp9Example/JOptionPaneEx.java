import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JOptionPaneEx extends JFrame{
	private JButton b1,b2,b3,b4;
	public JOptionPaneEx(){
		super("JOptionPane Example");
		Container c=getContentPane();
		c.setLayout(new GridLayout(2,2,20,20));
		b1=new JButton("b1(Message)");c.add(b1);b1.addActionListener(new handle());
		b2=new JButton("b2(Question)");c.add(b2);b2.addActionListener(new handle());
		b3=new JButton("b3(Input)");c.add(b3);b3.addActionListener(new handle());
		b4=new JButton("b4(Confirm)");c.add(b4);b4.addActionListener(new handle());
		setSize(300,200);
		show();		
	}
	public class handle implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String title="Dialog";
			String content="Display the content of dialog";
			int dialogType=JOptionPane.PLAIN_MESSAGE;
			if(e.getSource()==b1){
				title="Message";
				dialogType=JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog(null,content,title,dialogType);
			}
			else if(e.getSource()==b2){
				title="Question";
				dialogType=JOptionPane.QUESTION_MESSAGE;
				JOptionPane.showMessageDialog(null,content,title,dialogType);
			}
			else if(e.getSource()==b3){
				title="Input";
				dialogType=JOptionPane.QUESTION_MESSAGE;
				JOptionPane.showInputDialog(null,content,title,dialogType);
			}
			else{
				title="Confirm";
				dialogType=JOptionPane.YES_NO_OPTION;
				JOptionPane.showConfirmDialog(null,content,title,dialogType);
			}
		}
	}
	public static void main(String args[]){
		JOptionPaneEx jp=new JOptionPaneEx();
	}
}