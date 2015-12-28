import java.awt.*;
public class AppEx2 extends java.applet.Applet {
   public void paint(Graphics g) {
    	g.drawLine(40,30,200,30);
    	g.drawRect(40,50,160,150);
    	g.drawOval(45,55,150,140);
    	g.drawString("drawing in applet",100,130);
    }
}