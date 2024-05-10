import java.util.ArrayList;

public class TeamList{
   static ArrayList<Team> teamList = new ArrayList <Team>();
   
   // Method for adding teams to teamList
   static public void addTeam(Team team){ // Takes a Team Object input and adds it to the teamList ArrayList
      teamList.add(team);
      updateTeamList();
   }
   
   // static status right now, because otherwise I can't print them in main. Static can be removed with no issues, I think. - Liv
   static Team team1 = new Team("Casual Team", 1, "Coach Martin");
   static Team team2 = new Team("Competitive Junior Team", 2, "Coach Signe");
   static Team team3 = new Team("Competitive Senior Team", 3, "Coach Liv");
   
   // Method for adding members to the right team
   public static void autoAssignToTeam(Member member){
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
   
   
   public static void updateTeamList(){
   }
   
   public static void assignCoachToTeam(int teamNumber, String coachName){ // The setter setCoach (String coachName) exixts in Team.class
   
   }
   
   public static void assignMemberToTeam(int teamNumber, int memberNumber){
   }
}  