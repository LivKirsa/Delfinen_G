import java.util.*;

public class AccList {
   static ArrayList <Member> subsList = new ArrayList<Member> ();
   
   static public void updateSubsList(){//update list whenever program starts.
   }
   
   static public void togglePaid(int memberNumber){//changes isPaid status for a specific member.
   Member member = MemberList.memberList.get(memberNumber);
   member.setIsPaid(true);
   }
   
    // Option to setPaid AND move the next due payment 1 year forward (When a member successfully pays for another year)
    public void setIsPaidYear(Member member){
      member.setIsPaid(true);
      member.nextPayment.plusYears(1);
    }
}