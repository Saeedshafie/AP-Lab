/**
 * a person who votes
 */
public class Person {
    //voters first name
    private String firstName;
    // voters last name
    private String lastName;

    /**
     * initialize firstname and lastname
     * @param firstName voters firstname
     * @param lastName voters lastname
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * a getter method returns voters firstname
     * @return voters firstname
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * a getter method returns voters lastname
     * @return voters lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return voters name
     */
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}