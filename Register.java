import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class Register implements ActionListener {
    private JFrame f = new JFrame();
    private JPanel p = new JPanel();
    private JLabel Username = new JLabel("Email");
    private JTextField UsernameText = new JTextField();
    private JLabel UserPassword = new JLabel("Password");
    private JPasswordField UserPasswordText = new JPasswordField();
    private JButton Submit = new JButton("Submit");
    private JLabel success = new JLabel("");
    private JButton Back = new JButton("Back");

    public Register() {
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        p.setLayout(null);

        Username.setBounds(10, 20, 80, 25);
        UsernameText.setBounds(100, 20, 165, 25);

        UserPassword.setBounds(10, 50, 80, 25);
        UserPasswordText.setBounds(100, 50, 165, 25);

        Submit.setBounds(10, 80, 90, 25);
        success.setBounds(10, 120, 180, 25);
        Back.setBounds(10, 170, 90, 25);

        Submit.addActionListener(this);
        Back.addActionListener(this);

        p.add(Username);
        p.add(UsernameText);
        p.add(UserPassword);
        p.add(UserPasswordText);
        p.add(Submit);
        p.add(success);
        p.add(Back);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Submit) {
            String email = UsernameText.getText();
            String password = new String(UserPasswordText.getPassword());
            if (saveToFile(email, password)) {
                // success.setText("Registration Successful !!");
                JOptionPane.showMessageDialog(p ,"Registration Successful !! ");
            } else {
                // success.setText("Failed to save data.");
                JOptionPane.showMessageDialog(p, "Failed to store Data in File !!");
            }
        } else if (e.getSource() == Back) {
            f.setVisible(false);
            new Bank();
        }
    }

    private boolean saveToFile(String email, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("UserDatabase.txt", true))) {
            writer.write(email);
            writer.newLine();
            writer.write(password);
            writer.newLine();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
