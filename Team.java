import java.util.*;

public class Team{
   
   String teamName;
   int teamNumber;
   String coachName;
   ArrayList<Member> teamMemberList = new ArrayList<Member>();
   
   // Constructor for constructing teams
   
   public Team(String teamName, String coachName, ArrayList<Member> teamMemberList){
      this.teamName = teamName;
      this.teamNumber = teamNumber;
      this.coachName = coachName;
      this.teamMemberList = teamMemberList;
      TeamList.addTeam(this);
   }
   
   public void updateTeamList(){
   }
   
   public void addResult(){//parametre her for at instantiere nyt result.(ikke CompResult).
      //teamList.add(new Result());
   }
}

