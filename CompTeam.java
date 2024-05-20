import java.util.ArrayList;
import java.util.*;

public class CompTeam extends Team{
   ArrayList <CompMember> compList = new ArrayList <CompMember>();//??
   ArrayList <ArrayList<Result>> discTop5List= new ArrayList <ArrayList<Result>>();
   
   //constructor
   public CompTeam(String teamName, int teamNumber, String coachName){
      super(teamName, teamNumber, coachName);
   }
   
   @Override
   public void addResult(int memberNumber, int length, String swimmingStyle, int time){
      super.addResult(memberNumber, length, swimmingStyle, time);
      
      compareTeamResult();
   }
         
   //overload
   public void addResult(int memberNumber, int length, String swimmingStyle, int time, String location){
      result = new CompResult(length, swimmingStyle, time, location);//, date);
      result.memberID = teamMemberList.get(memberNumber).getMemberID();//assign memberID to result
      comparePersonalResult(memberNumber);
      
      compareTeamResult();
   }
   
   public void compareTeamResult(){
      boolean resultsCompared = false;
      if (discTop5List.size() > 0){//if discipline list isn't empty:
         for(ArrayList<Result> dList : discTop5List){
            if(compareDiscipline(dList) == 0){//if result == discipline in dList:
               compareTeamTimes(dList, 5);//comparing times.
               resultsCompared = true;
               break;           
            }
         }//end of for each loop*/
         
         if (!resultsCompared) {//if results haven't been compared, that means the discipline doesn't exist yet.
            disciplineDoesntExist();
         } 
      }else{
         disciplineDoesntExist();//no disciplines exist yet.
      }//end of if statement.
   }
   
   public void compareTeamTimes(ArrayList<Result> list, int listSize){
      //list.add(new Result(5,"beep boop", 10000));
      list.add(result);
      for(Result r : list){
         //System.out.println("heehooheehoo");
         if (result.time <= r.time){
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
      
   public void disciplineDoesntExist(){//adds new discipline (dList) to discTop5List.
      ArrayList<Result> top5List = new ArrayList<Result>();
      
      top5List.add(result);
      discTop5List.add(top5List);
      
      System.out.println("added discipline to team best lsit");
   }
   
   public void printDiscTop5List(){
      System.out.println(printTeamResultList());
   }
   
   public String printTeamResultList(){
      String string = "\n";
      for (ArrayList<Result> dList : discTop5List){
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