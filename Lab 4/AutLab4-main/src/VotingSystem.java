import java.util.ArrayList;
/**
 * create a voting System
 */
public class VotingSystem {
    //list of voting
    private ArrayList<Voting> votingList;

    /**
     * create list of voting
     */
    public VotingSystem(){
        votingList = new ArrayList<Voting>();
    }

    /**
     * create a voting
     * @param question question of voting
     * @param type type of voting
     * @param choices chocies of voting
     */
    public void createVoting(String question, int type, ArrayList<String> choices){

        Voting voting = new Voting(type, question);
        votingList.add(voting);
        for (String s : choices){
            voting.createChoice(s);
        }
    }

    /**
     * prints votings questions
     */
    public void printVotingQuestion(){
        for (Voting voting : votingList){
            System.out.println(voting.getQuestion());
        }
    }

    /**
     * print question of voting and its choices
     * @param index index of voting in list
     */
    public void printVoting(int index){
        System.out.println(votingList.get(index).getQuestion());
        ArrayList<String> choices = new ArrayList<String>();
        choices = votingList.get(index).getChoices();
        for (String s : choices){
            System.out.println(s);
        }
    }

    /**
     * a person vote in chosen voting
     * @param index index of voting
     * @param person person who votes
     * @param votes his choices
     */
    public void vote(int index,Person person,ArrayList<String> votes){
        votingList.get(index).vote(person,votes);
    }

    /**
     * print result of voting
     * @param index index of voting in the list
     */
    public void printResults(int index){
        votingList.get(index).printVotes();
    }

    /**
     * @return list of votings
     */
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }
}