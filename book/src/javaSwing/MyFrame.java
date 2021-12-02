package javaSwing;

import java.awt.*;
import javax.swing.*;


public class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("300x300 스윙 프레임 만들기");
		setSize(300, 300);
		setVisible(true);
		Container contentPane = getContentPane();
		JButton button = new JButton("Click");
		contentPane.add(button);
	}
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();		
	}
}
