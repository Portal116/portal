package javaSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OpenChallenge10 extends JFrame {	
	public OpenChallenge10() {
		setTitle("Open Challenge 10");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel());
		
		setSize(550,350);
		setVisible(true);
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}
	
	class GamePanel extends JPanel { 
		JLabel la[] = new JLabel[3];
		JLabel result = new JLabel("시작합니다.");
		public GamePanel() {
			setLayout(null);
			la[0] = new JLabel(Integer.toString(0));
			la[1] = new JLabel(Integer.toString(0));
			la[2] = new JLabel(Integer.toString(0));
			for(int i=0;i<3;i++) {
				la[i].setFont(new Font("Arial", Font.ITALIC, 40));
				la[i].setForeground(Color.YELLOW);
				JPanel pa = new JPanel();
				pa.add(la[i]);
				pa.setBackground(Color.MAGENTA);
				pa.setSize(100,50);
				pa.setLocation(110*(i+1), 80);
				add(pa);
				addKeyListener(new MyKeyListener());
				pa.requestFocus();
			}
			result.setFont(new Font("", Font.BOLD, 25));
			add(result);
			result.setSize(150,25);
			result.setLocation(210,200);
		}
		
		class MyKeyListener extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				int aa,bb,cc;
				if(e.getKeyChar() == '\n') {
						aa = (int)(Math.random()*5);
						bb = (int)(Math.random()*5);
						cc = (int)(Math.random()*5);
						
						la[0].setText(Integer.toString(aa));
						la[1].setText(Integer.toString(bb));
						la[2].setText(Integer.toString(cc));
						
						if(aa==bb && bb==cc)
							result.setText("축하합니다!!");
						else
							result.setText("아쉽군요");
				}
			}
		}
	}
	public static void main(String [] args) {
		new OpenChallenge10();
	}
}
