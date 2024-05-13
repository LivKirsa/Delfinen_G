import java.util.*;
import java.time.LocalDate;

public class AccList {
   static ArrayList <Member> subsList = new ArrayList<Member> ();
   
   static public void updateSubsList(){//update list whenever program starts.
   }
   
   // Method for renewing membership and setting isPaid = true
   public void setRenewed(int memberID){
      MemberList.memberList.get(memberID).renewMembership();
   }
}