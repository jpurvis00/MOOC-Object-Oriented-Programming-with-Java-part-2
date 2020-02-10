package clicker.applicationlogic;

public class PersonalCalculator implements Calculator {
    //Class attributes/instance variables
    private int value;

    //Class constructors
    public PersonalCalculator(){
        this.value = 0;  //Original value needs to be set to 0
    }

    //Class methods
    @Override
    /*Returns the value*/
    public int giveValue(){
        return this.value;
    }

    @Override
    /*Increases the value by 1*/
    public void increase(){
        this.value++;
    }

}
