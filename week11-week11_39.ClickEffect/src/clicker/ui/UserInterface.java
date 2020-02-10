package clicker.ui;

import clicker.applicationlogic.Calculator;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calc;

    /*Receives a new Calculator object to use in the UI*/
    public UserInterface(Calculator calc){
        this.calc = calc;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);

        JLabel countTxt = new JLabel("0");

        /*Create a new button*/
        JButton clickBtn = new JButton("Click!");
        /*Tie the button to the ClickListener class which implements Action Listener*/
        ClickListener clickListener = new ClickListener(this.calc, countTxt);
        clickBtn.addActionListener(clickListener);
        /*Above two lines could be combined
        * clickBtn.addActionListener(new ClickListener(this.calc, countTxt);*/

        container.add(countTxt);
        container.add(clickBtn);
    }

    public JFrame getFrame() {
        return frame;
    }
}
