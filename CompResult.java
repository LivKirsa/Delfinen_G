import java.time.LocalDateTime;
import java.io.Serializable;

public class CompResult extends Result implements Serializable{
   String location;
   int placement;
   
   // Constructor for CompResult
   public CompResult(int length, String swimmingStyle, int m, int s, int ms, String location, int placement){
      super(length, swimmingStyle, m, s, ms);
      this.location = location;
      this.placement = placement;
   }
   
   @Override
   public void printResult(){
      System.out.println(swimmingStyle  + ", " + length + "m: " + time + " sek, " + location + ". Placement: " + placement);
   }
   
}