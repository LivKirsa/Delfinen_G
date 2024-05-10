import javax.swing.* ;
import java.awt.*;
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
   
       JButton addButton = new JButton("Chairman");
      addButton.setBackground(Color.BLUE);
      JButton bddButton = new JButton("Accaounten");
      bddButton.setBackground(Color.WHITE);
      JButton cddButton = new JButton("Couch");
      cddButton.setBackground(Color.RED);
      
       panel.add(addButton);
       panel.add(bddButton);
       panel.add(cddButton);
       frame.add(panel);
       frame.setVisible(true);
       centerFrameOnScreen(frame); 
       }
       //Method to set the window in the middle of the screen. 
       private static void centerFrameOnScreen(JFrame frame){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
          int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
          int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2); 
          frame.setLocation(centerX, centerY);   
          }
       
   
   }
