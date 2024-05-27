import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class SuperSwing extends JPanel {
   Color turkis1 = new Color(199, 237, 231);
   Color turkis2 = new Color(177, 224, 218);
   Color turkis3 = new Color(140, 204, 200);
   Color turkis4 = new Color(103, 159, 157);
   Color purple = new Color(159, 141, 185);
   Color pink = new Color(232, 173, 210);
   Color blue = new Color(171, 218, 233);
   Color softWhite = new Color(241, 234, 231);
   Color darkBlue = new Color(53, 120, 180);
   Color softBlack = new Color(50, 42, 51);
   
   protected JFrame f; 
   
   public SuperSwing(boolean visible) {
   f = new JFrame(); 
      setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setTitle("SuperSwing");
        f.setVisible(visible);
        f.add(this);
        // size of the window 
       f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
       buttonPanel();
      }
      
      void buttonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(30,1)); 
        
        JButton b1 = Button1(); 
        JButton b2 = Button2(); 
        JButton b3 = Button3(); 
        
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
 //add Buttonpanel til WEST
       add(buttonPanel, BorderLayout.WEST);
}
      
      protected JButton Button1() {
        JButton b1 = new JButton("Se Holdlister");
        b1.setBackground(Color.BLUE);
        b1.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b1;
    }
      protected JButton Button2() {
        JButton b1 = new JButton("Se Holdlister");
        b1.setBackground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b1;
    }
      protected JButton Button3() {
        JButton b1 = new JButton("Se Holdlister");
        b1.setBackground(Color.RED);
        b1.addActionListener(new ActionListener() {
        //action for button 1
            public void actionPerformed(ActionEvent e) {

            }
        });
        return b1;
    }      

       }

