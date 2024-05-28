import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandling {
   File mFile = new File("Memberlist save file");
   File tFile = new File ("Teamlist save file");
   ArrayList <Member> list = new ArrayList <Member>();
   // Scanner scanner;
   
   public FileHandling(){
      createFile(mFile);
      createFile(tFile);
      //writeFile();
      //readFile();
   }
   
   public void createFile(File file){
      try {
         if (file.createNewFile()){
            System.out.println("File created");
         } 
      } catch(Exception e){
         System.out.println(e);
      }
   }
   
   public void writeFile(){
      writeMemberFile(MemberList.memberList);
      writeTeamFile(TeamList.teamList);
   }
   
   public void writeMemberFile(ArrayList <Member> list){
      Member[]arr = new Member[list.size()];
      list.toArray(arr);
      F.saveObject(arr, "Memberlist save file");
   }
   
   public void writeTeamFile(ArrayList <Team> list){
      Team[]arr = new Team[list.size()];
      list.toArray(arr);
      F.saveObject(arr, "Teamlist save file");
   }
   
   public void readFile(){
      Object mObj = F.loadObject("Memberlist save file");
      Object tObj = F.loadObject("Teamlist save file");
      readMemberList(mObj);
      readTeamList(tObj);
      //reconstructTeamLists();
   }
   
   public void readMemberList(Object obj){   
      if(obj instanceof Member[]){
         ArrayList<Member> tempArr = new ArrayList <Member> (Arrays.asList((Member[])obj));//ArrList temparr = obj cast as a list.
         MemberList.memberList = tempArr;//set MemberList.memberList to loaded array.
         System.out.println("Succesfully cast loaded object as ArrayList<Member>");
      } 
   }
   
   public void readTeamList(Object obj){
      if(obj instanceof Team[]){
         //System.out.println(TeamList.teamList);
         ArrayList<Team> tempArr = new ArrayList <Team> (Arrays.asList((Team[])obj));//ArrList temparr = obj cast as a list.
         TeamList.teamList = tempArr;
         System.out.println("Succesfully cast loaded object as ArrayList<Team>");
      }    
   }
   
   public void reconstructTeamLists(){
   System.out.println();
      for (Member m : MemberList.memberList){
         TeamList.autoAssignToTeam(m);
         //System.out.println(m.getName() + ", " + m.getAge() + ", aktiv:" + m.getIsActiveMembership() + ", comp:" + m.getIsCompetitiveSwimmer() + ", junior: " + m.getIsJuniorMembership());
      }
   }
}