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
      //System.out.println("Compared result with personal and team's best times lists");
   }
         
   //overload
   public void addResult(int memberNumber, int length, String swimmingStyle, int time, String location){
      result = new CompResult(length, swimmingStyle, time, location);//, date);
      result.member = teamMemberList.get(memberNumber).getMemberID();//assign memberID to result
      comparePersonalResult(memberNumber);
      
      compareTeamResult();
      System.out.println("Compared compResult with personal and team's best times lists");
      
   }
   
   public void compareTeamResult(){
      if (discTop5List.size() > 0){
         for(ArrayList<Result> dList : discTop5List){
            if (!compareResult(dList, false)) {
               disciplineDoesntExist();
               break;
               
            }else {
               dList.remove(dList.size() - 1);
            }
         }//end of for each loop*/
         
         for(ArrayList<Result> dList : discTop5List){//for every disciplineList(dList) on teams best times list:
            for (Result r : dList){
               if (!dList.contains(result)){
                  compareResult(dList, false);
                  break;
               }
            }//end of inner for each loop.
            
            
            //Makes dList max length 5:
            if (dList.size() > 5){
               int slowestTime = dList.get(0).time;
               
               for (Result r : dList){
                  if (r.time >= slowestTime) slowestTime = r.time;
               }
               for (Result r : dList){
                  if (r.time == slowestTime) dList.remove(r);
                  break;
               }
            }//end of while
            
         }//end of outer for each loop.
      }else{
         disciplineDoesntExist();
         System.out.println("boohoo");
      }//end of if statement.
   }
   
   public void disciplineDoesntExist(){//adds new discipline (dList) to discTop5List.
      ArrayList<Result> top5List = new ArrayList<Result>();
      
      top5List.add(result);
      discTop5List.add(top5List);
      
      System.out.println("added discipline to team best lsit");
   }
   
   public void printDiscTop5List(){
      for (ArrayList<Result> dList : discTop5List){
         for (Result r: dList){
            r.printResult();
         }
         System.out.println();
      }
   }
}