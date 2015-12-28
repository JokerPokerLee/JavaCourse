import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class AppEx6 extends Applet implements MouseMotionListener,MouseListener{
	Image img;
	int x=70,y=60,posX=70,posY=60,dx,dy;
	public void init(){
		img=getImage(getCodeBase(),"2.jpg");
		addMouseListener(this); addMouseMotionListener(this);
	}
	public void mousePressed(MouseEvent e){dx=e.getX()-posX; dy=e.getY()-posY;}
	public void mouseDragged(MouseEvent e){
		x=e.getX()-dx; 	y=e.getY()-dy;
		if(dx>0&&dx<50&&dy>0&&dy<70){
			Graphics g=getGraphics();
			update(g);
		}
	}
	public void mouseMoved(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void paint(Graphics g) {
    	g.drawImage(img,x,y,50,70,this);
    	posX=x; posY=y;
    }
}