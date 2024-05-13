import java.time.LocalDateTime;

public class CompResult extends Result{
   String location;
   
   public CompResult(int distance, String swimmingStyle, int timeSec, LocalDateTime date, String location){
      super(distance, swimmingStyle, timeSec, date);
   }
   
}