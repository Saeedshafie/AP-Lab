import ir.huri.jcal.JalaliCalendar;

public class Vote {
    private Person person;
    private String date;
    /**
     * initialize person and date
     * @param person person field
     * @param date date field
     */
    public Vote(Person person, String date){
        this.person = person;
        this.date =date;
    }
    /**
     * returns voter
     * @return person who votes
     */
    public Person getPerson(){
        return person;
    }
    /**
     * returns date
     * @return date of voting
     */
    public String getDate(){
        return date;
    }
    /**
     * equality of two object
     * @param object is a person
     * @return true if equal
     */
    public boolean equals(Object object){
        if (person.equals(object)){
            return true;
        }
        else
            return false;
    }
}
