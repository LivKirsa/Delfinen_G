import java.util.ArrayList;

public class MemberList {
   static ArrayList <Member> memberList = new ArrayList <Member>();
   
   static public void updateMemberList(){
   }
   
   // Method for adding members to memberList
   static public void addMember(Member member){ // Takes a Member Object input and adds it to the memberList ArrayList
      memberList.add(member);
      updateMemberList();
   }
   
   // Method for printing memberList to console (For Liv's brain :))) )
   public static void printMemberList(){
      System.out.println("Member List: \n");
      for (Member member : memberList){
         member.printMember();
      }
   }
}