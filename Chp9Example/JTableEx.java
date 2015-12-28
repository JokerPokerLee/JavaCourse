import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class JTableWin extends JFrame implements ActionListener{
	JTable table;
	Object a[][];
	Object name[]={"Name","Num","Price","Sell"};
	JButton sumRows,sumColumns;
	JTextField inputRowsNumber;
	int initRows=1;
	JPanel pSouth,pNorth;
	int count=0,rowsNumber=0;
	JTableWin(String s){
		super(s);
		sumRows=new JButton("Good Sales");
		sumColumns=new JButton("Total Sales");
		inputRowsNumber=new JTextField(4);
		sumRows.addActionListener(this);
		sumColumns.addActionListener(this);
		inputRowsNumber.addActionListener(this);
		pSouth=new JPanel();
		pNorth=new JPanel();
		pNorth.add(new JLabel("Input row number,press Enter to confirm"));
		pNorth.add(inputRowsNumber);
		inputRowsNumber.setBackground(Color.pink);
		pSouth.add(sumRows);
		pSouth.add(sumColumns);
		getContentPane().add(pSouth,BorderLayout.SOUTH);
		getContentPane().add(pNorth,BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
		setSize(370,250);
		setVisible(true);
		getContentPane().validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==inputRowsNumber){
			count=0;
			initRows=Integer.parseInt(inputRowsNumber.getText());
			a=new Object[initRows][4];
			for(int i=0;i<initRows;i++){
				for(int j=0;j<4;j++){
					if(j>0) a[i][j]="0";
					else a[i][j]="";
				}
			}
			table=new JTable(a,name);
			table.setRowHeight(20);
			getContentPane().removeAll();
			getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
			getContentPane().add(pSouth,BorderLayout.SOUTH);
			getContentPane().add(pNorth,BorderLayout.NORTH);
			validate();		
		}
		else if(e.getSource()==sumRows){
			int rows=table.getRowCount();
			for(int i=0;i<rows;i++){
				double sum=1;
				boolean b=true;
				for(int j=1;j<=2;j++){
					try{
						sum=sum*Double.parseDouble(a[i][j].toString());
					}catch(Exception exception){
						b=false;
						table.repaint();
					}
					if(b==true){
						a[i][3]=""+sum;
						table.repaint();
					}
				}
			}
		}
		else if(e.getSource()==sumColumns){
			rowsNumber=table.getRowCount();
			if(count==0) count++;
			else rowsNumber=rowsNumber-1;
			double totalSum=0;
			for(int j=0;j<rowsNumber;j++) totalSum=totalSum+Double.parseDouble(a[j][3].toString());
			Object b[][]=new Object[rowsNumber+1][4];
			for(int i=0;i<rowsNumber;i++)
				for(int j=0;j<4;j++)
					b[i][j]=a[i][j];
			b[rowsNumber][0]="There are"+rowsNumber+"classes of goods";
			b[rowsNumber][3]="Total salse:"+totalSum;
			a=b;
			table=new JTable(a,name);
			getContentPane().removeAll();
			getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
			getContentPane().add(pSouth,BorderLayout.SOUTH);
			getContentPane().add(pNorth,BorderLayout.NORTH);
			validate();	
		}
	}
}
public class JTableEx{
	public static void main(String args[]){
		JTableWin jw=new JTableWin("Table of sales");
	}
}