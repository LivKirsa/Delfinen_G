import java.util.*;
import java.time.LocalDateTime;

public class Team {
   
   String coachName;
   ArrayList <Member> teamList = new ArrayList<Member>();
   
   public Team(){
      //teamList.add(new Member("Johnny", "11. juni 2004", true, false, false, true));
      //String name, String birthday, boolean isActiveMembership, boolean isJuniorMembership, boolean isCompetitiveSwimmer, boolean isMan
      teamList.add(Main.jens);
      //teamList.get(0).bestTimesList.add(new Result(500, "Crawl", 130));
   }
   
   public void updateTeamList(){
      teamList.add(Main.jens);
   }
   
   public void addResult(int memberNumber, int length, String swimmingStyle, int time){//, LocalDateTime date){//(ikke CompResult).
      Result result = new Result(length, swimmingStyle, time);//, date);//print Result.
      
      if (teamList.get(memberNumber).bestTimesList.size() > 0){
         boolean addDiscipline = false;
         
         for(Result r : teamList.get(memberNumber).bestTimesList){
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
         }//end of for each loop.
         
         if (addDiscipline){//if the discipline doesnt exist yet:
            disciplineDoesntExist(memberNumber, result);//discipline added to members besttimes list if no former instances.
         }
         
      }else{//if besttimeslsit is entirely empty:
         disciplineDoesntExist(memberNumber, result);//discipline added to members besttimes list if no former instances.
      }
   }
   
   public void disciplineDoesntExist(int memberNumber, Result result){
      System.out.print("\nny disciplin oprettet: ");
         result.printResult();
         teamList.get(memberNumber).bestTimesList.add(result);
   }
}