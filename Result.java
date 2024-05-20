import java.time.LocalDate;
import java.time.Duration;

public class Result{

   // Attributes
   int length; 
   String swimmingStyle; 
   int time;
   LocalDate date;  
   int member;
   
   // Constructor
   public Result(int length, String swimmingStyle, int time){
       this.length = length;
       this.swimmingStyle = swimmingStyle;
       this.time = time;
       this.date = LocalDate.now();
   }
   
   public void printResult(){
      System.out.println("Date: " + date.toString() + "\n" + swimmingStyle  + ", " + length + "m: " + time + " sek");
   }
   
   public static Duration createDuration(int m, int s, int ms){ // Takes 3 integer inputs and creates a Duration Object
      return Duration.ofMinutes(m).plusSeconds(s).plusMillis(ms);
   }
}