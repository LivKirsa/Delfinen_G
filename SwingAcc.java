import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingAcc  extends JPanel {
   JFrame f = new JFrame(); 
   
    public SwingAcc(boolean visible) {
      setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setTitle("Couch");
        f.setVisible(visible);
        f.add(this);
        buttonPanel();
      }
      
      public void buttonPanel(){
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        JButton b1 = new JButton("Se Resistance");
        b1.setBackground(Color.RED);
        buttonPanel.add(b1);
        add(buttonPanel, BorderLayout.WEST);
      //actions of the b1 button 
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
       });
      
      add(buttonPanel);


}


}