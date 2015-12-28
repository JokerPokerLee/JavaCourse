import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
public class AppEx7 extends Applet implements ItemListener,ActionListener{
	Label l1=new Label("Audio Example");
	AudioClip sound;
	Choice c=new Choice();
	Button play=new Button("play");Button loop=new Button("loop");Button stop=new Button("stop");
	public void init(){
		add(l1);c.add("tada.wav");c.add("start.wav");c.add("notify.wav");add(c);
		c.addItemListener(this);add(play);add(loop);add(stop);
		play.addActionListener(this);	loop.addActionListener(this);	stop.addActionListener(this);
		sound=getAudioClip(getCodeBase(),"ding.wav");
	}
	public void itemStateChanged(ItemEvent e){
		sound.stop();
		sound=getAudioClip(getCodeBase(),c.getSelectedItem());
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==play) sound.play();
		else if(e.getSource()==loop) sound.loop();
		else if(e.getSource()==stop) sound.stop();
	}
}