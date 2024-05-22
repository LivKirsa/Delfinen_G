import java.util.*;
import java.time.LocalDate;

public class AccList {
   static ArrayList <Member> subsList = new ArrayList<Member> ();
   
   static public void updateSubsList(){// Update list whenever program starts.
   }
   
   // Method for renewing membership and setting isPaid = true
   public static void setRenewed(int memberID){
      MemberList.memberList.get(memberID).renewMembership();
   }
}