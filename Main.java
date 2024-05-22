public class Main{ 
   static Member jens = new Member("Jens Jensen", "1999-08-20", true, true, true);
   static Member grete = new Member("Grete Gregersen", "1800-05-13", false, false, false);
   static Member andrea = new Member("Andrea Andreassen", "1991-12-12", true, false, false); // Hold 1
   static Member morten = new Member("Morten Mortensen", "2010-09-30", true, true, true); // Hold 2
   static Member julie = new Member("Julie Juliussen", "2009-09-30", true, true, false); // Hold 2
   static Member ole = new Member("Ole Olesen", "2010-03-25", true, true, true); // Hold 2
   static Member carl = new Member("Carl Carlsen", "1989-10-01", true, true, true); // Hold 3
   
   public static void main (String [] args){
         FileHandling filehandling = new FileHandling();
      
      System.out.println("\n" + MemberList.memberList.get(0).getName());
      MemberList.memberList.get(0).setName("Findus");
      System.out.println(MemberList.memberList.get(0).getName());
      
      //TeamList.teamList.get(2).teamMemberList.get(0).addResult(0, 500, "Crawl", 300);
      TeamList.team3.addResult(0, 300, "Crawl", 4, 30, 81);//date);
      TeamList.team3.addResult(0, 500, "Crawl", 6, 41, 02);
      TeamList.team3.addResult(0, 500, "Crawl", 6, 55, 99);
      TeamList.team3.addResult(0, 500, "Crawl", 6, 02, 302);
      
      ((CompTeam)TeamList.team3).addResult(0, 400, "Crawl", 4, 50, 99, "Aarhus Stadion", 3);
      
      ((CompTeam)TeamList.team3).printDiscTop5List();
      jens.printBestTimesList();
      
         filehandling.writeFile();
      
      MemberList.memberList.get(0).setName("Pedersen");//won't be saved.
      
         filehandling.readFile();
            
      for(Team t : TeamList.teamList){
         t.printTeam();
      }
      
      //System.out.println("MemberList: " + MemberList.memberList + ", TeamList: " + TeamList.teamList + ", member best: " +  MemberList.memberList.get(0).bestTimesList + ", team top 5: " + ((CompTeam)TeamList.teamList.get(2)).printTeamResultList());
      
   }
}