import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalculaterGUI {

    private JFrame frame;

    /***
     * create a new caculator object
     */
    public CalculaterGUI(){
        // creating jframe
        frame = new JFrame();
        frame.setSize(new Dimension(400, 500));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // adding a result textfield in a scrollpanel
        JTextArea textField = new JTextArea();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", 14,16));
        JScrollPane scrollableText = new JScrollPane(textField);
        scrollableText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollableText.setPreferredSize(new Dimension(100, 60));
        mainPanel.add(scrollableText, BorderLayout.PAGE_START);

        // add two panels for basic & advanced
        JPanel basicPanel = new JPanel(new GridLayout(6,3));
        addBasicButtons(basicPanel);
        JPanel advancedPanel = new JPanel(new GridLayout(6, 4));
        addAdvancedButton(advancedPanel);

        // add a tabbed pane & add it to mainPanel
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Basic", basicPanel);
        tabbedPane.add("Advanced", advancedPanel);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        // set frame main layout
        frame.setContentPane(mainPanel);
        frame.setTitle("Calculator");
        frame.setVisible(true);
    }

    // add basic buttons to basic panel
    private void addBasicButtons(JPanel panel){
        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Arial", 14, 16));
        JButton minusButton = new JButton("-");
        minusButton.setFont(new Font("Arial", 14, 16));
        JButton divideButton = new JButton("/");
        divideButton.setFont(new Font("Arial", 14, 16));
        JButton multipButton = new JButton("x");
        multipButton.setFont(new Font("Arial", 14, 16));
        JButton modulusButton = new JButton("%");
        modulusButton.setFont(new Font("Arial", 14, 16));
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", 14, 14));

        panel.add(clearButton);
        panel.add(modulusButton);
        panel.add(divideButton);
        panel.add(multipButton);
        panel.add(addButton);
        panel.add(minusButton);

        for(int i = 9;i >= 0;i--){
            JButton button = new JButton("" + i);
            panel.add(button);
        }

        JButton pointButton = new JButton(".");
        pointButton.setFont(new Font("Arial", 14, 18));
        JButton equalButton = new JButton("=");
        equalButton.setFont(new Font("Arial", 14, 16));
        panel.add(pointButton);
        panel.add(equalButton);
    }

    // add advanced buttons to advanced panel
    private void addAdvancedButton(JPanel panel){
        JButton shiftButton = new JButton("Shift");
        shiftButton.setFont(new Font("Arial", 14, 16));

        JButton piButton = new JButton("pi");
        piButton.setFont(new Font("Arial", 14, 16));
        JButton neperButton = new JButton("e");
        neperButton.setFont(new Font("Arial", 14, 16));

        panel.add(shiftButton);
        panel.add(piButton);
        panel.add(neperButton);

        JButton sinButton = new JButton("Sin");
        sinButton.setFont(new Font("Arial", 14, 16));
        JButton cosButton = new JButton("Cos");
        cosButton.setFont(new Font("Arial", 14, 16));
        JButton expButton = new JButton("Exp");
        expButton.setFont(new Font("Arial", 14, 16));
        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Arial", 14, 16));
        JButton minusButton = new JButton("-");
        minusButton.setFont(new Font("Arial", 14, 16));
        JButton divideButton = new JButton("/");
        divideButton.setFont(new Font("Arial", 14, 16));
        JButton multipButton = new JButton("x");
        multipButton.setFont(new Font("Arial", 14, 16));
        JButton modulusButton = new JButton("%");
        modulusButton.setFont(new Font("Arial", 14, 16));
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", 14, 14));

        panel.add(clearButton, 3);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(expButton);
        panel.add(modulusButton);
        JButton[] operationButtons = new JButton[4];
        operationButtons[0] = divideButton;
        operationButtons[1] = multipButton;
        operationButtons[2] = minusButton;


        for(int j = 0;j < 3;j++){
            for(int i = 3 * (3 - j) - 2;i <= 3 * (3 - j);i++){
                panel.add(new JButton("" + i));
            }
            panel.add(operationButtons[j]);
        }

        panel.add(new JButton("0"));
        JButton pointButton = new JButton(".");
        pointButton.setFont(new Font("Arial", 14, 18));
        JButton equalButton = new JButton("=");
        equalButton.setFont(new Font("Arial", 14, 16));
        panel.add(pointButton);
        panel.add(equalButton);
        panel.add(addButton);
    }
}
