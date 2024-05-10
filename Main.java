public class Main{

   static Member jens = new Member("Jens Jensen", "1999-08-20", true, true, true, true);
   
   public static void main (String [] args){
   
      //jens.printMember();
      Team team = new Team();
      team.addResult(0, 500, "Crawl", 120);//date);
      team.addResult(0, 500, "Crawl", 110);
      team.addResult(0, 500, "Crawl", 130);
      team.addResult(0, 500, "Crawl", 130);
      team.addResult(0, 200, "Crawl", 60);

      //System.out.println("" + jens.bestTimesList);
      jens.printBestTimesList();
   }
}