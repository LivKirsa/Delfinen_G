import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login{

   JFrame [] holdFrame = new JFrame[1];
   
   public Login(){
      RunLoginUI();
   }
   
   public void runChairManUI(){
   }
   
   public void runAccUI(){
   }
   
   public void runCoachUI(){
   }
   
         static boolean isFrameOpen = false;

   public void RunLoginUI(){ 
   JFrame frame = new JFrame("login box"); 
   frame.setSize(300, 200);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      holdFrame[0] = frame;
   JPanel panel = new JPanel();
   
       JButton runChairManButton = new JButton("Chairman");
      runChairManButton.setBackground(Color.BLUE);
      JButton runAccButton = new JButton("Accaounten");
      runAccButton.setBackground(Color.WHITE);
      JButton runCouchButton = new JButton("Couch");
      runCouchButton.setBackground(Color.RED);
      
       panel.add(runChairManButton);
       panel.add(runAccButton);
       panel.add(runCouchButton);
       frame.add(panel);
       frame.setVisible(true);
       centerFrameOnScreen(frame); 
       
       // this is the action to run chairman UI. 
       runChairManButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         
            new SwingChairMan();//.setVisible(true);
            
         }
       });
       // this is the action to run the accounten UI
       runAccButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (!isFrameOpen){
            //holdFrame[0] = new SwingAcc();
            new SwingAcc().setVisible(true);  
            }
                  }
       });
            
              // this is the action to runs the Coach UI
            runCouchButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
               //holdFrame[0] = new SwingCoach();
                  new SwingCoach().setVisible(true);
         }
       });
                  holdFrame[0].setVisible(true);

       }
       //Method to set the window in the middle of the screen. 
       public static void centerFrameOnScreen(JFrame frame){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
          int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
          int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2); 
          frame.setLocation(centerX, centerY);     
          }  
   }
