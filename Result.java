import java.time.LocalDateTime;

<<<<<<<< HEAD:Result.java
public class Result{
========
public class CompResult{
>>>>>>>> 17c713466586a8e4f803098173d01148283e5e2c:CompResult.java

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