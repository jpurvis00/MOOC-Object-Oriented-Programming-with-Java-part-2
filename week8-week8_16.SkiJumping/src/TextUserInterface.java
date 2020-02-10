import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class TextUserInterface {
    //Object attributes/vars
    private Scanner userInput;
    private List<Athlete> athleteList;

    //Object constructors
    public TextUserInterface(Scanner reader){
        this.userInput = reader;
        this.athleteList = new ArrayList<Athlete>();
    }

    //Object methods
    //Run program
    public void start(){
        getAthletes();
        startComp();
        printFinalResults();
    }

    //Prints the final results of the tournament in order of the athletes with the most points.
    private void printFinalResults(){
        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");

        int pos = 1;
        Collections.sort(this.athleteList);  //sort the list of athletes by points.  This sort is from lowest to highest
        Collections.reverse(this.athleteList);  //Reverse the prev sort so that we display the athlete with the most points first

        //Go through each athlete in the arrayList
        for(Athlete athlete : this.athleteList){
            //Get the Points object in the athletes hashMap.  This is done so we can now access the Points class methods
            Points points = athlete.getPointsObject(athlete.getName());

            System.out.println(pos + "           " + athlete + " " + points + "\n            jump lengths: " + points.getAllLengths());
            pos++;
        }
    }

    /*Starts the tournament after all jumpers have been inputted.  We will start a loop that performs 1 round
    of the tournament each time through.  This will determine jumpers order for the round.  Creates the length
    of the jump and the stylepoints from the judges and displays the results for each round.
     */
    private void startComp(){
        int round = 1;

        System.out.println("");
        System.out.println("The tournament begins!");

        while(true){
            System.out.println("");
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");

            String input = userInput.nextLine();

            if(input.equals("quit"))
                break;

            System.out.println("");
            System.out.println("Round " + round);

            jumpingOrder();

            setRoundResults();

            displayResults(round);

            round++;
        }
    }

    //Creates the length, judges votes and calculates the points for the round for each athlete
    private void setRoundResults(){
        //Go through each athlete in the arrayList
        for(Athlete athlete : this.athleteList){
            //Get the Points object from the Athlete hashMap so we can access the methods in the Points class
            Points points = athlete.getPointsObject(athlete.getName());

            points.setLength();

            points.setVotes();

            points.calcRoundPoints();
        }
    }

    /*Displays the results of the current round*/
    private void displayResults(int round){
        System.out.println("");
        System.out.println("Results of round " + round);

        //Go through each athlete in the arrayList
        for(Athlete athlete : this.athleteList){
            //Get the Points object from the Athlete hashMap so we can access the methods in the Points class
            Points points = athlete.getPointsObject(athlete.getName());

            System.out.println("  " + athlete.getName() + "\n    " + "length: " + points.getLength() +
                    "\n    judge votes: " + points.getVotes());
        }
    }

    /*Determines the jumping order of the athletes by sorting the arrayList by total points values.  It
    is sorted from least to most points
    */
    private void jumpingOrder(){
        System.out.println("");
        System.out.println("Jumping order:");

        //Sort the arrayList
        Collections.sort(this.athleteList);

        int order = 1;
        //Go through each athlete in the arrayList
        for(Athlete athlete : this.athleteList){
            //Get the Points object from the Athlete hashMap so we can access the methods in the Points class
            Points points = athlete.getPointsObject(athlete.getName());

            System.out.println("  " + order + ". " + athlete + " " + points);
            order++;
        }
    }

    /*
    Creates a loop for the user to input the tournament participants names.  It then creates a new Athlete
    object and adds it to an arrayList in the class
     */
    private void getAthletes(){
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        while(true){
            System.out.print("  Participant name: ");

            String athleteName = this.userInput.nextLine();

            if(athleteName.isEmpty())
                break;

            this.athleteList.add(new Athlete(athleteName, new Points()));
        }
    }
}