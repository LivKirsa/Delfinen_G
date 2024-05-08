import java.time.LocalDateTime;
import java.util.ArrayList;

public class Member{

    // Attributes for each Member
    private String name;
    private int age;
    private LocalDateTime birthday;
    private int memberID;
    private LocalDateTime registrationDate;
    private boolean isPaid;
    private boolean isActiveMembership;
    private boolean isJuniorMembership;
    private boolean isCompetitiveSwimmer;
    
    static ArrayList <Result> bestTimesList = new ArrayList <Result>();
    
    // Constructor for Member Objects
    
    public Member(String name, LocalDateTime birthday, boolean isActiveMembership, boolean isJuniorMembership, boolean isCompetitiveSwimmer){
        this.name = name;
        this.age = 0; // Calculate age based on birthday
        this.birthday = birthday;
        this.memberID = 0; //Assign memberIDs somehow
        this.registrationDate = LocalDateTime.now();
        this.isPaid = true;
        this.isActiveMembership = isActiveMembership;
        this.isJuniorMembership = isJuniorMembership;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
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
    public LocalDateTime getBirthday(){
        return birthday;
    }
    
    // Setter for birthday
    public void setBirthday(LocalDateTime birthday){
        this.birthday = birthday;
    }
    
    // Getter for memberID
    public int getMemberID(){
        return memberID;
    }
    
    // Setter for memberID not relevant, as memberID is calculated elsewhere
    
    // Getter for registrationDate
    public LocalDateTime getRegistrationDate(){
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
}