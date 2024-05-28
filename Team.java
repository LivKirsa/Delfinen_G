import java.util.*;
import java.time.LocalDateTime;
import java.time.Duration;
import java.io.Serializable;

public class Team implements Serializable{

   String teamName;
   int teamNumber;
   String couchName;
   Result result;

   ArrayList<Member> teamMemberList = new ArrayList<Member>(); // This was made static to make removeMember method work
   
    static String[] col = {"Holdnavn", "Holdnummber", "Træner", "Hold"};
    

   // Constructor for constructing teams
   
   public Team(String teamName, int teamNumber, String couchName){
      this.teamName = teamName;
      this.teamNumber = teamNumber;
      this.couchName = couchName;
      //this.teamMemberList = teamMemberList;
      TeamList.addTeam(this);
   }
   
   public void addResult(int memberNumber, int length, String swimmingStyle, int m, int s, int ms){//, LocalDateTime date){//(ikke CompResult).
      result = new Result(length, swimmingStyle, m, s, ms);
      result.memberID = memberNumber;//teamMemberList.get(memberNumber).getMemberID();//assign memberID to result
      result.name = teamMemberList.get(memberNumber).getName();//setting Result.name
      comparePersonalResult(memberNumber);
   }
   
   public void comparePersonalResult(int memberNumber){
      if (teamMemberList.get(memberNumber).bestTimesList.size() > 0){
         if (compareDiscipline(teamMemberList.get(memberNumber).bestTimesList) < 0){//!compareResult(teamMemberList.get(memberNumber).bestTimesList, true)){//if Compare personalResult returns false = the discipline doesnt exist yet:
            //System.out.println("disciplin findes ikke.");
            disciplineDoesntExist(teamMemberList.get(memberNumber).bestTimesList);//discipline added to members besttimes list if no former instances.
 
         } else {
            //System.out.println("disciplin findes");
            teamMemberList.get(memberNumber).bestTimesList.set(teamMemberList.get(memberNumber).bestTimesList.size() -1, result);

         }
      } else {//if besttimeslsit is entirely empty:
         //System.out.println("ingen discipliner oprettet");
         disciplineDoesntExist(teamMemberList.get(memberNumber).bestTimesList);//discipline added to members besttimes list if no former instances.  
      }
      
      //System.out.println();
   } 
   
   //returns index of discipline matching result in list.
   public int compareDiscipline(ArrayList<Result> list){//compare result with parameter - list. does discipline exist in list?= true/fasle.
      for(Result r : list){
         if (r.length == result.length && r.swimmingStyle.equalsIgnoreCase(result.swimmingStyle)){//compare disciplines. If same:   
            return list.indexOf(r);
         }
      }//end of for each loop.
      return -1;//if discipline doesnt exist: return false.
   }
   
   public void disciplineDoesntExist(ArrayList<Result> list){//if discipline doesnt exist: add result to parameter-list. 
      System.out.print("Ny disciplin oprettet: ");
      result.printResult();
      list.add(result);

   }
   
   // Setter for couchName
   public void setCouch(String couchName){
      this.couchName = couchName;
   }
   
   // Method for printing Team information
   public void printTeam(){
      System.out.println("_________________________________________");
      System.out.println("(" + teamNumber + ") Team Name: " + teamName + ". Coach name: " + couchName);
      System.out.println("Team Members: \n");
      for (Member member : teamMemberList){
         member.printMemberName();
      }
   }

   public Object[] getTeamInfoAsArray(){
      Object[] row = {teamName, teamNumber, couchName, "Se Hold"};
      return row;
   }
}

