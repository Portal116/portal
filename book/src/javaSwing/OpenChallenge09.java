package javaSwing;

import java.awt.*;
import javax.swing.*;

public class OpenChallenge09 extends JFrame{
	public OpenChallenge09() {
		setTitle("OpenChallenge09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		
		setSize(300, 300);
		setVisible(true);
		setBackground(Color.WHITE);
	}
	public static void main(String[] args) {
		new OpenChallenge09();
	}
}
class NorthPanel extends JPanel{
	public NorthPanel() {
		this.add(new JButton("Open"));
		this.add(new JButton("Read"));
		this.add(new JButton("Close"));
		setBackground(Color.LIGHT_GRAY);
	}
}
class CenterPanel extends JPanel{
	public CenterPanel() {
		this.setLayout(null);
		String[] text = {"Hello", "Java", "Love"};
		int x;
		int y;
		for(int i=0;i<3;i++) {
			x = (int)(Math.random()*250);
			y = (int)(Math.random()*210);
			JLabel la = new JLabel(text[i]);
			la.setLocation(x, y);
			la.setSize(50, 10);
			this.add(la);
		}
	}
}