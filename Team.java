import java.util.*;
import java.time.LocalDateTime;

public class Team{
   
   String teamName;
   int teamNumber;
   String coachName;
   ArrayList<Member> teamMemberList = new ArrayList<Member>();
   
   // Constructor for constructing teams
   
   public Team(String teamName, int teamNumber, String coachName){
      this.teamName = teamName;
      this.teamNumber = teamNumber;
      this.coachName = coachName;
      //this.teamMemberList = teamMemberList;
      TeamList.addTeam(this);
   }


/*   public Team(){
      //teamList.add(new Member("Johnny", "11. juni 2004", true, false, false, true));
      //String name, String birthday, boolean isActiveMembership, boolean isJuniorMembership, boolean isCompetitiveSwimmer, boolean isMan
      teamList.add(Main.jens);
      //teamList.get(0).bestTimesList.add(new Result(500, "Crawl", 130));
   } 
   
   public void updateTeamList(){
      teamList.add(Main.jens);
   } */
   
   public void addResult(int memberNumber, int length, String swimmingStyle, int time){//, LocalDateTime date){//(ikke CompResult).
      Result result = new Result(length, swimmingStyle, time);//, date);//print Result.
      
      if (teamMemberList.get(memberNumber).bestTimesList.size() > 0){
         boolean addDiscipline = false;
         
         for(Result r : teamMemberList.get(memberNumber).bestTimesList){
            if (r.length == result.length && r.swimmingStyle.equalsIgnoreCase(result.swimmingStyle)){//compare disciplines. If same:
            //if (teamList.get(memberNumber).bestTimesList.contains(
               if(r.time > result.time){//comparing times. If new time < old time, new time is added. 
                  System.out.print("resultat opdateret: ");
                  result.printResult();
                  teamMemberList.get(memberNumber).bestTimesList.set(teamMemberList.get(memberNumber).bestTimesList.indexOf(r), result);//replace old time with new time.
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
      System.out.print("\nNy disciplin oprettet: ");
         result.printResult();
         teamMemberList.get(memberNumber).bestTimesList.add(result);
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

