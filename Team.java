import java.util.*;

public class Team{
   
   String teamName;
   String coachName;
   ArrayList<Member> teamMembers = new ArrayList<Member>();
   
   // Constructor for constructing teams
   
   public Team(String teamName, String coachName, ArrayList<Member> teamMembers){
      this.teamName = teamName;
      this.coachName = coachName;
      this.teamMembers = teamMembers;
   }
   
   public void updateTeamList(){
   }
   
   public void addResult(){//parametre her for at instantiere nyt result.(ikke CompResult).
      //teamList.add(new Result());
   }
}