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
      System.out.println(swimmingStyle  + ", " + length + "m: " + time + " . Sted: " + location + ". Placering: " + placement);
   }
   
   @Override
   public Object[] getResultInfoAsArray(){
      Object [] superRow = super.getResultInfoAsArray();//temp array from super class.
      Object [] row = new String [superRow.length + 2];
      for (int i = 0; i < superRow.length; i++){//adding old items to new array.
         row[i] = superRow[i];
      }
      row[row.length - 2] = location;
      row[row.length - 1] = placement;
      
      return row;
   }
}