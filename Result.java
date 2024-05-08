import java.time.LocalDateTime;

public class Result{

   //Atributer
   int length; 
   String swimmingStyle; 
   int time;
   LocalDateTime Date;
   String location;  
   
   public Result(int length, String swimmingStyle, int time, LocalDateTime date, String location) {
    this.length = length;
    this.swimmingStyle = swimmingStyle;
    this.time = time;
    this.date = date;
    this.location = location;
   
      }
   
}