import java.util.Scanner;

public class TextUserInterface {
    //Object attributes/vars
    private Scanner userInput;
    private Airport jfk;

    //Object constructors
    public TextUserInterface(Scanner reader){
        this.userInput = reader;
        this.jfk = new Airport();
    }

    //Object methods
    public void start(){
        airportPanel();
        flightServicePanel();
    }

    //Display Airport Panel
    private void airportPanel(){
        System.out.println("Airport panel\n" +
                "--------------------\n");
        handleAirportPanelInput();
    }

    //Display menu and call appropriate methods for menu choice
    private void handleAirportPanelInput(){
        //Do loop until x has been entered
        while(true) {
            System.out.println("Choose operation:\n" +
                    "[1] Add airplane\n" +
                    "[2] Add flight\n" +
                    "[x] Exit");
            System.out.print("> ");

            //Change input to lowercase and remove leading/trailing whitespaces
            String userChoice = cleanTextInput(this.userInput.nextLine());

            if(userChoice.equals("x"))
                break;
            else if(userChoice.equals("1")) {
                addAirplane();
            }
            else if(userChoice.equals("2"))
                addFlight();
            else
                System.out.println("Option not found!");
        }
    }

    private void addFlight(){
        System.out.print("Give plane ID: ");
        String id = this.userInput.nextLine();

        System.out.print("Give departure airport code: ");
        String depCity = this.userInput.nextLine();

        System.out.print("Give destination airport code: ");
        String destCity = this.userInput.nextLine();

        Flights flightInfo = new Flights(id, depCity, destCity);
        jfk.addFlights(flightInfo);
    }

    //Adds a plain id and passenger capacity to the Airplanes object hashmap
    private void addAirplane(){
        System.out.print("Give plane ID: ");
        String id = this.userInput.nextLine();

        System.out.print("Give plane capacity: ");
        int cap = Integer.parseInt(this.userInput.nextLine());

        Airplanes planeInfo = new Airplanes(id, cap);
        jfk.addPlanes(id, planeInfo);
    }

    //Display Flight Service Panel
    private void flightServicePanel(){
        System.out.println("\nFlight service\n" +
                "------------\n");
        handleFlightServiceInput();
    }

    //Display menu and call appropriate methods for menu choice
    private void handleFlightServiceInput(){
        while(true) {
            System.out.println("Choose operation:\n" +
                    "[1] Print planes\n" +
                    "[2] Print flights\n" +
                    "[3] Print plane info\n" +
                    "[x] Quit");
            System.out.print("> ");

            //Change input to lowercase and remove leading/trailing whitespaces
            String userChoice = cleanTextInput(this.userInput.nextLine());

            if (userChoice.equals("x"))
                break;
            else if(userChoice.equals("1"))
                printAllPlanes();
            else if(userChoice.equals("2"))
                printAllFlights();
            else if(userChoice.equals("3"))
                printPlaneInfo();
            else
                System.out.println("Option not found!");
        }
    }

    //Prints a specified planes information.
    private void printPlaneInfo(){
        System.out.print("Give plane ID: ");
        String id = this.userInput.nextLine();

        System.out.println(jfk.getPlaneInfo(id));
    }

    //Prints all flight details for the planes
    private void printAllFlights(){
        jfk.getFlights();
    }

    //Prints all planes that have been entered by the user
    private void printAllPlanes(){
        jfk.getPlanes();
    }

    //Converts a string to lower case and removes and leading/trailing whitespaces.
    private String cleanTextInput(String choice){
        return choice.toLowerCase().trim();
    }
}
