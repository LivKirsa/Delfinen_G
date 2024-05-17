import java.util.ArrayList;
import java.io.Serializable;

public class TeamList implements Serializable{
   static ArrayList<Team> teamList = new ArrayList <Team>();
   
   // Method for adding teams to teamList
   static public void addTeam(Team team){ // Takes a Team Object input and adds it to the teamList ArrayList
      teamList.add(team);
      updateTeamList();
   }
   
   // static status right now, because otherwise I can't print them in main. Static can be removed with no issues, I think. - Liv
   static Team team1 = new Team("Casual Team", 1, "Coach Martin");//grete
   static Team team2 = new CompTeam("Competitive Junior Team", 2, "Coach Signe");
   static Team team3 = new CompTeam("Competitive Senior Team", 3, "Coach Liv");//jens
   
   // Method for adding members to the right team
   public static int autoAssignToTeam(Member member){
   boolean competitive = member.getIsCompetitiveSwimmer();
   int age = member.getAge();
      if (competitive == false){
         team1.teamMemberList.add(member);
             return 1;
      } else if (competitive == true && age < 18) {
         team2.teamMemberList.add(member);
            return 2;
      } else if (competitive == true && age >= 18) {
         team3.teamMemberList.add(member);
            return 3;
      } else {
      return -1;
      // Insert some kind of error message here
      }
      
   } // End of method for adding members to team
   
   
   public static void updateTeamList(){
   }
   
   public static void assignCoachToTeam(int teamNumber, String coachName){ // The setter setCoach (String coachName) exixts in Team.class
   
   }
   
   public static void assignMemberToTeam(int teamNumber, int memberNumber){
   }
}  