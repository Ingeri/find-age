import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

public class SimpleExample extends JFrame {
    public SimpleExample() {
        setTitle("Simple example with components");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 1. Change the layout manager to arrange items side-by-side
        setLayout(new FlowLayout());

        // 2. Create the label and button components
        JLabel label = new JLabel("Hello, Swing!");
        JButton button = new JButton("Click Me");

        // 3. Add an action listener to handle button clicks (using a modern lambda expression)
        button.addActionListener(e -> label.setText("Button Clicked!"));

        // 4. Add the components to the JFrame
        add(label);
        add(button);
    }

    public static void main(String[] args) {
        // Using a lambda expression here as well for cleaner code
        SwingUtilities.invokeLater(() -> {
            SimpleExample ex = new SimpleExample();
            ex.setVisible(true);
        });
    }
}