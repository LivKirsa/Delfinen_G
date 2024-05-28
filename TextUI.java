import java.util.Scanner;

public class TextUI {
   FileHandling fileHandling = new FileHandling();
   Scanner scanner = new Scanner(System.in);
   
   public TextUI(){
      uiSwitch();
   }
   
   public void uiSwitch(){
      
      int choice = 1;
      
      switch(choice){
         case 1:
            showTop5List(true);
            showTop5List(false);
            break;
            
         case 2:
            setCoach();
            break;
            
         case 3:
            showPersonalBestTimesList();
            break;
            
         case 4:
            showTeam();
            break;
            
         case 5:
            showTeamMembers();
            break;
            
         default:
            break;
      }
      
   }
   
   public void showTop5List(boolean isMan){
      
   }
   
   public void showTeamMembers(){
   
   }
   
   public void showTeam(){
   }
   
   public void setCoach(){
   }
   
   public void showPersonalBestTimesList(){
   }
   
   //vis top 5 for hvert køn
   //vis hold liste
   //vis holdoversigt
   //sæt træner for hold
   //vis personalBestTimes
}