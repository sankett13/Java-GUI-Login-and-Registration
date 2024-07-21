import javax.swing.*;
import java.awt.event.*;

public class Bank implements ActionListener {
    private JFrame f = new JFrame();
    private JPanel p = new JPanel();
    private JButton BRegister = new JButton("Register");
    private JButton BLogin = new JButton("Login");

    public Bank() {
        f.setSize(300, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        p.setLayout(null);

        BRegister.setBounds(10, 20, 80, 25);
        BLogin.setBounds(10, 60, 80, 25);

        p.add(BRegister);
        p.add(BLogin);

        BLogin.addActionListener(this);
        BRegister.addActionListener(this);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.setVisible(false);
        f.dispose();

        if (e.getSource()==BLogin) 
        {
            new MLogin();
        }
        else if(e.getSource()==BRegister)
        {
            new Register();
        }
            
        
    }

    public static void main(String[] args) {
        new Bank();
    }
}
