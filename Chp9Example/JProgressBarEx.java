import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class JProgressBarEx extends JFrame{
	private JProgressBar bar;
	private JButton but;
	private Container c;
	private JLabel label;
	public JProgressBarEx(){
		super("JProgressBar Example");
		c=getContentPane();
		c.setLayout(new FlowLayout());
		bar=new JProgressBar();
		but=new JButton("presentation");
		c.add(but);
		bar.setForeground(Color.blue);
		c.add(bar);
		label=new JLabel();
		c.add(label);
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(bar.getValue()!=bar.getMaximum()) bar.setValue(bar.getValue()+15);
				else bar.setValue(bar.getMinimum());
			}
		});
		bar.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				label.setText("min:"+bar.getMinimum()+";max:"+bar.getMaximum()+";now:"+bar.getValue());
			}
		});
		setSize(350,150);
		show();
	}
	public static void main(String args[]){
		JProgressBarEx jpb=new JProgressBarEx();
		jpb.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}