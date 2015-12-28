import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class AppEx5 extends Applet{
	Image img;
	public void init(){
		img = getImage(getCodeBase(),"1.jpg");
	}
	public void paint(Graphics g){
		g.drawImage(img,20,20,this);
    }
}