import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RunJRadio extends JFrame{
	JPanel jp;
	JRadioButton jrb1 = new JRadioButton("Male",true);
	JRadioButton jrb2 = new JRadioButton("Female");
	JRadioButton jrb3 = new JRadioButton("student");
	ButtonGroup bg = new ButtonGroup();
	public RunJRadio(){
		super("JRadioButton");
		setSize(350,100);
		jp = new JPanel();
		bg.add(jrb1);bg.add(jrb2);
		jp.add(jrb1);jp.add(jrb2);jp.add(jrb3);
		this.setContentPane(jp);		
	}
	public static void main(String args[]){
		RunJRadio r = new RunJRadio();
		r.show();
		r.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}