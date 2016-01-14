import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyWindow extends JFrame implements ActionListener{

	JTextField rowCon, columnCon;
	JLabel rowLab, columnLab;
	JButton confirm;
	int n, m;

	MyWindow(String s){

		super(s);
		rowLab = new JLabel("Row");
		rowCon = new JTextField(10);
		columnLab = new JLabel("Column");
		columnCon = new JTextField(10);
		confirm = new JButton("Confirm");

		confirm.addActionListener(this);

		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(rowLab);
		con.add(rowCon);
		con.add(columnLab);
		con.add(columnCon);
		con.add(confirm);
		con.setBounds(100, 100, 200, 150);
		con.setBackground(Color.pink);
        con.setPreferredSize(new Dimension(900,600));
        pack();
        setResizable(true);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm) {
			n = Integer.parseInt(rowCon.getText());
			m = Integer.parseInt(columnCon.getText());
			JOptionPane.showMessageDialog(null, "get RC: " + n + ", " + m, "InfoBox: stage 1", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
public class FlipGame{
	public static void main(String args[]){
		MyWindow game = new MyWindow("FlipGame");
	}
}