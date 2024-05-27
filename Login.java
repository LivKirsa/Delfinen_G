import javax.swing.*;
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
   
   public void runCouchUI(){
   }
   
         static boolean isFrameOpen = false;

   public void RunLoginUI(){ 
   JFrame frame = new JFrame("Login"); 
   frame.setSize(475, 550);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   Color turkis1 = new Color(199, 237, 231);
   Color turkis2 = new Color(177, 224, 218);
   Color turkis3 = new Color(140, 204, 200);
   Color turkis4 = new Color(103, 159, 157);
   Color purple = new Color(159, 141, 185);
   Color pink = new Color(232, 173, 210);
   Color blue = new Color(171, 218, 233);
   Color softWhite = new Color(241, 234, 231);
   Color darkBlue = new Color(61, 133, 198);

   holdFrame[0] = frame;
   JPanel panel = new JPanel(new BorderLayout());
   JPanel dolphinPanel = new JPanel();
   
   // Create a JLabel to hold the image
  JLabel dolphinLabel = new JLabel();
  dolphinPanel.add(dolphinLabel);

  // Load the image (replace "image.png" with your actual image path)
  ImageIcon dolphin = new ImageIcon("textdolphin.png");
  dolphinLabel.setIcon(dolphin);

  // Add the picture label to the panel
   
      JButton runChairManButton = new JButton("Chairman");
      runChairManButton.setBackground(blue);
      runChairManButton.setForeground(darkBlue);
      JButton runAccButton = new JButton("Accountant");
      runAccButton.setBackground(pink);
      runAccButton.setForeground(darkBlue);
      JButton runCouchButton = new JButton("Couch");
      runCouchButton.setBackground(turkis3);
      runCouchButton.setForeground(darkBlue);
      
      JPanel buttonPanel = new JPanel();
       buttonPanel.add(runChairManButton);
       buttonPanel.add(runAccButton);
       buttonPanel.add(runCouchButton);
       panel.add(buttonPanel, BorderLayout.CENTER);
       panel.add(dolphinPanel, BorderLayout.NORTH);
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
            //if (!isFrameOpen){
            //holdFrame[0] = new SwingAcc();
            new SwingAcc(true);  
            }
                  
       });
            
              // this is the action to runs the Coach UI
            runCouchButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
               //holdFrame[0] = new SwingCoach();
                  new SwingCoach(true);//.setVisible(true);
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
