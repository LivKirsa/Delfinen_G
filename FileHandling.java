import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandling {
   File mFile = new File("Memberlist save file");
   File tFile = new File ("Teamlist save file");
   
   ArrayList <Member> list = new ArrayList <Member>();
   //Scanner scanner;
   
   public FileHandling(){
      createFile(mFile);
      createFile(tFile);
      
      //writeMemberFile();
      //readFile("Save File");
   }
   
   public void createFile(File file){
      try{
         if (file.createNewFile()) System.out.println("File created");
             
      }catch(Exception e){
         System.out.println(e);
      }
   }
   
   public void writeMemberFile(){
      Member[]arr = new Member[MemberList.memberList.size()];//idunno .toArray() shoud work, but it doesnt.
      for (int i = 0; i < arr.length; i++){
         arr[i] = MemberList.memberList.get(0);
         MemberList.memberList.remove(0);
      }
      F.saveObject(arr, "Memberlist save file");
   }
   
   public void readFile(String fileName){
      Object obj = F.loadObject(fileName);
      
      if(obj instanceof Member[]){
         ArrayList<Member> tempArr = new ArrayList <Member> (Arrays.asList((Member[])obj));//ArrList temparr = obj cast as a list.
         MemberList.memberList = tempArr;
         //list.addAll(tempArr);
         
         System.out.println("Succesfully cast loaded object as ArrayList<Member>");
         reconstructTeamLists(); 
      }else if(obj instanceof Team[]){
         ArrayList<Team> tempArr = new ArrayList <Team> (Arrays.asList((Team[])obj));//ArrList temparr = obj cast as a list.
         TeamList.teamList = tempArr;
         System.out.println("Succesfully cast loaded object as ArrayList<Team>");
      }    
   }
   
   public void reconstructTeamLists(){
   System.out.println();
      for (Member m : MemberList.memberList){
         System.out.print("Hold: " + TeamList.autoAssignToTeam(m) + ", ");
         System.out.println(m.getName() + ", " + m.getAge() + ", aktiv:" + m.getIsActiveMembership() + ", comp:" + m.getIsCompetitiveSwimmer() + ", junior: " + m.getIsJuniorMembership());
      }
   }
}