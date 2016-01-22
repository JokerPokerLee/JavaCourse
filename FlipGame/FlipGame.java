import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyWindow extends JFrame implements ActionListener {

	final int WIDE = 800, HIGH = 600;		    //full window size
	final int MARGIN = 50;				        //shortest length of margin of the lower board
    final int LENGTH = 50;                      //maximum length of grids side
    int UPPER;                                  //the length of upper components it is determined by the size of the label and the button

	Container con = getContentPane();

	JTextField rowCon, columnCon;
	JLabel rowLab, columnLab;
	JButton confirm;

	JButton[] grid;
    int sta[], n, m, tot = 0;
    //board info
    //the board is divided into n*m grid store in the array grid as JButton component
    //tot = n * m whether board exists can be known from tot value (zero or not)

	MyWindow(String s) {

		super(s);

        int len = 50, tal = 20, sep = 20, bias = 21;
        //the width of lab is len, the width of button is len * 2
        int L = (WIDE - len * 8 - sep * 4) / 2;
        UPPER = sep + tal;

		rowLab = new JLabel("Row");
        rowLab.setBounds(L + bias, sep, len, tal);

		rowCon = new JTextField(10);
        rowCon.setBounds(L + len + sep, sep, len * 2, tal);

		columnLab = new JLabel("Col");
        columnLab.setBounds(L + len * 3 + sep * 2 + bias + 4, sep, len, tal);

		columnCon = new JTextField(10);
        columnCon.setBounds(L + len * 4 + sep * 3, sep, len * 2, tal);

		confirm = new JButton("Confirm");
        confirm.setBounds(L + len * 6 + sep * 4, sep, len * 2, tal);

		confirm.addActionListener(this);


		con.setLayout(null);
		con.setBackground(Color.pink);
		con.add(rowLab);
		con.add(rowCon);
		con.add(columnLab);
		con.add(columnCon);
		con.add(confirm);

        setSize(WIDE, HIGH);
        setResizable(false);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void Paint() {

        if (tot > 0) {
            for (int i = 0; i < tot; i++)
                con.remove(grid[i]);
            revalidate();
            repaint();
            tot = 0;
        }

		int len = LENGTH;
		if ((WIDE - 2 * MARGIN) / m < len)
			len = (WIDE - 2 * MARGIN) / m;
		if ((HIGH - 2 * MARGIN - UPPER) / n < len)
			len = (HIGH - 2 * MARGIN) / n;

		int ox, oy;
		ox = (WIDE - m * len) / 2;
		oy = (HIGH - n * len - UPPER) / 2 + UPPER;

		tot = n * m;
        grid = new JButton[tot];
		for (int i = 0; i < tot; i++) {
			int x = i % m;
			int y = i / m;
            grid[i] = new JButton("");
			grid[i].setBounds(ox + len * x, oy + len * y, len, len);
            grid[i].addActionListener(this);
			con.add(grid[i]);
		}

        setVisible(true);
		validate();

        sta = new int[tot];
        for (int i = 0; i < tot; i++) {
            sta[i] = Math.random() > 0.5 ? 1 : 0;
            grid[i].setBackground(sta[i] == 1 ? Color.white : Color.black);
        }
	}

    private void flip(int k) {
        sta[k] ^= 1;
        grid[k].setBackground(sta[k] == 1 ? Color.white : Color.black);
    }

    private boolean check() {
        int cnt = 0, tot = n * m;
        for (int i = 0; i < tot; i++)
            cnt += sta[i];
        return cnt == 0 || cnt == tot;
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm) {
            n = Integer.parseInt(rowCon.getText());
            m = Integer.parseInt(columnCon.getText());
			Paint();
            return;
		}
        int k = 0;
        while (e.getSource() != grid[k])
            k++;
        int x = k / m;
        int y = k % m;
        flip(k);
        if (y > 0)
            flip(k - 1);
        if (y < m - 1)
            flip(k + 1);
        if (x > 0)
            flip(k - m);
        if (x < n - 1)
            flip(k + m);
        if (check())
            JOptionPane.showMessageDialog(this, "You Win!");
	}
}

public class FlipGame{
	public static void main(String args[]){
		MyWindow game = new MyWindow("FlipGame");
	}
}
