import java.util.*;
import java.time.LocalDateTime;

public class Team{
   
   String teamName;
   int teamNumber;
   String coachName;
   Result result;
   ArrayList<Member> teamMemberList = new ArrayList<Member>();
   
   // Constructor for constructing teams
   
   public Team(String teamName, int teamNumber, String coachName){
      this.teamName = teamName;
      this.teamNumber = teamNumber;
      this.coachName = coachName;
      //this.teamMemberList = teamMemberList;
      TeamList.addTeam(this);
   }
   
   public void addResult(int memberNumber, int length, String swimmingStyle, int time){//, LocalDateTime date){//(ikke CompResult).
      result = new Result(length, swimmingStyle, time);//, date);
      result.member = teamMemberList.get(memberNumber).getMemberID();//assign memberID to result
      comparePersonalResult(memberNumber);
   }
   
   public void comparePersonalResult(int memberNumber){
      if (teamMemberList.get(memberNumber).bestTimesList.size() > 0){
         if (compareResult(teamMemberList.get(memberNumber).bestTimesList)){//Compare personalResult. if returns false = the discipline doesnt exist yet:
            disciplineDoesntExist(teamMemberList.get(memberNumber).bestTimesList);//discipline added to members besttimes list if no former instances.
         }
      }else{//if besttimeslsit is entirely empty:
         disciplineDoesntExist(teamMemberList.get(memberNumber).bestTimesList);//discipline added to members besttimes list if no former instances.
      }
   }
   
   public boolean compareResult(ArrayList<Result> list){//compare result with parameter - list. does discipline exist in list?= true/fasle.
      for(Result r : list){
         if (r.length == result.length && r.swimmingStyle.equalsIgnoreCase(result.swimmingStyle)){//compare disciplines. If same:
            if(r.time > result.time){//comparing times. If new time(result) < old time(r), new time is added to list 
               list.add(result);
               break;
            }
         return true;//if discipline does exist: return true.
         }
      }//end of for each loop.
      return false;//if discipline doesnt exist: return false.
   }
   
   public void disciplineDoesntExist(ArrayList<Result> list){//if discipline doesnt exist, add result to parameter-list. 
      System.out.print("\nNy disciplin oprettet: ");
      result.printResult();
      list.add(result);
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

