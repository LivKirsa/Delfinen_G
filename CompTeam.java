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
         
   //overload
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
      }else{
         list = womensTop5List;
      }
      
      boolean resultsCompared = false;
      if (list.size() > 0){//if discipline list isn't empty:
         for(ArrayList<Result> dList : list){
            if(compareDiscipline(dList) == 0){//if result == discipline in dList:
               compareTeamTimes(dList, 5);//comparing times.
               resultsCompared = true;
               break;           
            }
         }//end of for each loop*/
         
         if (!resultsCompared) {//if results haven't been compared, that means the discipline doesn't exist yet.
            disciplineDoesNotExist(list);
         } 
      }else{
         disciplineDoesNotExist(list);//no disciplines exist yet.
      }//end of if statement.
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
      }//end of for each loop.
      
      if (list.size()> listSize){
         list.remove(listSize);
      }
   }
   
  public void disciplineDoesNotExist(ArrayList<ArrayList<Result>> list){//adds new discipline (dList) to discTop5List.
      ArrayList<Result> top5List = new ArrayList<Result>();
      
      top5List.add(result);
      list.add(top5List);
      
      System.out.println("added discipline to team best lsit");
   }
   
   public void printDiscTop5List(){
      System.out.println(printTeamResultList());
   }
   
   public String printTeamResultList(){
      String string = "\n";
      for (ArrayList<Result> dList : womensTop5List){
         string += ("\n" + dList.get(0).swimmingStyle + ", " + dList.get(0).length + " m:\n");
         for (Result r: dList){
             string += (r.memberID + ", " + teamMemberList.get(r.memberID).getName());//hmm probably need a for each loop with members to find right member from memberID.
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