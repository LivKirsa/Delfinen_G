import javax.swing.*;
import java.awt.*;

public class SwingTeam extends SuperSwing{//class to be added to Couch class.
   JButton b1, b2;
   
   public SwingTeam(int teamNumber){
      super(false);
      setVisible(true);
      f.setSize(300,300);
      //setButtons();
     // super.Button1().setText("Se discipliner");
      //b2.setText("Se Medlemmer");
   }
   
   /*
   public void setButtons(){
      b1 = super.Button1();
      b2 = super.Button2();
   }*/
   
   public JButton Button1(){
      JButton button = super.Button1();
      button.setText("Se discipliner");
      button.setBackground(turkis1);
      return button;
   }
   
   public JButton Button2(){
   JButton button = super.Button2();
   button.setText("Se Medlemmer");
   button.setBackground(blue);
      return button;

   }
   
   
   //add jtable

}