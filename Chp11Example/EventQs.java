import java.awt.*;
import java.awt.event.*;
public class EventQs{
	private Frame f=new Frame("≤‚ ‘");
	private Button ok=new Button("push");
	private Label l=new Label("waiting");

	public void init(){
//		ok.addActionListener(new OkListener());
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				l.setText("be pushed");
			}
		});
		f.setLayout(new FlowLayout());
		f.add(l);
		f.add(ok);
		f.pack();
		f.setVisible(true);
	}
	/*
	class OkListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			l.setText("be pushed");
		}
	}*/
	public static void main(String[] args) {
		new EventQs().init();
	}
}