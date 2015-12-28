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

	static void initDir(String ori) {
		path = ori;
		if (path.length() == 0 || !path.substring(path.length() - 1, path.length()).equals(File.separator))
			path += File.separator;
		root = new DefaultMutableTreeNode(path);
		directory = new JTree(root);
		dirPane = new JScrollPane(directory);
		dirCon = new JFrame("FileViewer");
		dirCon.getContentPane().add(dirPane, BorderLayout.NORTH);
	}

	static void buildDir(DefaultMutableTreeNode now, int depth) {
		if (depth > 10 || ++tot > 150000)
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
			path += name[i].substring(1) + File.separator;
			buildDir(nf, depth + 1);
			path = tmp;
			now.add(nf);
        }
	}

	private static JTextArea desText;
	private static JScrollPane desPane;

	static void initDes() {
		desText = new JTextArea("Info\n");
		desPane = new JScrollPane(desText);
		dirCon.getContentPane().add(desPane);
		dirCon.setVisible(true);
		dirCon.setResizable(false);
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
		private static void display(File f) {
			int ty = -1;
			if (f.isFile() == true)
				ty = 0;
			if (f.isDirectory() == true)
				ty = 1;
			desText.setText(null);
			desText.append("Information\n");
			desText.append("Name:\t" + f.getName() + '\n');
			desText.append("Path:\t" + f.getPath() + '\n');
			if (ty >= 0)
				desText.append("Type:\t" + (ty == 0 ? "file" : "directory") + '\n');
			else
				desText.append("Type:\t" + "other" + '\n');
			desText.append("Size(byte):\t" + f.length() + '\n');
			desText.append("Last modified:\t" + new Date(f.lastModified()) + '\n');
		}
		public void valueChanged(TreeSelectionEvent e){
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)directory.getLastSelectedPathComponent();
			String name = dfs(node);
			display(new File(dfs(node)));
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