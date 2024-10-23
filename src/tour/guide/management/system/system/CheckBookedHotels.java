package tour.guide.management.system.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckBookedHotels extends JFrame implements ActionListener {
    JButton back;
    JLabel labelusername, labelhotel, labelpersons, labelAC, labelfood, labelprice;
    String username;

    public CheckBookedHotels(String username) {
        this.username = username;
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300, 200, 850, 500);

        JLabel heading = new JLabel("CHECK YOUR BOOKED HOTEL DETAILS");
        heading.setFont(new Font("Yu Mincho", Font.BOLD, 25));
        heading.setBounds(165, 0, 550, 25);
        add(heading);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(30, 50, 200, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 50, 200, 20);
        labelusername.setFont(new Font("Train Service :", Font.PLAIN, 20));
        add(labelusername);

        JLabel lblhotel = new JLabel("Hotel Name :");
        lblhotel.setBounds(30, 100, 200, 25);
        add(lblhotel);

        labelhotel = new JLabel();
        labelhotel.setBounds(200, 100, 200, 25);
        labelhotel.setFont(new Font("Train Service :", Font.PLAIN, 20));
        add(labelhotel);

        JLabel lblpersons = new JLabel("Number of Guests :");
        lblpersons.setBounds(30, 150, 200, 25);
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(200, 150, 200, 25);
        labelpersons.setFont(new Font("Train Service :", Font.PLAIN, 20));
        add(labelpersons);

        JLabel lbldays = new JLabel("Duration of Stay :");
        lbldays.setBounds(30, 200, 200, 25);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(200, 200, 200, 25);
        labeldays.setFont(new Font("Train Service :", Font.PLAIN, 20));
        add(labeldays);

        JLabel lblAC = new JLabel("Air Conditioning Preference :");
        lblAC.setBounds(30, 250, 200, 25);
        add(lblAC);

        labelAC = new JLabel();
        labelAC.setBounds(200, 250, 200, 25);
        labelAC.setFont(new Font("Train Service :", Font.PLAIN, 20));
        add(labelAC);

        JLabel lblfood = new JLabel("Meal Plan :");
        lblfood.setBounds(30, 300, 200, 25);
        add(lblfood);

        labelfood = new JLabel();
        labelfood.setBounds(200, 300, 200, 25);
        labelfood.setFont(new Font("Train Service :", Font.PLAIN, 20));
        add(labelfood);

        JLabel lblprice = new JLabel("Total Price :");
        lblprice.setBounds(30, 350, 200, 25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(200, 350, 200, 25);
        labelprice.setFont(new Font("Train Service :", Font.PLAIN, 20));
        add(labelprice);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(600, 400, 200, 25);
        back.addActionListener(this);
        add(back);

        try {
            Connection conn = new Connection();
            String query = "select * from bookhotel where username = '" + username + "' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelhotel.setText(rs.getString("Hotel"));
                labelpersons.setText(rs.getString("person"));
                labeldays.setText(rs.getString("days"));
                labelAC.setText(rs.getString("AC"));
                labelfood.setText(rs.getString("food"));
                labelprice.setText(rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBookedHotels("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        }
    }
}
