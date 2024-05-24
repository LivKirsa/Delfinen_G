import java.time.LocalDateTime;
import java.io.Serializable;

public class Result implements Serializable{

   // Attributes
   int length; 
   String swimmingStyle; 
   int time;
   LocalDateTime Date;  
   int memberID;
   
   static String[] col = {"navn", "disciplin", "distance", "Tid"};
   
   // Constructor
   public Result(int length, String swimmingStyle, int time){//LocalDateTime date)
       this.length = length;
       this.swimmingStyle = swimmingStyle;
       this.time = time;
   }
   
   public String toString(){
      return (swimmingStyle  + ", " + length + "m: " + time + " sek");
   }
      
   public void printResult(){
      System.out.println(toString());
   }
   
   
   public String[] getResultInfoAsArray(){
      String name = "";
      for (Member m : MemberList.memberList){
         if (m.getMemberID() == memberID){
            name = m.getName();
            break;
         }
      }
      String[] row = {name, swimmingStyle, length + " m.", time + " sek"};
      return row;
   }
}