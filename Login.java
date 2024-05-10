import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login{

   public Login(){
      RunLoginUI();
   }
   
   public void runChairManUI(){
   }
   
   public void runAccUI(){
   }
   
   public void runCoachUI(){
   }
   public void RunLoginUI(){
   JFrame frame = new JFrame("login box"); 
   frame.setSize(300, 200);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   JPanel panel = new JPanel();
   
       JButton runChairManButton = new JButton("Chairman");
      runChairManButton.setBackground(Color.BLUE);
      JButton runAccButton = new JButton("Accaounten");
      runAccButton.setBackground(Color.WHITE);
      JButton cddButton = new JButton("Couch");
      cddButton.setBackground(Color.RED);
      
       panel.add(runChairManButton);
       panel.add(runAccButton);
       panel.add(cddButton);
       frame.add(panel);
       frame.setVisible(true);
       centerFrameOnScreen(frame); 
       
       // this is the action to run chairman UI. 
       runChairManButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new SwingChairMan(); 
         }
       });
       // this is the action to run the accounten UI
       runAccButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new SwingAcc();  
         }
       });
         
       }
       //Method to set the window in the middle of the screen. 
       public static void centerFrameOnScreen(JFrame frame){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
          int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
          int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2); 
          frame.setLocation(centerX, centerY);     
          }
          
          
       
   
   }
