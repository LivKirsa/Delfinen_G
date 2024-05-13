public class Main{

   static Member jens = new Member("Jens Jensen", "1999-08-20", true, true, true, true);
   static Member grete = new Member("Grete Gregersen", "1800-05-13", false, false, false, false);
   
   public static void main (String [] args){
   
   //Member jens = new Member("Jens Jensen", "1999-08-20", true, true, true, true);
   
   jens.printMember();
   grete.printMember();

   
   TeamList.team1.printTeam();
   TeamList.team3.printTeam();

      //jens.printMember();
      //Team team = new Team("Motionister", 0, "Hanne");
      
      TeamList.team1.addResult(0, 500, "Crawl", 120);//date);
      TeamList.team1.addResult(0, 500, "Crawl", 110);
      TeamList.team1.addResult(0, 500, "Crawl", 130);
      TeamList.team1.addResult(0, 500, "Crawl", 130);
      TeamList.team1.addResult(0, 200, "Crawl", 60);

      //System.out.println("" + jens.bestTimesList);
      grete.printBestTimesList();
   }
}