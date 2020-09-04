import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator extends JFrame {
    public Calculator() {
        setTitle("Calculator v2.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(100,0,500,700));
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2, 1));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        inputField.setEditable(false);
        topPanel.add(inputField);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(5, 5));

        List<JButton> buttons = createBasicButtons();
        for (JButton btn : buttons) {
            bottomPanel.add(btn);
        }

        JComboBox<ButtonMode> modes = new JComboBox<>();

        for (ButtonMode buttonMode : ButtonMode.values()) {
            modes.addItem(buttonMode);
        }
//        modes.addItem(ButtonMode.BASIC);
//        modes.addItem(ButtonMode.ENGINEER);
//        modes.addItem(ButtonMode.PROGRAMMING);
        modes.addActionListener(new ModeListener(bottomPanel));

        bottomPanel.add(modes);

        add(topPanel);
        add(bottomPanel);

        setVisible(true);
    }

    private List createBasicButtons() {
        List<JButton> basicButtons = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            basicButtons.add(new JButton(String.valueOf(i)));
        }
        basicButtons.add(new JButton("C"));
        basicButtons.add(new JButton("+"));
        basicButtons.add(new JButton("-"));
        basicButtons.add(new JButton("*"));
        basicButtons.add(new JButton("/"));

        return basicButtons;
    }
}
