public class Main{

   static Member andrea = new Member("Andrea Andreassen", "1991-12-12", true, false, false); // Hold 1
   static Member grete = new Member("Grete Gregersen", "1800-05-13", true, false, false); // Hold 1
   static Member morten = new Member("Morten Mortensen", "2010-09-30", true, true, true); // Hold 2
   static Member julie = new Member("Julie Juliussen", "2009-09-30", true, true, false); // Hold 2
   static Member ole = new Member("Ole Olesen", "2010-03-25", true, true, true); // Hold 2
   static Member carl = new Member("Carl Carlsen", "1989-10-01", true, true, true); // Hold 3
   static Member jens = new Member("Jens Jensen", "1999-08-20", true, true, true); // Hold 3

   
   public static void main (String [] args){

   grete.printMember();
   
   TeamList.team1.printTeam();
   TeamList.team2.printTeam();
   TeamList.team3.printTeam();
 
   TeamList.team1.addResult(0, 500, "Crawl", 120);//date);
   TeamList.team1.addResult(0, 500, "Crawl", 110);
   TeamList.team1.addResult(0, 500, "Crawl", 130);
   TeamList.team1.addResult(0, 500, "Crawl", 130);
   TeamList.team1.addResult(0, 200, "Crawl", 60);

   andrea.printBestTimesList();
   }
}