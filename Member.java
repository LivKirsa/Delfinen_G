import java.time.LocalDate;
import java.util.ArrayList;

public class Member{

    // Attributes for each Member
    private String name;
    private int age;
    private LocalDate birthday;
    private int memberID;
    private LocalDate registrationDate;
    private boolean isPaid;
    private boolean isActiveMembership;
    private boolean isJuniorMembership;
    private boolean isCompetitiveSwimmer;
    private boolean isMan;
    private int counter = 1;
    
    static ArrayList <Result> bestTimesList = new ArrayList <Result>();
    
    // Constructor for Member Objects
    
    public Member(String name, String birthday, boolean isActiveMembership, boolean isJuniorMembership, boolean isCompetitiveSwimmer, boolean isMan){
        this.name = name;
        this.age = 0; // Calculate age based on birthday
        this.birthday = LocalDate.parse(birthday);
        this.memberID = counter; //Assign memberIDs
        this.registrationDate = LocalDate.now();
        this.isPaid = true;
        this.isActiveMembership = isActiveMembership;
        this.isJuniorMembership = isJuniorMembership;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
        this.isMan = isMan;
        counter++;
    }
    
    // Method for printing Member
    public void printMember(){
      System.out.println("(" + memberID + ") " +
      name + "\n Fødselsdag: " + birthday + "\n Aktivt medlemskab?: " + 
      isActiveMembership + "\n Junior medlemskab?: " + isJuniorMembership + 
      "\n Konkurrencesvømmer?: " + isCompetitiveSwimmer + "\n Mand?: " + isMan + 
      "\n Har betalt?: " + isPaid + "\n Næste betalingsdato: " + registrationDate);
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
    
    // Setter for age not relevant, as age is calculated elsewhere
    
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

    // Getter for isJuniorMembership
    public boolean getIsJuniorMembership(){
        return isJuniorMembership;
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
}