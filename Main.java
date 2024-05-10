public class Main{
   
   public static void main (String [] args){
   
   Member jens = new Member("Jens Jensen", "1999-08-20", true, true, true, true);
   Member grete = new Member("Grete Gregersen", "1800-05-13", false, false, false, false);
   jens.printMember();
   grete.printMember();

   
   TeamList.team1.printTeam();
   TeamList.team3.printTeam();
   }
}