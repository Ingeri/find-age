import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BicycleRentalGUI extends JFrame{
    
    private JTextField startField;
    private JTextField endField;
    private JLabel resultLable;

    public BicycleRentalGUI() {

        setTitle("Bicycle Rental Culculator");
        setSize(360, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        //UI
        add(new JLabel("Starting Time (0-23)"));
        startField = new JTextField();
        add(startField);

        add(new JLabel("Ending Time (1-24)"));
        endField = new JTextField();
        add(endField);

        JButton calculateButton = new JButton("alculate Cost");
        add(calculateButton);

        resultLable = new JLabel("   Tatal = 0   ");
        resultLable.setFont(new Font("Arial", Font.BOLD, 14));
        add(resultLable);


        //Click event
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int start = Integer.parseInt(startField.getText().trim());
                    int end = Integer.parseInt(endField.getText().trim());

                    if(start < 0 || start > 23 || end < 1 || end > 24) {
                        JOptionPane.showMessageDialog(BicycleRentalGUI.this,
                            "Invalid hours! Ensure start(0-23) end(1-24)",
                            "Input Error", JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }

                    int total = BicycleRental.culculateCost(start, end);
                    resultLable.setText("Total" + total + "RWF");
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BicycleRentalGUI.this,
                        "Please Enter valid integer number",
                        "Format Error", JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new BicycleRentalGUI().setVisible(true);
            }
        });
    }
}
