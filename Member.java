import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.io.Serializable;

public class Member implements Serializable{

    // Attributes for each Member
    private String name;
    private int age;
    private LocalDate birthday;
    private int memberID;
    private static LocalDate registrationDate;
    private static LocalDate nextPayment;
    private boolean isPaid;
    private boolean isActiveMembership;
    private boolean isJuniorMembership;
    private boolean isCompetitiveSwimmer;
    private boolean isMan;
    private static int counter = 1; // Counter for assigning memberID
    private LocalDate now = LocalDate.now();
    private int teamNumber;
    ArrayList<Result> bestTimesList = new ArrayList<Result>();
    
    // Constructor for Member Objects
    public Member(String name, String birthday, boolean isActiveMembership, boolean isCompetitiveSwimmer, boolean isMan){
        this.name = name;
        this.age = calculateAge(LocalDate.parse(birthday), now);
        this.birthday = LocalDate.parse(birthday);
        this.memberID = counter; //Assign memberIDs to next int 
            counter++;
        this.registrationDate = LocalDate.now();
        this.nextPayment = LocalDate.now().plusYears(1);
        this.isPaid = true; // Assumes that no new member is created before they have paid for membership
        this.isActiveMembership = isActiveMembership;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
        this.isJuniorMembership = getIsJuniorMembership(this);
        this.isMan = isMan;
        MemberList.addMember(this); // Adds the new Member to memberList automatically
        this.teamNumber = TeamList.autoAssignToTeam(this); // Automatically adds the new Member to the appropriate team  
    }
    
    // Method for printing Member
    public void printMember(){
      System.out.println("(" + memberID + ") " +
      name + "\n Age: " + age + "\n Birthday: " + birthday + "\n Active Membership?: " + 
      isActiveMembership + "\n Junior Membership?: " + isJuniorMembership + 
      "\n Competitive Swimmer?: " + isCompetitiveSwimmer + "\n Man?: " + isMan + 
      "\n Paid?: " + isPaid + "\n Next payment due: " + nextPayment);
      }
      
      // Method for printing memberName
      public void printMemberName(){
         System.out.println(name);
      }
    
    // Getter for name
    public String getName(){
        return name;
    }
   
    // Setter for name
    public void setName(String name){
        this.name = name;
    }
    
   // Getter for age
    public int getAge(){
        return age;
    }
    
    // Calculator for age
    public int calculateAge(LocalDate birthday, LocalDate now){
    Period period = Period.between(birthday, now);
      return period.getYears();
   }
    
    // Getter for birthday
    public LocalDate getBirthday(){
        return birthday;
    }
    
    // Setter for birthday
    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }
    
    // Getter for memberID
    public int getMemberID(){
        return memberID;
    }
    
    // Setter for memberID not relevant, as memberID is calculated elsewhere
    
    // Getter for registrationDate
    public LocalDate getRegistrationDate(){
        return registrationDate;
    }
    
    // Setter for registrationDate not relevant, as registrationDate is calculated automatically
    
    // Getter for isPaid
    public boolean getIsPaid(){
        return isPaid;
    }
    
    // Setter for isPaid
    public void setIsPaid(boolean isPaid){
        this.isPaid = isPaid;
    }
    
    // Getter for isActiveMembership
    public boolean getIsActiveMembership(){
        return isActiveMembership;
    }
    
    // Setter for isActiveMembership
    public void setIsActiveMembership(boolean isActiveMembership){
        this.isActiveMembership = isActiveMembership;
    }

    // Getter/calculator for isJuniorMembership
    public boolean getIsJuniorMembership(Member member){
      int age = member.getAge();
      if (age <18 && isCompetitiveSwimmer == true){
         return  true;
      } else {
        return false;
      }
    }
    
    // Setter for isJuniorMembership
    public void setIsJuniorMembership(boolean isJuniorMembership){
        this.isJuniorMembership = isJuniorMembership;
    }
    
    // Getter for isCompetitiveSwimmer
    public boolean getIsCompetitiveSwimmer(){
        return isCompetitiveSwimmer;
    }
    
    // Setter for isActiveMembership
    public void setIsCompetitiveSwimmer(boolean isCompetitiveSwimmer){
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
    }
    
    // Getter for isMan
    public boolean getIsMan(){
      return isMan;
    }
    
    // Setter for isMan
    public void setIsMan(boolean isMan){
      this.isMan = isMan;
    }
    
    // Getter for nextPayment
    public LocalDate getNextPayment(){
      return nextPayment;
    }
    
    // Method to renew membership
    public void renewMembership() {
    this.isPaid = true;
    this.nextPayment = this.nextPayment.plusYears(1);
    }

    public void printBestTimesList(){
      System.out.println("\nBedste tider for " + name + ":");
       for (Result r: bestTimesList){

            r.printResult();

       }//end of for loop.
    }
    
}