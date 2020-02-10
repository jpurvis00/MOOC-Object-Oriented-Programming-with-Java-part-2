import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
    //Object attributes/instance vars
    private PersonalCalculator calc;
    private JTextField finalValue;
    private JTextField inputNum;
    private JButton resetBtn;

    //Object constructors
    public ClickListener(PersonalCalculator calc, JTextField val, JTextField num, JButton reset){
        this.calc = calc;
        this.finalValue = val;
        this.inputNum = num;
        this.resetBtn = reset;
        this.resetBtn.setEnabled(false); //Our button should initially be disabled bc the value is 0.
                                         //Should only be able to hit the reset btn if value > 0.
    }

    //Object methods
    /*Gui has 3 buttons.  Perform the following actions depending on which button has been clicked.*/
    @Override
    public void actionPerformed(ActionEvent ae){
        /*Add btn has been clicked.  If an integer has been inputted, add the numbers.  If not an integer,
        * leave the value as is.*/
        if(ae.getActionCommand().equals("+")){
            if(this.calc.add(this.inputNum))
                this.finalValue.setText("" + this.calc.getValue());

            this.resetBtn.setEnabled(enableReset());
            this.inputNum.setText("");
        }
        /*Subtract btn has been clicked.  If an integer has been inputted, subtract the numbers.
         * If not an integer, leave the value as is.*/
        else if(ae.getActionCommand().equals("-")){
            if(this.calc.subtract(this.inputNum))
                this.finalValue.setText("" + this.calc.getValue());

            this.resetBtn.setEnabled(enableReset());
            this.inputNum.setText("");
        }
        /*Reset btn has been clicked.  Reset the final value to 0.  Clear the input # and disable the btn.*/
        else if(ae.getActionCommand().equals("Z")){
            this.calc.reset();
            this.finalValue.setText("" + this.calc.getValue());
            this.resetBtn.setEnabled(enableReset());
            this.inputNum.setText("");
        }
    }

    /*Checks to see if our calculator final value is 0.  Return false if 0, true if not 0.  False will
    * allow us to set the reset btn to not be clickable and vice versa.*/
    private boolean enableReset(){
        if(this.calc.getValue() == 0)
            return false;

        return true;
    }
}
