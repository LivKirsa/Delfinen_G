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
   
   static Team team1 = new Team("Casual Team", 1, "Coach Martin");
   static Team team2 = new Team("Competitive Junior Team", 2, "Coach Signe");
   static Team team3 = new Team("Competitive Senior Team", 3, "Coach Liv");
   
   // Method for adding members to the right team
   public void autoAssignToTeam(Member member){
   boolean competitive = member.getIsCompetitiveSwimmer();
   int age = member.getAge();
      if (competitive == false){
         team1.teamMemberList.add(member);
      } else if (competitive == true && age < 18) {
         team2.teamMemberList.add(member);
      } else if (competitive == true && age >= 18) {
         team3.teamMemberList.add(member);
      } else {
      // Insert some kind of error message here
      }
   } // End of method for adding members to team
   
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
      System.out.println("(" + teamNumber + ") Team Name: " + teamName + ". Coach name: " + coachName);
      for (Member member : teamMemberList){
         member.printMember();
      }
   }
}

