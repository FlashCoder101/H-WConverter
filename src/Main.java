import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

////////////////////////////////////////////////////////////// class BMI
class Main extends JFrame {
    //=============================================== static method main
    public static void main(String[] args) {
        Main window = new Main();
        window.setVisible(true);
    }

    //=============================================== instance variables
    // Declare and initialize instance variables that are
    // referred to when the program is running.
    private JTextField _mField   = new JTextField(4);  // height
    private JTextField _kgField  = new JTextField(4);  // weight
    private JTextField _bmiField = new JTextField(4);  // BMI

    //====================================================== constructor
    public Main() {
        //... Create button and add action listener.
        JButton bmiButton = new JButton("Calculate BMI");
        bmiButton.addActionListener(new BMIListener());

        //... Set layout and add components.
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Weight in pounds"));
        content.add(_kgField);
        content.add(new JLabel("Height in inches"));
        content.add(_mField);
        content.add(bmiButton);
        content.add(new JLabel("Your BMI is"));
        content.add(_bmiField);

        //... Set the window characteristics.
        setContentPane(content);
        setTitle("Body Mass Index");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();                          // Do layout.
        setLocationRelativeTo(null);     // Center window.
    }

    //////////////////////////////////////////// inner class BMIListener
    // Inner class is used to access components.
    // BMI is converted to int to eliminate excess "accuracy".
    private class BMIListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double pounds = Double.parseDouble(_kgField.getText());
            double inches = Double.parseDouble(_mField.getText());
            int bmi = (int)computeBMI(pounds, inches);
            _bmiField.setText("" + bmi);
        }
    }

    //=========================================== logic method computeBMI
    public static double computeBMI(double weight, double height) {
        return (703* weight) / (height * height);
    }
}