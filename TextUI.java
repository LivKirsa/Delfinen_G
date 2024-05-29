import java.util.Scanner;

public class TextUI {
   FileHandling fileHandling = new FileHandling();
   Scanner scanner = new Scanner(System.in);
   boolean closeProgram = false;
   int choice = -1;
   
   public TextUI(){
      fileHandling.readFile();
      //TeamList.teamList.get(1).addResult(0, 400, "Crawl", 4, 4, 4);
      //System.out.println(TeamList.teamList.get(1));
      
      while(!closeProgram){
         try{
            System.out.println("Tast 1 for at se Holdoversigt\nTast 2 for at se et holds medlemmer\nTast 3 for at se te medlems bedste tider\nTast 4 for at se hvilke medlemmer, som har de bedste tider i holdets discipliner\nTast 5 for at ændre et holds træner");
            choice = scanner.nextInt();
            uiSwitch();
         }catch(Exception e){
            System.out.println("Fejl: " + e);
         }
      }
      
      fileHandling.writeFile();
   }
   
   public void uiSwitch(){
      
      
      
      switch(choice){
         case 1:
            showTeam();
            
            break;
            
         case 2:
            showTeamMembers();
            break;
            
         case 3:
            showPersonalBestTimesList();
            break;
            
         case 4:
            showTop5List();
            break;
            
         case 5:
            setCoach();
            break;
            
         default:
            closeProgram = true;
            break;
      }
      
   }
   
   public void showTop5List(){//show top 5 times for every disicpline.
      System.out.println("indtast holdnummer");
      
      int teamNumber = scanner.nextInt() - 1;
      Team team = TeamList.teamList.get(teamNumber);//taking user input.
      
      if (team instanceof CompTeam){
         CompTeam cTeam = (CompTeam) team;
         
         if (cTeam.womensTop5List.size() > 0){
         System.out.println("Bedste tider for kvindelige svømmere:\n" +cTeam.printTeamResultList( cTeam.womensTop5List));//show best times for women
         }
         
         if (cTeam.mensTop5List.size() > 0){
         System.out.println("Bedste tider for mandlige svømmere:\n" + cTeam.printTeamResultList(cTeam.mensTop5List));//show best times for men
         }
         
      }else{
         System.out.println("Holdet er ikke et konkurrencehold");
      }
   }
   
   public void showTeamMembers(){
      System.out.println("indtast holdnummer");
      
      int teamNumber = scanner.nextInt() - 1;
      Team team = TeamList.teamList.get(teamNumber);//taking user input.
      
      team.printTeam();
      
   }
   
   public void showTeam(){
      for (Team t : TeamList.teamList){
         
         t.printTeamInfo();
         System.out.println();
      }      
   }
   
   public void setCoach(){
      System.out.println("indtast holdnummer");
      
      int teamNumber = scanner.nextInt() - 1;
      //String boo = scanner.next();
      //System.out.println(boo);
      
      
      Team team = TeamList.teamList.get(teamNumber);//taking user input.
      
      System.out.println("Indtast holdets nye træners navn");
      
       String couchName = scanner.next();
      team.setCouch(couchName);
      System.out.println("Hold " + team.teamNumber + "'s træner er opdateret til " + couchName);
   }
   
   public void showPersonalBestTimesList(){
      System.out.println("Indtast medlemsnummer");
      int memberNumber = scanner.nextInt() - 1;
      
      MemberList.memberList.get(memberNumber).printBestTimesList();
   }
   
   //vis top 5 for hvert køn
   //vis hold liste
   //vis holdoversigt
   //sæt træner for hold
   //vis personalBestTimes
}