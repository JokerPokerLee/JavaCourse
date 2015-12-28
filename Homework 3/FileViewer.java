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
	private static int tot = 0;

	// private static TextArea desText;
	// private static JPanel desPane;

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
		dirCon.getContentPane().add(dirPane, BorderLayout.NORTH);
	}

	static void buildDir(DefaultMutableTreeNode now, int depth) {
		if (depth > 10 || ++tot > 200000)
			return;

		File dir = new File(path);
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
		for (int i = 0; i < n; i++) {
        	if (name[i].indexOf('.') == 1)
        		continue;
			DefaultMutableTreeNode nf = new DefaultMutableTreeNode(name[i].substring(1));
			String tmp = path;
			path += File.separator + name[i].substring(1);
			buildDir(nf, depth + 1);
			path = tmp;
			now.add(nf);
        }
	}

	private static TextArea desText;
	private static JScrollPane desPane;

	static void initDes() {
		desText = new TextArea("Info\n");
		desPane = new JScrollPane(desText);
		dirCon.getContentPane().add(desPane, BorderLayout.SOUTH);
		dirCon.setVisible(true);
		dirCon.setBounds(80, 80, 400, 600);
		dirCon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static class listener implements TreeSelectionListener{
		private static String dfs(DefaultMutableTreeNode now) {
			String str = now.toString();
			if (now == root)
				return str.substring(0, str.length() - File.separator.length());
			return dfs((DefaultMutableTreeNode)now.getParent()) + File.separator + str;
		}
		public void valueChanged(TreeSelectionEvent e){
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)directory.getLastSelectedPathComponent();
			String name = dfs(node);
			System.out.println(name);
			// File f = new File(dfs(node));
		}
	}

	public static void main(String args[]) {
		if (args.length == 0)
			initDir((File.listRoots())[0].getName());
		else
			initDir(args[0]);
		buildDir(root, 0);
		directory.addTreeSelectionListener(new listener());
		initDes();
	}
}