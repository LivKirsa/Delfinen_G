import java.util.ArrayList;
import java.io.Serializable;

public class MemberList implements Serializable {
   static ArrayList <Member> memberList = new ArrayList <Member>();
   static int counter = 1; // Counter for assigning memberID
   static public void updateMemberList(){
   }
   
   // Method for adding members to memberList
   static public void addMember(Member member){ // Takes a Member Object input and adds it to the memberList ArrayList
      memberList.add(member);
      updateMemberList();
   }
   
   // Method for printing memberList
   public static void printMemberList(){
      System.out.println("Member List: \n");
      for (Member member : memberList){
         member.printMember();
      }
   }
}