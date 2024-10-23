package tour.guide.management.system.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import static java.awt.Color.blue;

public class CreateAccount extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfUserName;
    private JTextField tfName;
    private JTextField tfPassword;
    JTextField tfAnswer;
    JButton creat, back;
    JComboBox comboBox;

    public static void main(String[] args) {
        new CreateAccount().setVisible(true);
    }

    public CreateAccount() {
        setBounds(10, 150, 600, 406);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);

        // Username
        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(20, 86, 90, 26);
        contentPane.add(lblUsername);

        tfUserName = new JTextField();
        tfUserName.setBounds(265, 91, 250, 20);
        tfUserName.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfUserName);

        // Name
        JLabel lblName = new JLabel("Full name :");
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(20, 123, 90, 26);
        contentPane.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(265, 128, 250, 20);
        tfName.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfName);

        // Password
        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(20, 160, 90, 26);
        contentPane.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(265, 165, 250, 20);
        tfPassword.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfPassword);

        // Answer
        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.BLACK);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(20, 234, 90, 26);
        contentPane.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(265, 239, 250, 20);
        tfAnswer.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfAnswer);

        // Security Question
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "What is your favorite color?",
         "What city were you born in?",
        "What is your mother's maiden name?",
         "What was your favorite subject in school?",
        "What is the name of your favorite book?",
        "Who was your childhood best friend?",
        "What was the name of your first school?"}));
        comboBox.setBounds(265, 202, 250, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Verification question :");
        lblSecurityQuestion.setForeground(Color.BLACK);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(20, 197, 190, 26);
        contentPane.add(lblSecurityQuestion);

        // Buttons
        creat = new JButton("Create New Account ");
        creat.addActionListener(this);
        creat.setFont(new Font("Tahoma", Font.BOLD, 13));
        creat.setBounds(22, 289, 200, 30);
        creat.setBackground(Color.BLACK);
        creat.setForeground(Color.WHITE);
        contentPane.add(creat);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBounds(300, 289, 200, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        contentPane.add(back);

        // Panel
        JPanel panel = new JPanel();
        panel.setForeground(new Color(18, 15, 15));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(14, 13, 13), 2), "Create-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(9, 11, 9)));
        panel.setBounds(11, 30, 570, 310);
        panel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == creat) {
            String username = tfUserName.getText();
            String name = tfName.getText();
            String password = tfPassword.getText();
            String question = (String) comboBox.getSelectedItem();
            String answer = tfAnswer.getText();

            try {
                Connection c = new Connection();
                String query = "insert into account values('" + username + "'  , '" + name + "'  , '" + password + "' , '" + question + "' , '" + answer + "' )";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new SignIn("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            this.setVisible(false);
            new SignIn("").setVisible(true);
        }
    }
}
