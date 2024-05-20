import java.time.LocalDate;
import java.io.Serializable;

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
      return (swimmingStyle  + ", " + length + "m: " + time + " sek. \nDate: " + date);
   }

   public void printResult(){
      System.out.println(toString());
   }
}  