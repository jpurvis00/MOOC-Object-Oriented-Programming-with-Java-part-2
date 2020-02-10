package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new PersonalCalculator());
        SwingUtilities.invokeLater(ui);

        /*Just testing out the PersonalCalcuator class*/
        /*Calculator calc = new PersonalCalculator();
        System.out.println("Value: " + calc.giveValue());
        calc.increase();
        System.out.println("Value: " + calc.giveValue());
        calc.increase();
        System.out.println("Value: " + calc.giveValue());*/
    }

    /*Flow of the following program.
    * 1. Create a new PersonalCalculator object
    * 2. Create a new UserInterface object and pass it the PersonalCalculator object
    * 3. Create new UserInterface JFrame and all components
    * 4. Part of step 3 is creating a clickable button.
    * 5. Create a new ClickListener object and pass it the PersonalCalculator object and the JLabel countTxt
    * 6. Tie the new ClickListener object to the button.  The ClickLIstener class implemenets ActionListener
    *       This allows the button to perform actions once it is clicked.
    * 7. When the button is clicked, the ClickListener class increments the display value and sets the new value
    *       JLabel text.*/
}
