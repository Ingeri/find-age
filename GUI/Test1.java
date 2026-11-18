import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 extends JFrame{
    
    //Fileds
    private JTextField fName;
    private JTextField lName;
    private JLabel fullNames;

    public Test1(){

        setTitle("Testing Header");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Font customFont = new Font("Segoe UI", Font.PLAIN, 24);

        JLabel fNameLabel = new JLabel("First Name:");
        fNameLabel.setBounds(30, 30, 150, 30);
        fNameLabel.setFont(customFont);
        add(fNameLabel);

        fName = new JTextField();
        fName.setBounds(230, 30, 250, 40);
        fName.setFont(customFont);
        add(fName);

        JLabel lNameLabel = new JLabel("Last Name:");
        lNameLabel.setBounds(30, 80, 150, 30);
        lNameLabel.setFont(customFont);
        add(lNameLabel);

        lName = new JTextField();
        lName.setBounds(230, 80, 250, 40);
        lName.setFont(customFont);
        add(lName);

        JButton displayButton = new JButton("Display Full Names");
        displayButton.setBounds(30, 130, 450, 40);
        displayButton.setFont(customFont);
        add(displayButton);

        fullNames = new JLabel("Full names are: Here");
        fullNames.setBounds(30, 180, 550, 40);
        fullNames.setFont(customFont);
        add(fullNames);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = fName.getText().trim();
                String lastName = lName.getText().trim();

                String allNames = firstName + " " + lastName;
                fullNames.setText("Full Names are: " + allNames);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test1().setVisible(true);
            }
        });

    }
}
