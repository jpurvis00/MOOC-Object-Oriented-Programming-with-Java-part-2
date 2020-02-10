import javax.swing.*;

public class PersonalCalculator implements Calculator {
    //Object attributes/instance vars
    private int value;

    //Object constructors
    public PersonalCalculator(){
        this.value = 0;
    }

    //Object methods
    /*Return calculator value*/
    @Override
    public int getValue(){
        return this.value;
    }

    /*Adds two numbers together.  Returns true if the entered # is an integer.*/
    @Override
    public boolean add(JTextField num){
        try {
            this.value += Integer.parseInt(num.getText());
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /*subtracts two numbers.  Returns true if the entered # is an integer.*/
    @Override
    public boolean subtract(JTextField num){
        try {
            this.value -= Integer.parseInt(num.getText());
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    /*Resets calcualtor value to 0.*/
    @Override
    public void reset(){
        this.value = 0;
    }
}
