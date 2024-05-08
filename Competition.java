import java.time.LocalDateTime;

public class Competition{

   //Atributer
   int length; 
   String swimmingStyle; 
   int time;
   LocalDateTime Date;
   String location;  
   
   public Competition(int length, String swimmingStyle, int time, LocalDateTime date, String location) {
    this.length = length;
    this.swimmingStyle = swimmingStyle;
    this.time = time;
    this.date = date;
    this.location = location;
   
      }
   
}