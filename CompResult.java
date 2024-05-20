import java.time.LocalDateTime;
import java.io.Serializable;

public class CompResult extends Result implements Serializable{
   String location;
   
   public CompResult(int distance, String style, int timeSec, String location){//LocalDateTime date, String location){
      super(distance, style, timeSec);//date);
      this.location = location;
   }
   
   @Override
   public void printResult(){
      System.out.println(swimmingStyle  + ", " + length + "m: " + time + " sek, " + location);
   }
   
}