import javax.swing.*;
import java.awt.*;

public class SwingTeam extends SuperSwing{//class to be added to Couch class.
   JButton b1, b2;
   
   public SwingTeam(int teamNumber){
      super(false);
      setVisible(true);
      setButtons();
      super.Button1().setText("Se discipliner");
      b2.setText("Se Medlemmer");
   }
   
   public void setButtons(){
      b1 = super.Button1();
      b2 = super.Button2();
   }
   
   
   //add jtable

}