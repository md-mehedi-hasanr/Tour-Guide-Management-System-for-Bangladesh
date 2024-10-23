package tour.guide.management.system.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckPackage extends JFrame implements ActionListener {
    JButton back;
    JLabel labelusername , labelpackage , labelpersons , labelidno , labelphone  , labelprice,labelgender ;
    String username;

    CheckPackage(String username) {
        this.username = username;
        setLayout(null);
        getContentPane().setBackground(Color.gray);
        setBounds(300, 200, 555, 500);

        JLabel heading = new JLabel("CHECK PACKAGE DETAILS");
        heading.setFont(new Font("Yu Mincho", Font.BOLD, 25));
        heading.setBounds(70, 0, 550, 25);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 50, 150, 20);
        labelusername.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelusername);

        // Package Label
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30, 100, 150, 25);
        add(lblpackage);

        labelpackage = new JLabel();
        labelpackage.setBounds(200, 100, 150, 25);
        labelpackage.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 150, 150, 25);
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(200, 150, 150, 25);
        labelpersons.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelpersons);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 200, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(200, 200, 150, 25);
        labelid.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelid);

        JLabel lblidno = new JLabel("ID Number");
        lblidno.setBounds(30, 250, 150, 25);
        add(lblidno);

        labelidno = new JLabel();
        labelidno.setBounds(200, 250, 150, 25);
        labelidno.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelidno);

        JLabel lbphone = new JLabel("Contact Number");
        lbphone.setBounds(30, 300, 150, 25);
        add(lbphone);

        labelphone = new JLabel();
        labelphone.setBounds(200, 300, 150, 25);
        labelphone.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelphone);

        JLabel lblprice = new JLabel("Total Cost");
        lblprice.setBounds(30, 350, 150, 25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(200, 350, 150, 25);
        labelprice.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelprice);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(400, 400, 100, 25);
        back.addActionListener(this);
        add(back);

        try {
            Connection conn = new Connection();
            String query = "select * from bookpackage where username = '" + username + "' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("person"));
                labelid.setText(rs.getString("id"));
                labelidno.setText(rs.getString("idnumber"));
                labelphone.setText(rs.getString("phoneNo"));
                labelprice.setText(rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckPackage("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);

        }
    }
}
