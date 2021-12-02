import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Lesson06 {

   private JFrame frame;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Lesson06 window = new Lesson06();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Lesson06() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setTitle("Lesson06");
      frame.setBounds(100, 100, 800, 600);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);


      frame.getContentPane().add(new FirstPanel().getPanel());
      frame.getContentPane().add(new LastPanel().getPanel());


   }
}

class FirstPanel extends JPanel {
   static JPanel firstPanel = new JPanel();

   public FirstPanel( ) {
      
      firstPanel.setLayout(null);
      firstPanel.setBounds(0, 0, 784, 561);
      firstPanel.setBackground(Color.BLACK);
      
      JButton btnLast = new JButton("GO TO LAST");
      btnLast.setBounds(58, 129, 156, 260);
      btnLast.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            LastPanel.getPanel().setVisible(true);
            firstPanel.setVisible(false);
         }
      });
      firstPanel.add(btnLast);
   }
   public static JPanel getPanel() {
      return firstPanel;
   }
}

class LastPanel extends JPanel {

   static JPanel lastPanel = new JPanel();
   public LastPanel() {

      lastPanel.setLayout(null);
      lastPanel.setBounds(0, 0, 784, 561);
      lastPanel.setBackground(Color.WHITE);

      JButton btnFirst = new JButton("GO TO FIRST");
      btnFirst.setBounds(478, 111, 227, 303);
      btnFirst.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            lastPanel.setVisible(false);
            FirstPanel.getPanel().setVisible(true);
         }
      });
      lastPanel.add(btnFirst);
   }
   public static JPanel getPanel() {
      return lastPanel;
   }
}