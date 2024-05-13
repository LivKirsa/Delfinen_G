import java.util.ArrayList;

public class CompTeam extends Team{
   ArrayList <CompMember> compList = new ArrayList <CompMember>();
   
   ArrayList <Result[]> discTop5List;
   
   public void addCompResult(int memberNumber, int length, String swimmingStyle, int time, String location){
      Result result = new CompResult(length, swimmingStyle, time, location);//, date);//print Result.
      comparePersonalResult(memberNumber, result);
      compareTeamResult(memberNumber, result);
   }
   
   /*public void addResult(int memberNumber, int length, String swimmingStyle, int time){
      super.addResult(memberNumber, length, swimmingStyle, time);
      compareTeamResult(memberNumber, result);
   }*/
   
   public void compareTeamResult(int memberNumber, Result result){
      discTop5List = new ArrayList <Result[]>();
      Result [] top5List = new Result [5];
      discTop5List.add(top5List);
      top5List[0] = result;
      
      /*for( dList : discTop5List){
         if (r.length == result.length && r.swimmingStyle.equalsIgnoreCase(result.swimmingStyle)){//compare disciplines. If same:
         //if (teamList.get(memberNumber).bestTimesList.contains(
            if(r.time > result.time){//comparing times. If new time < old time, new time is added. 
              System.out.print("resultat opdateret: ");
               result.printResult();
               teamList.get(memberNumber).bestTimesList.set(teamList.get(memberNumber).bestTimesList.indexOf(r), result);//replace old time with new time.
               break;
            }
         }else{
            addDiscipline = true;          
         }
      }//end of for each loop.*/

   }
}