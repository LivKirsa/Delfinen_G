import java.time.LocalDate;
import java.io.Serializable;
import java.time.Duration;

public class Result implements Serializable{

   // Attributes for Results
   int length; 
   String swimmingStyle; 
   Duration time;
   LocalDate date;
   int memberID;
   
   // Constructor for Result Objects
   public Result(int length, String swimmingStyle, int m, int s, int ms){
   
       this.length = length;
       this.swimmingStyle = swimmingStyle;
       this.time = createDuration(m, s, ms);
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