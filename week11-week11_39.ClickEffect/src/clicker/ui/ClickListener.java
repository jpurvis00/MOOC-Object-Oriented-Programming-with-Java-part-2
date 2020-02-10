package clicker.ui;

import clicker.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
    //Object attributes/instance vars
    private Calculator calc;
    private JLabel valueLabel;

    //Object constructors
    public ClickListener(Calculator calc, JLabel valueLabel){
        this.calc = calc;
        this.valueLabel = valueLabel;
    }

    //Object methods
    @Override
    /*When the button is clicked, increase value and display the new value in the UI*/
    public void actionPerformed(ActionEvent ae){
        this.calc.increase();
        this.valueLabel.setText("" + this.calc.giveValue());
    }
}
