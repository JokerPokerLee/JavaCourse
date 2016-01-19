import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyWindow extends JFrame implements ActionListener {

	final int WIDE = 800, HIGH = 800;		//full window size
	final int MARGIN = 20;				//shortest length of margin
	final int LENGTH = 10;				//shortest length of grid
	final int ox = 10, oy = 10;
	final int len = 10;

	Container con = getContentPane();
	JButton grid[];

	JTextField rowCon, columnCon;
	JLabel rowLab, columnLab;
	JButton confirm;

    int sta[];
	int n, m;

	MyWindow(String s) {

		super(s);
		rowLab = new JLabel("Row");
		rowCon = new JTextField(10);
		columnLab = new JLabel("Column");
		columnCon = new JTextField(10);
		confirm = new JButton("Confirm");

		confirm.addActionListener(this);

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

	void Paint() {

		int len = LENGTH;
		if ((WIDE - 2 * MARGIN) / m < len)
			len = (WIDE - 2 * MARGIN) / m;
		if ((HIGH - 2 * MARGIN) / n < len)
			len = (HIGH - 2 * MARGIN) / n;

		int ox, oy;
		ox = (WIDE - m * len) / 2;
		oy = (HIGH - n * len) / 2;

		int tot = n * m;
		grid = new JButton[tot];
		for (int i = 0; i < tot; i++) {
			int x = i / m;
			int y = i % m;
			con.add(grid[i]);
			grid[i].setBound();
		}

        for (int i = 0; i < tot; i++) {
            sta[i] = Math.random() > 0.5 ? 1 : 0;
            grid[i].setBackground(sta[i] == 1 ? Color.White : Color.Black);
        }
	}

    private void flip(int k) {
        sta[k] ^= 1;
        grid[k].setBackground(sta[k] == 1 ? Color.White : Color.Black);
    }

    private boolean check() {
        int cnt = 0;
        for (int i = 0; i < tot; i++)
            cnt += sta[i];
        return cnt == 0 || cnt == n * m;
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm) {
            n = Interger.parseInt(row.getText());
            m = Interger.parseInt(column.getText());
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
        if (check()) {
            JOptionPane.showMessageDialog(frame, "You Win!");
        }
	}
}

public class FlipGame{
	public static void main(String args[]){
		MyWindow game = new MyWindow("FlipGame");
	}
}
