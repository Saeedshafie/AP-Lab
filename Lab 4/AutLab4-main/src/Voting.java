import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ir.huri.jcal.JalaliCalendar;

public class Voting {
    //type of voting
    private int type;
    //question of voting
    private String question;
    //list of voters
    private ArrayList<Person> voters;
    //list of vote for each choice
    private HashSet<Vote> votes;
    //choices to vote
    private HashMap<String, HashSet<Vote>> Choices;
    private JalaliCalendar jalaliCalendar;

    /**
     * create voting
     *
     * @param type     type of voting
     * @param question question of voting
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        Choices = new HashMap<String, HashSet<Vote>>();
        jalaliCalendar = new JalaliCalendar();
    }

    /**
     * @return question of voting
     */
    public String getQuestion() {
        return question;
    }

    /**
     * add a choice to voting
     *
     * @param choice is a choice
     */
    public void createChoice(String choice) {
        votes = new HashSet<Vote>();
        Choices.put(choice, votes);
    }

    /**
     * vote to choices
     * @param person person who votes
     * @param votes his choices
     */
    public void vote(Person person, ArrayList<String> votes){
        if (type == 0){
            if(votes.size() != 1){
                System.out.println("you have one choice!");
                return;
            }
        }
        for (Person person1 : voters){
            if (person1.equals(person)){
                System.out.println("You can vote once");
                return;
            }
        }
        String date= jalaliCalendar.toString();
        Vote vote = new Vote(person,date);
        voters.add(person);
        for (String s : votes){
            for (String choice : Choices.keySet()){
                if(s.equals(choice)){
                    Choices.get(choice).add(vote);
                }
            }
        }
    }
    /**
     * display voters
     */
    public void getVoters(){
        for (Person person : voters){
            System.out.println(person.toString());
        }
    }
    /**
     * @return choices of a voting
     */
    public ArrayList<String> getChoices(){
        ArrayList<String> choices = new ArrayList<String>();
        for (String s : Choices.keySet()){
            choices.add(s);
        }
        return choices;
    }

    /**
     * result of voting
     */
    public void printVotes(){
        for (String s : Choices.keySet()){
            int size =  Choices.get(s).size();
            System.out.println(s + " : " + size);
        }
    }
}