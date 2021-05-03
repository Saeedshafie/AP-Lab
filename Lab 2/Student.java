import jdk.swing.interop.SwingInterOpUtils;

public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int grade;
    public Student(String fName, String lName, String sId){ ;
            firstName = fName;
            lastName = lName;
            id = sId;
            grade = 0;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String fName) {
        firstName = fName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lName){
        lastName = lName;
    }
    public int getGrade(){
        return grade;
    }
    public void setGrade(int nGrade){
        grade = nGrade;
    }
    public String getId(){
        return id;
    }
    public void setId(String nId){
        if(nId.length() == 7){
            id = nId;
        }
    }
    public void print(){
        System.out.println("Name : " + firstName + lastName + " , Grade = " + grade);
    }
}

