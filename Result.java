import java.time.LocalDate;
import java.io.Serializable;
import java.time.Duration;

public class Result implements Serializable{

   // Attributes
   int length; 
   String swimmingStyle; 
   int time;
   LocalDate date;
   int memberID;
   
   // Constructor
   public Result(int length, String swimmingStyle, int time){
       this.length = length;
       this.swimmingStyle = swimmingStyle;
       this.time = time;
       this.date = LocalDate.now();
   }
   
   public String toString(){
      return (swimmingStyle  + ", " + length + "m\n Time: " + time + ". \nDate: " + date);
   }

   public void printResult(){
      System.out.println(toString());
   }
   
   // Method for converting 3 int inputs Minutes(m), Seconds(s), Milliseconds(ms) into a Duration Object
   public static Duration createDuration(int m, int s, int ms){ 
      return Duration.ofMinutes(m).plusSeconds(s).plusMillis(ms);
   }
      
}  