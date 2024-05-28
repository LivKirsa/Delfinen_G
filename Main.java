import javax.swing.*;
public class Main{   
   public static void main (String [] args){
       Member m1 = new Member("Kenney Jensen", "2008-12-12", true, true, true);
       Member m2 = new Member("Alice Smith", "1985-06-15",false, true, false);
       Member m3 = new Member("Bob Johnson", "1978-03-22", true, false, true);
       Member m4 = new Member("Carol Williams", "1995-11-09", false, false, true);
       Member m5 = new Member("David Brown", "1982-07-19", true, true, false);
       Member m6 = new Member("Eve Davis", "1993-01-29", true, false, true);
       Member m7 = new Member("Frank Miller", "1975-04-04", false, true, true);
       Member m8 = new Member("Grace Wilson", "1989-09-12", true, true, false);
       Member m9 = new Member("Henry Moore", "1991-05-17", false, false, true);
       Member m10 = new Member("Ivy Taylor", "1984-08-25", true, true, true);
       Member m11 = new Member("Jack Anderson", "1992-02-14", false, true, true);
       Member m12 = new Member("Kara Thomas", "1979-10-01", true, false, true);
       Member m13 = new Member("Leo Martinez", "1987-12-05", true, true, false);
       Member m14 = new Member("Mia Martin", "1994-03-30", false, false, true);
       Member m15 = new Member("Nina Jackson", "1986-07-08", true, true, true);
       Member m16 = new Member("Oscar White", "1990-11-21", false, true, true);
       Member m17 = new Member("Paul Harris", "1983-06-10", true, false, true);
       Member m18 = new Member("Quinn Clark", "1995-09-29", true, true, false);
       Member m19 = new Member("Rose Lewis", "1981-02-25", false, false, true);
       Member m20 = new Member("Sam Walker", "1992-04-12", true, true, true);
       Member m21 = new Member("Tina Hall", "1988-07-03", false, true, false);
       Member m22 = new Member("Ursula Young", "1980-10-19", true, false, true);
       Member m23 = new Member("Victor King", "1991-08-08", true, true, true);
       Member m24 = new Member("Wendy Scott", "1977-12-22", false, true, true);
       Member m25 = new Member("Xander Green", "1985-01-16", true, false, true);
       Member m26 = new Member("Yara Adams", "1993-05-25", true, true, false);
       Member m27 = new Member("Zack Baker", "1989-11-09", false, false, true);
       Member m28 = new Member("Amy Carter", "1978-06-18", true, true, true);
       Member m29 = new Member("Brian Perez", "1982-03-27", false, true, true);
       Member m30 = new Member("Chloe Evans", "1990-09-14", true, false, true);
       

          /*TeamList.team3.addResult(0,500,"Crawling", 4, 50, 891);
   TeamList.team3.printTeam(); */
    SwingUtilities.invokeLater( //dette kører swing 
         ()->{ 
            new Login();
         });
         
         m1.printBestTimesList();
         m1.printMember();
     }
}