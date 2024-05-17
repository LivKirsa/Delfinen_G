import javax.swing.*;

public class Main{
   static Member luise = new Member("Luise Jensen","1915-01-20",false, true, false,false);
   
   public static void main (String [] args){
   Member kenney = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member T = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member A = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member C = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member G = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member K = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member H = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member V = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member X = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member M = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member B = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member Q = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member T1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member A1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member C1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member G1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member K1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member H1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member V1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member X1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member M1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member B1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member Q1 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
    Member T2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member A2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member C2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member G2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member K2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member H2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member V2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member X2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member M2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member B2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   Member Q2 = new Member("Kenney Jensen","1900-12-12",true, true, true,true);
   TeamList.team1.addResult(0,500,"Crawling",20);
   TeamList.team1.printTeam(); 
    SwingUtilities.invokeLater( //dette kører swing 
         ()->{ 
            new Login();  
         });
   
   }
}
