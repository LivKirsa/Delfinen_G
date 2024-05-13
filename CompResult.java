import java.time.LocalDateTime;

public class CompResult extends Result{
   String location;
   
   public CompResult(int distance, String style, int timeSec, String location){//LocalDateTime date, String location){
      super(distance, style, timeSec);//date);
      this.location = location;
   }
   
}