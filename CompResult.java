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
   
   @Override
   public String[] getResultInfoAsArray(){
      String [] superRow = super.getResultInfoAsArray();
      String [] row = new String [superRow.length + 1];
      for (int i = 0; i < superRow.length; i++){
         row[i] = superRow[i];
      }
      row[superRow.length] = location;
      return row;
   }
}