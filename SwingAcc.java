import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingAcc extends SwingChairMan{

   public SwingAcc(){
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      //setExtendedState(getExtendedState() | MAXIMIZED_BOTH); 
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      //setVisible(true);
      
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



}


}