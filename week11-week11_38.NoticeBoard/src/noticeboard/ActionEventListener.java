package noticeboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventListener implements ActionListener {
    //Object attributes/instance vars
    private JTextField origin;
    private JLabel destination;

    //Object constructors
    public ActionEventListener(JTextField inputTxtField, JLabel copyTxtField){
        this.origin = inputTxtField;
        this.destination = copyTxtField;
    }

    //Object methods
    @Override
    public void actionPerformed(ActionEvent ae){
        this.destination.setText(this.origin.getText());
        this.origin.setText("");
    }
}
