
import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private PersonalCalculator calc = new PersonalCalculator();

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        JTextField finalValue = new JTextField("" + this.calc.getValue());
        JTextField inputNum = new JTextField();

        container.add(finalValue).setEnabled(false);
        container.add(inputNum);

        /*This creates a nested container object.  In the last row, we are creating 3 buttons in 1 column.*/
        container.add(createPanel(finalValue, inputNum), BorderLayout.SOUTH);
    }

    /*Our gui is 1 column with 3 rows.  This panel is for creating 3 buttons in the last row of the gui.
    * Otherwise we would have to make our original gui with 3 columns instead of 1.*/
    private JPanel createPanel(JTextField finalValue, JTextField inputNum){
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton addBtn = new JButton("+");
        JButton subBtn = new JButton("-");
        JButton resetBtn = new JButton("Z");

        /*Create a clickLIstener object for the buttons.  This allows us to perform specific tasks
        * when each button is clicked.  We are passing the constructor the items that will need
        * to be modified once a click has been detected.*/
        ClickListener clickListener = new ClickListener(this.calc, finalValue, inputNum, resetBtn);
        addBtn.addActionListener(clickListener);
        subBtn.addActionListener(clickListener);
        resetBtn.addActionListener(clickListener);

        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(resetBtn);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
