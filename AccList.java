import java.util.*;

public class AccList {
   static ArrayList <Member> unpaidSubsList = new ArrayList<Member> ();

   // Method for renewing membership and setting isPaid = true
   public static void setRenewed(int memberID){
      MemberList.memberList.get(memberID).renewMembership();
   }
}