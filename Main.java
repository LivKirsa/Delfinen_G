import javax.swing.*;

public class Main{
   
   public static void main (String [] args){
   Member kenney = new Member("Kenney Jensen","1900-12-12",true, true, true,true); 
   Member luise = new Member("Luise Jensen","1915-01-20",false, true, false,false);
    SwingUtilities.invokeLater( //dette kører swing 
         ()->{ 
            new Login();  
         });
   
   }
}