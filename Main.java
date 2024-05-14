import javax.swing.*;

public class Main{
   static Member luise = new Member("Luise Jensen","1915-01-20",false, true, false,false);
   
   public static void main (String [] args){
   Member kenney = new Member("Kenney Jensen","1900-12-12",true, true, true,true); 
   TeamList.team1.addResult(0,500,"Crawling",20);
   TeamList.team1.printTeam(); 
    SwingUtilities.invokeLater( //dette kører swing 
         ()->{ 
            new Login();  
         });
   
   }
}
