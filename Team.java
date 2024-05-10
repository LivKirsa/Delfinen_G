import java.util.*;

public class Team{
   
   String teamName;
   int teamNumber;
   String coachName;
   ArrayList<Member> teamMemberList = new ArrayList<Member>();
   
   
   // Constructor for constructing teams
   
   public Team(String teamName, int teamNumber, String coachName){
      this.teamName = teamName;
      this.teamNumber = teamNumber;
      this.coachName = coachName;
      this.teamMemberList = teamMemberList;
      TeamList.addTeam(this);
   }

   public void updateTeamList(){
   }
   
   public void addResult(){//parametre her for at instantiere nyt result.(ikke CompResult).
      //teamListResults.add(new Result());
   }
   
   // Setter for coachName
   public void setCoach(String coachName){
      this.coachName = coachName;
   }
   
   // Method for printing Team information
   public void printTeam(){
      System.out.println("_________________________________________");
      System.out.println("(" + teamNumber + ") Team Name: " + teamName + ". Coach name: " + coachName);
      System.out.println("Team Members: \n");
      for (Member member : teamMemberList){
         member.printMemberName();
      }
   }
}

