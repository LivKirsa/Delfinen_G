public class Main{

   static Member jens = new Member("Jens Jensen", "1999-08-20", true, true, true, true);
   static Member grete = new Member("Grete Gregersen", "1800-05-13", false, false, false, false);
   
   public static void main (String [] args){
      
      //FileHandling filehandling = new FileHandling();
      
      //MemberList.memberList.get(0);
      //Member jens = new Member("Jens Jensen", "1999-08-20", true, true, true, true);
      
      System.out.println("\n" + MemberList.memberList.get(0).getName());
      MemberList.memberList.get(0).setName("Findus");
      System.out.println(MemberList.memberList.get(0).getName());
      
      //TeamList.teamList.get(2).teamMemberList.get(0).addResult(0, 500, "Crawl", 300);
      TeamList.team3.addResult(0, 300, "Crawl", 120);//date);
      TeamList.team3.addResult(0, 500, "Crawl", 300);
      TeamList.team3.addResult(0, 500, "Crawl", 400);
      TeamList.team3.addResult(0, 500, "Crawl", 200);
      
      ((CompTeam)TeamList.team3).addResult(0, 400, "Crawl", 300, "Aarhus Stadion");
      
      System.out.println(((CompTeam)TeamList.teamList.get(2)).discTop5List);
      ((CompTeam)TeamList.team3).printDiscTop5List();
      jens.printBestTimesList();
      
      
         //filehandling.writeFile();
      
      MemberList.memberList.get(0).setName("Peddersen");//won't be saved.
      
         //filehandling.readFile();
      
      for(Team t : TeamList.teamList){
         t.printTeam();
      }
      
      
      
      
      System.out.println("MemberList: " + MemberList.memberList + ", TeamList: " + TeamList.teamList + ", member best: " +  MemberList.memberList.get(0).bestTimesList + ", team top 5: " + ((CompTeam)TeamList.teamList.get(2)).discTop5List);
      
      
      //jens.printMember();
      //grete.printMember();
      
      //TeamList.team3.printTeam();

      //jens.printMember();
      //Team team = new Team("Motionister", 0, "Hanne");
      /*
      
      TeamList.team1.addResult(0, 500, "Crawl", 120);//date);
      TeamList.team1.addResult(0, 500, "Crawl", 110);
      TeamList.team1.addResult(0, 500, "Crawl", 130);
      TeamList.team1.addResult(0, 500, "Crawl", 130);
      TeamList.team1.addResult(0, 200, "Crawl", 60);
      
      TeamList.team3.addResult(0,400, "Crawl", 300);
      ((CompTeam)TeamList.team3).addResult(0, 400, "Crawl", 300, "Aarhus Stadion");//downcasting to add compresult.
      
      
      //System.out.println("" + jens.bestTimesList);
      grete.printBestTimesList();
      jens.printBestTimesList();*/
   }
}