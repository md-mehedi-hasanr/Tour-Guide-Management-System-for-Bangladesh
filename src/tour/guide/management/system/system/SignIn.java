package tour.guide.management.system.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SignIn extends JFrame implements ActionListener {
    JButton password, login, signup;
    JTextField tfusername, tfupassword;

    SignIn(String usernamee) {
        setSize(433, 400);
        setLocation(220, 120);

        setLayout(null);


        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 430, 500);
        p2.setBackground(Color.LIGHT_GRAY);
        add(p2);


        JLabel lblusername = new JLabel("Username OR Account Name");
        lblusername.setBounds(60, 0, 200, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        p2.add(lblusername);


        tfusername = new JTextField();
        tfusername.setBounds(60, 30, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);


        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 60, 100, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        p2.add(lblpassword);


        tfupassword = new JTextField();
        tfupassword.setBounds(60, 90, 300, 30);
        tfupassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfupassword);


        login = new JButton("Login");
        login.setBounds(60, 150, 300, 35);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);


        signup = new JButton("Signup");
        signup.setBounds(60, 250, 300, 35);
        signup.setBackground(Color.white);
        signup.setForeground(Color.BLACK);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);


        password = new JButton("Forget Password");
        password.setBounds(60, 200, 300, 35);
        password.setBackground(Color.WHITE);
        password.setForeground(Color.BLACK);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = tfupassword.getText();

                String query = "select * from account where username =  '" + username + "' AND password ='" + pass + "'";
                Connection c = new Connection();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new interFace(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == signup) {
            setVisible(false);
            CreateAccount su = new CreateAccount();
            su.setVisible(true);
        } else if (e.getSource() == password) {
            setVisible(false);
            passwordRecovery forgot = new passwordRecovery();
            forgot.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignIn("").setVisible(true);
    }
}
