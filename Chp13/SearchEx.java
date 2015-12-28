import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.applet.Applet;
public class SearchEx extends Applet implements ActionListener{
	String webList[]={"http://search.ustc.edu.cn","http://grid.ustc.edu.cn"};
	String webName[]={"TooOOold","Grid"};
	Choice select;
	public void init(){
		select = new Choice();
		Button b=new Button("Click to search");
		for(int i=0;i<=1;i++)select.addItem(webName[i]);
		add(select);
		add(b);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("Click to search")){
			int no=select.getSelectedIndex();
			openWeb(no);
		}
	}
	void openWeb(int index){
		try{
			URL myurl=new URL(webList[index]);
			getAppletContext().showDocument(myurl);
		}catch(Exception e){			
		}
	}
}