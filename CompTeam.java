import java.util.ArrayList;
import java.util.*;

public class CompTeam extends Team{
   ArrayList <CompMember> compList = new ArrayList <CompMember>();
   ArrayList <Result[]> discTop5List= new ArrayList <Result[]>();
   Result [] top5List;
   
   public CompTeam(String teamName, int teamNumber, String coachName){
      super(teamName, teamNumber, coachName);
   }
   
   public void addResult(int memberNumber, int length, String swimmingStyle, int time, ArrayList<Result> list){
      super.addResult(memberNumber, length, swimmingStyle, time, list);//need to make this for compResult.
      compareTeamResult();
   }
   
   public void compareTeamResult(){ 
      for(Result[] dList : discTop5List){//for every disciplineList(dList) on teams best times list:
         ArrayList< Result> tempArr = new ArrayList < Result>(Arrays.asList(dList)); //so we can use the array with compareResult(ArrayList<Result>)
         if (!compareResult(tempArr)){//comparing result with former team results in same discipline. If false: discipline doesnt exist.
            Result[] top5List = new Result [5];//creating and adding new array(discipline) to team best times list.
            discTop5List.add(top5List);
            top5List[0] = result;//addding result to disciplinelist.
         }
      }//end of for each loop.
   }
   
}