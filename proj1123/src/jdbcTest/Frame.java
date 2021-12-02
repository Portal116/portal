package jdbcTest;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      JPanel mPanel =  MainPanel.getPanel();

      frame.add(mPanel);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setPreferredSize(new Dimension(1200, 800));
      frame.setSize(1200, 800);
      frame.setLocationRelativeTo(null);// 가운데에서 출력
      frame.setVisible(true);

   }
}

class MainPanel extends JPanel {
   private static JPanel panel;
   private MainPanel() {
   }

   public static JPanel getPanel() {
      if(panel == null) {
         panel = new JPanel();
         panel.setLayout(new BorderLayout());
         JLabel label = new JLabel("some text");
         JButton btn1 = new JButton("cLick me!");
         JTextArea tArea = new JTextArea();
         panel.add(label, BorderLayout.NORTH);
         panel.add(btn1, BorderLayout.WEST);
         panel.add(tArea, BorderLayout.CENTER);
      }
      return panel;
   }
}