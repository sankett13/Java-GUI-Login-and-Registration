import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class MLogin implements ActionListener 
{
    private JFrame f = new JFrame();
    private JPanel p = new JPanel();
    private JLabel UEmail = new JLabel("Email");
    private JTextField UEmailText = new JTextField();
    private JLabel UserPassword = new JLabel("Password");
    private JPasswordField UserPasswordText = new JPasswordField();
    private JButton Check = new JButton("Check");
    private JLabel success = new JLabel("");

    public MLogin() {
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        p.setLayout(null);

        UEmail.setBounds(10, 20, 165, 25);
        UEmailText.setBounds(100, 20, 200, 25);

        UserPassword.setBounds(10, 50, 80, 25);
        UserPasswordText.setBounds(100, 50, 200, 25);

        Check.setBounds(10, 100, 80, 25);
        success.setBounds(10, 120, 180, 25);

        p.add(UEmail);
        p.add(UEmailText);
        p.add(UserPassword);
        p.add(UserPasswordText);
        p.add(Check);
        p.add(success);

        Check.addActionListener(this);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CheckfromFile(UEmailText.getText(), new String(UserPasswordText.getPassword()));
    }

    private boolean CheckfromFile(String email, String password) {
        File f = new File("UserDatabase.txt");
        try (Scanner reader = new Scanner(f)) {
            while (reader.hasNextLine()) {
                String result = reader.nextLine();
                if (result.equals(email)) {
                    result = reader.nextLine();
                    if (result.equals(password)) {
                        JOptionPane.showMessageDialog(p,"Login Successful");
                        // success.setText("Login SuccessFul !!");
                        
                        System.out.println(result);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(p,"Incorrect Password");
                    //     success.setText("Incorrect Password !!");
                    //     success.setVisible(true);
                     }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return true;
        }
    }

    public static void main(String[] args) {
        new MLogin();
    }
}
