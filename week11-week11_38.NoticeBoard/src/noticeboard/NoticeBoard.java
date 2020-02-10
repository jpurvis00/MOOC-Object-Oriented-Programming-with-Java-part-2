package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        /*Create the graphical interface frame*/
        this.frame = new JFrame("Copy");

        /*Give graphical interface a size*/
        this.frame.setPreferredSize(new Dimension(500, 300));

        /*Tells interface to close when the X is hit*/
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*Calls method to create contens of graphical interface*/
        createComponents(this.frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
    }

    /*Creates all contents of the UI*/
    private void createComponents(Container container) {
        /*Uses grid layout with 3 rows and 1 column*/
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        /*Create a text field, label field and a button*/
        JTextField inputTxtField = new JTextField();
        JLabel copyTxtField = new JLabel();
        JButton copyBtn = new JButton("Copy!");

        /*Create a new ActionEventListenter object by passing it the text field and the label field*/
        ActionEventListener copier = new ActionEventListener(inputTxtField, copyTxtField);

        /*Add the listenter to the button so that when it's clicked, it calls the actionPerformed method
        in the ActionEventListener class.  This will copy the inputed txt from the  text field, move it
        to the label field and clear the txt field.
         */
        copyBtn.addActionListener(copier);

        container.add(inputTxtField);
        container.add(copyBtn);
        container.add(copyTxtField);
    }
}
