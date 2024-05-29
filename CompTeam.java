import java.util.ArrayList;
import java.util.*;

public class CompTeam extends Team{
   ArrayList <ArrayList<Result>> mensTop5List= new ArrayList <ArrayList<Result>>();
   ArrayList <ArrayList<Result>> womensTop5List= new ArrayList <ArrayList<Result>>();
   
   // Constructor for competitive Teams
   public CompTeam(String teamName, int teamNumber, String coachName){
      super(teamName, teamNumber, coachName);
   }
   
   @Override
   public void addResult(int memberNumber, int length, String swimmingStyle, int m, int s, int ms){
      super.addResult(memberNumber, length, swimmingStyle, m, s, ms);
      compareTeamResult(teamMemberList.get(memberNumber).getIsMan());
   }
         
   // Overload
   public void addResult(int memberNumber, int length, String swimmingStyle, int m, int s, int ms, String location, int placement){
      result = new CompResult(length, swimmingStyle, m, s, ms, location, placement);
      result.memberID = teamMemberList.get(memberNumber).getMemberID();//assign memberID to result
      comparePersonalResult(memberNumber);
      compareTeamResult(teamMemberList.get(memberNumber).getIsMan());
   }
   
   public void compareTeamResult(boolean isMan){
         ArrayList <ArrayList <Result>> list;
      if (isMan){
         list = mensTop5List;
      } else {
         list = womensTop5List;
      }
      
      boolean resultsCompared = false;
      if (list.size() > 0){ // If Discipline list isn't empty:
         for(ArrayList<Result> dList : list){
            if(compareDiscipline(dList) == 0){ // If result == discipline in dList:
               compareTeamTimes(dList, 5);//comparing times.
               resultsCompared = true;
               break;           
            }
         } // End of for each loop*/
         
         if (!resultsCompared) { // If results haven't been compared, that means the discipline doesn't exist yet.
            teamDisciplineDoesntExist(list);
         } 
       } else {
         teamDisciplineDoesntExist(list); // No disciplines exist yet.
      } // End of if statement.
   }
   
   public void compareTeamTimes(ArrayList<Result> list, int listSize){
      list.add(result);
      for(Result r : list){
         if ((result.time).compareTo(r.time) <= 0){
            list.add(list.indexOf(r), result);
            list.remove(list.size() - 1);
            break;
         }else{
            
         }
      } // End of for each loop.
      
      if (list.size()> listSize){
         list.remove(listSize);
      }
   }
   
   
   public void teamDisciplineDoesntExist(ArrayList<ArrayList<Result>> list) { // Adds new discipline (dList) to discTop5List if chosen discipline doesn't exist already.
      ArrayList<Result> top5List = new ArrayList<Result>();
      top5List.add(result);
      list.add(top5List);
      System.out.println("Added discipline to team best list");
   }
   
   public void printDiscTop5List(){
     // System.out.println(printTeamResultList());
   }
   
   public String printTeamResultList(ArrayList<ArrayList<Result>> list){
      String string = "\n";
      for (ArrayList<Result> dList : list){
         string += ("\n" + dList.get(0).swimmingStyle + ", " + dList.get(0).length + " m:\n");
         for (Result r: dList){
             string += (r.memberID + ", " + MemberList.memberList.get(r.memberID).getName());
             string += (r.time + " sek");
             if (r instanceof CompResult){
               string += (", " + ((CompResult)r).location);
             }
             string += ("\n");
         }
         
      }
      return string;
   }
}