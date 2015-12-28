import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MenuExam extends JFrame{
	private JLabel display;
	public MenuExam(){
		super("Menu");
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu fileMenu = new JMenu("File");
			JMenuItem fileNew = new JMenuItem("New");
			JMenuItem fileOpen = new JMenuItem("Open");
			JMenuItem fileSave = new JMenuItem("Save");
			JMenuItem fileExit = new JMenuItem("Exit");
		fileMenu.add(fileNew); fileMenu.add(fileOpen);
		fileMenu.add(fileSave); fileMenu.add(fileExit); 
		bar.add(fileMenu);
		fileExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		JMenu editMenu = new JMenu("Edit");
			JMenuItem copyMenu = new JMenuItem("Copy");	
			JMenuItem pasteMenu = new JMenuItem("Paste");	
			JMenuItem cutMenu = new JMenuItem("Cut");
			JMenuItem selectMenu = new JMenuItem("Select");
		editMenu.add(copyMenu); editMenu.add(pasteMenu); 
		editMenu.add(cutMenu); editMenu.addSeparator();
		editMenu.add(selectMenu); 
		bar.add(editMenu);
		JMenu formatMenu = new JMenu("Format");
			JMenuItem colorMenu = new JMenuItem("Color");
			JMenuItem fontMenu = new JMenuItem("Font");
		formatMenu.add(colorMenu); formatMenu.add(fontMenu);
		bar.add(formatMenu);
		setSize(300,200);
		show();
	}
	public static void main(String args[]){
		MenuExam mm = new MenuExam();
		mm.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}