import java.util.ArrayList;

public class TeamList{
   static ArrayList<Team> teamList = new ArrayList <Team>();
   
   // Method for adding teams to teamList
   static public void addTeam(Team team){ // Takes a Team Object input and adds it to the teamList ArrayList
      teamList.add(team);
      updateTeamList();
   }
   
   public static void updateTeamList(){
   }
   
   public static void assignCoachToTeam(int teamNumber, String coachName){
   }
   
   public static void assignMemberToTeam(int teamNumber, int memberNumber){
   }
}  