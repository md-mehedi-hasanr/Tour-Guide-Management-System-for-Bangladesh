package tour.guide.management.system.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class passwordRecovery extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrive, back;

    passwordRecovery() {
        setBounds(250, 150, 590, 380);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(30, 20, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBounds(350, 20, 100, 25);
        search.setBackground(new Color(0xB7B7F1));
        search.setForeground(new Color(4));
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(30, 60, 100, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(150, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lbquestion = new JLabel("Your Question :");
        lbquestion.setBounds(30, 100, 120, 25);
        lbquestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lbquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(150, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lbanswer = new JLabel("Answer :");
        lbanswer.setBounds(30, 140, 120, 25);
        lbanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lbanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(150, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrive = new JButton("Retrieve");
        retrive.setBounds(350, 140, 100, 25);
        retrive.setBackground(new Color(0xB7B7F1));
        retrive.setForeground(new Color(4));
        retrive.addActionListener(this);
        p1.add(retrive);

        JLabel lbpassword = new JLabel("Password :");
        lbpassword.setBounds(30, 180, 120, 25);
        lbpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lbpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(150, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);


        back = new JButton("Back");
        back.setBounds(150, 220, 100, 25);
        back.setBackground(new Color(0xB7B7F1));
        back.setForeground(new Color(4));
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            try {
                String query = "select * from account where username = '" + tfusername.getText() + "'";
                Connection c = new Connection();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username");
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == retrive) {
            try {
                String query = "select * from account where answer = '" + tfanswer.getText() + "' AND username = '" + tfusername.getText() + "'";
                Connection c = new Connection();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Answer");
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new SignIn("");
        }
    }

    public static void main(String[] args) {
        new passwordRecovery();
    }
}
