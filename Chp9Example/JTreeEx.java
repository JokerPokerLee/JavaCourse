import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
class JTreeWin extends JFrame implements TreeSelectionListener{
	JTree tree;
	public JTreeWin(String s){
		super(s);
		this.setBackground(Color.pink);
		Container c=getContentPane();
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("java programming");
			DefaultMutableTreeNode n1=new DefaultMutableTreeNode("swing");
				DefaultMutableTreeNode n11=new DefaultMutableTreeNode("Tree");
				DefaultMutableTreeNode n12=new DefaultMutableTreeNode("Button");
			DefaultMutableTreeNode n2=new DefaultMutableTreeNode("computer network");
				DefaultMutableTreeNode n21=new DefaultMutableTreeNode("internet technology");
					DefaultMutableTreeNode n211=new DefaultMutableTreeNode("web technology");
						DefaultMutableTreeNode n2111=new DefaultMutableTreeNode("HTML");
						DefaultMutableTreeNode n2112=new DefaultMutableTreeNode("HTTP");
				DefaultMutableTreeNode n22=new DefaultMutableTreeNode("wireless network");
				DefaultMutableTreeNode n23=new DefaultMutableTreeNode("grid technology");
			DefaultMutableTreeNode n3=new DefaultMutableTreeNode("database");
			DefaultMutableTreeNode n4=new DefaultMutableTreeNode("jsp");
			DefaultMutableTreeNode n5=new DefaultMutableTreeNode("servlet");
			DefaultMutableTreeNode n6=new DefaultMutableTreeNode("thread");
		root.add(n1);root.add(n2);root.add(n3);root.add(n4);root.add(n5);root.add(n6);
		n1.add(n11);n1.add(n12);
		n2.add(n21);n2.add(n22);n2.add(n23);
		n21.add(n211);
		n211.add(n2111);n211.add(n2112);
		tree=new JTree(root);
		tree.addTreeSelectionListener(this);
		JScrollPane sp=new JScrollPane(tree);
		c.add(sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(80,80,300,300);
		c.validate();
		validate();		
	}
	public void valueChanged(TreeSelectionEvent e){
		DefaultMutableTreeNode node=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(node.isLeaf()) this.setTitle((node.getUserObject()).toString());
	}
}
public class JTreeEx{
	public static void main(String args[]){
		JTreeWin win=new JTreeWin("JTree Example");
	}
}