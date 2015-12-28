import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class AppEx4 extends Applet implements MouseListener{
	int x,y;
	boolean clicked=false;
	public void init(){
		this.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e){
		clicked=true;
		x=e.getX();
		y=e.getY();
		repaint();
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void paint(Graphics g) {
    	if(clicked){
    		g.setColor(Color.pink);
    		g.fillOval(x-30,y-30,60,60);
    		g.setColor(Color.yellow);
    		g.fillOval(x-15,y-15,30,30);
    	}
    }
}