package tour.guide.management.system.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class EditPersonalInformation extends JFrame implements ActionListener {

    JLabel labelname, labelusername;
    JButton back, update;
    JTextField tfNumber, tfcountry, tfphone, tfemail, tfid, tfgender;
    JLabel lblusername, lblname, gender;
    String usrename;

    EditPersonalInformation(String usrename) {
        this.usrename = usrename;

        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300, 200, 450, 450);

        JLabel text = new JLabel("EDIT CUSTOMER DETAILS");
        text.setFont(new Font("Tahoma", Font.PLAIN, 22));
        text.setBounds(80, 0, 500, 25);
        add(text);

        lblusername = new JLabel("Username :");
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblusername.setBounds(50, 30, 300, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 30, 200, 20);
        add(labelusername);

        JLabel lblid = new JLabel("ID :");
        lblid.setForeground(Color.BLACK);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblid.setBounds(50, 70, 300, 20);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(200, 70, 200, 20);
        tfid.setBackground(Color.white);
        add(tfid);

        JLabel lblnumber = new JLabel("ID Number:");
        lblnumber.setForeground(Color.BLACK);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblnumber.setBounds(50, 110, 300, 20);
        add(lblnumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(200, 110, 200, 20);
        tfNumber.setBackground(Color.white);
        add(tfNumber);

        lblname = new JLabel("Name");
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblname.setBounds(50, 150, 300, 20);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 150, 200, 20);
        add(labelname);

        gender = new JLabel("Gender :");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gender.setBounds(50, 190, 300, 20);
        add(gender);

        tfgender = new JTextField();
        tfgender.setBounds(200, 190, 200, 20);
        tfgender.setBackground(Color.white);
        add(tfgender);

        JLabel lblcountry = new JLabel("Country:");
        lblcountry.setForeground(Color.BLACK);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblcountry.setBounds(50, 230, 300, 20);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 230, 200, 20);
        tfcountry.setBackground(Color.white);
        add(tfcountry);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setForeground(Color.BLACK);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblphone.setBounds(50, 275, 300, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 275, 200, 20);
        tfphone.setBackground(Color.white);
        add(tfphone);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setForeground(Color.BLACK);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblemail.setBounds(50, 320, 300, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 320, 200, 20);
        tfemail.setBackground(Color.white);
        add(tfemail);

        update = new JButton("Edit Done");
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(30, 360, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(300, 360, 100, 30);
        back.addActionListener(this);
        add(back);

        try {
            Connection c = new Connection();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + usrename + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfNumber.setText(rs.getString("idnumber"));
                tfcountry.setText(rs.getString("country"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phoneNo"));
                tfgender.setText(rs.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String username = labelusername.getText();
            String id = tfid.getText();
            String idNumber = tfNumber.getText();
            String name = labelname.getText();
            String number = tfphone.getText();
            String email = tfemail.getText();
            String country = tfcountry.getText();
            String gender = tfgender.getText();

            try {
                Connection c = new Connection();
                String query = "update customer set username = '" + username + "', id = '" + id + "', idnumber = '" + idNumber + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', phoneNo = '" + number + "', email = '" + email + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EditPersonalInformation("");
    }
}
