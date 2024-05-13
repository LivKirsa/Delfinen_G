import java.time.LocalDateTime;

public class Result{

   //Atributer
   int length; 
   String swimmingStyle; 
   int time;
   LocalDateTime Date;  
   
   // Constructor
   public Result(int length, String swimmingStyle, int time){//LocalDateTime date) {
       this.length = length;
       this.swimmingStyle = swimmingStyle;
       this.time = time;
   }
   
   public void printResult(){
      System.out.println(swimmingStyle  + ", " + length + "m: " + time + " sek");
   }
   }