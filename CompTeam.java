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
      boolean discinlist = false;
      ArrayList < Result> rList = new ArrayList <Result>();
      if (discTop5List.size() > 0){//if discipline list isn't empty:
         for(ArrayList<Result> dList : discTop5List){
            if (compareDiscipline(dList) >= 0) {//if discipline doesn't exist:
             discinlist = true;
             rList = dList;
             break;
               /**/
               
            }else {
            disciplineDoesntExist();
               System.out.println("wahhaha");
               
                          }
         }//end of for each loop*/
         if (discinlist){
            compareTeamResult(rList, 5);//add result to dList.
         }
      }else{
         disciplineDoesntExist();
         System.out.println("boohoo");
      }//end of if statement.
   }
   
   public void compareTeamResult(ArrayList<Result> list, int listSize){
      for(Result r : list){
          compareResultTimes(list, r);
          break;
      }
      if (list.size()< listSize){
         list.remove(listSize + 1);
      }
   }
   
   public void disciplineDoesntExist(){//adds new discipline (dList) to discTop5List.
      ArrayList<Result> top5List = new ArrayList<Result>();
      
      top5List.add(result);
      discTop5List.add(top5List);
      
      System.out.println("added discipline to team best lsit");
   }
   
   public void printDiscTop5List(){
      System.out.println(boo());
   }
   
   public String boo(){
      String string = "\n";
      for (ArrayList<Result> dList : discTop5List){
         string += ("\n" + dList.get(0).swimmingStyle + ", " + dList.get(0).length + " m\n");
         for (Result r: dList){
             string += (r.time + " sek\n");
         }
         
      }
      return string;
   }
}