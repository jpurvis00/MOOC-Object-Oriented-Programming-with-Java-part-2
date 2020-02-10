package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        /*BoxLayout dictates that our layout will be down the Y axis meaning that each thing we add to the
        JFrame will appear from top to bottom.
         */
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Are you?"));

        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");

        container.add(yes);
        container.add(no);

        container.add(new JLabel("Why?"));

        /*Create 2 radio buttons and add them to a button group so that only 1 at a time is selectable*/
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton bcItIsFun = new JRadioButton("Because it is fun!");
        buttonGroup.add(noReason);
        buttonGroup.add(bcItIsFun);

        container.add(noReason);
        container.add(bcItIsFun);

        JButton done = new JButton("Done!");
        container.add(done);

    }

    public JFrame getFrame() {
        return frame;
    }
}
