import javax.swing.*;

public interface Calculator {
    int getValue();
    boolean add(JTextField num);
    boolean subtract(JTextField num);
    void reset();
}
