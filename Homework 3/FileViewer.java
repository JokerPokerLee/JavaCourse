import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class FileViewer {

	private static JFrame dirCon;
	private static JScrollPane dirPane;
	private static JTree directory;
	private static DefaultMutableTreeNode root;
	private static String path;

	// private static TextArea des;

	static void initDir(String ori) {
		if (ori.length() == 0)
			ori += File.separator;
		if (ori.substring(ori.length() - File.separator.length(), ori.length() - 1) == File.separator)
			ori = ori.substring(0, ori.length() - File.separator.length());
		path = ori;
		root = new DefaultMutableTreeNode(path);
		directory = new JTree(root);
		dirPane = new JScrollPane(directory);
		dirCon = new JFrame("FileViewer");
		dirCon.getContentPane().add(dirPane);
		dirCon.setVisible(true);
		dirCon.setBounds(80, 80, 400, 600);
		dirCon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	static void buildDir(DefaultMutableTreeNode now) {
		File dir = new File(path);
		// System.out.println(path);
		File[] list = dir.listFiles();
		if (list == null)
			return;
		int n = list.length;
		String[] name = new String[n];
		for (int i = 0; i < n; i++) {
			name[i] = list[i].isDirectory() ? "0" : "1";
			name[i] += list[i].getName();
		}
		Arrays.sort(name);
		// System.out.println(n);
		// for (int i = 0; i < n; i++) {
		// 	System.out.println("sorted---" + name[i].substring(1));
		// }
		// if (1 - 1 == 0)
		// 	return;
		for (int i = 0; i < n; i++) {
        	if (name[i].indexOf('.') == 1)
        		continue;
			DefaultMutableTreeNode nf = new DefaultMutableTreeNode(name[i].substring(1));
			String tmp = path;
			path += File.separator + name[i].substring(1);
        	// System.out.println(path);
			buildDir(nf);
			path = tmp;
			now.add(nf);
        }
	}

	// static void initDes() {
	// 	des = new TextArea("Info\n");
	// 	dirCon.getContentPane().add(des);
	// 	dirCon.setVisible(true);
	// }

	public static void main(String args[]) {
		if (args.length == 0)
			initDir((File.listRoots())[0].getName());
		else
			initDir(args[0]);
		buildDir(root);
		// initDes();
	}
}