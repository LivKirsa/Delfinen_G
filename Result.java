import java.time.LocalDateTime;
import java.io.Serializable;

public class Result implements Serializable{

   // Attributes
   int length; 
   String swimmingStyle; 
   int time;
   LocalDateTime Date;  
   int member;
   
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
}