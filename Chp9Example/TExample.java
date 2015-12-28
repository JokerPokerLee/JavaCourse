import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MyWindow extends JFrame implements ActionListener{
	JTextField titleText;
	JPasswordField passwordText;
	private JLabel lab1,lab2;
	MyWindow(String s){
		super(s);
		lab1 = new JLabel("name");
		titleText = new JTextField(10);
		lab2 = new JLabel("password");
		passwordText = new JPasswordField(10);
		passwordText.setEchoChar('*');
		titleText.addActionListener(this);
		passwordText.addActionListener(this);
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(lab1); con.add(titleText);
		con.add(lab2); con.add(passwordText);
		con.setBounds(100,100,200,150);
		con.setBackground(Color.pink);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==titleText) this.setTitle(titleText.getText());
		else if(e.getSource()==passwordText){
			char c[] = passwordText.getPassword();
			titleText.setText(new String(c));
		}
	}
}
public class TExample{
	public static void main(String args[]){
		MyWindow win = new MyWindow("TextField Example");
	}
}