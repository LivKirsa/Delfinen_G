import java.time.LocalDateTime;

public class CompResult extends Result{
   String location;
   
   public CompResult(int distance, String style, int timeSec, LocalDateTime date, String location){
      super(distance, style, timeSec, date);
   }
   
}