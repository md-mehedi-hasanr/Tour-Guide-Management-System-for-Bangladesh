package tour.guide.management.system.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RemovePersonalInformation extends JFrame implements ActionListener {
    JButton delete, back;
    JLabel labelusername, labelid, labelnumber, labelcountry, labelphone, labelemail, labelgender;
    String username;

    RemovePersonalInformation(String username) {
        this.username = username;
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(30, 200, 800, 500);

        JLabel lblusername = new JLabel("Account name");
        lblusername.setBounds(30, 30, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 30, 150, 20);
        labelusername.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelusername);

        // ID
        JLabel lbld = new JLabel("ID Card Number :");
        lbld.setBounds(30, 80, 150, 25);
        add(lbld);

        labelid = new JLabel();
        labelid.setBounds(200, 80, 150, 25);
        labelid.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelid);

        JLabel lblnumber = new JLabel("Id Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(200, 130, 150, 25);
        labelnumber.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(400, 30, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(600, 30, 150, 25);
        labelname.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelname);

        // Next row
        JLabel lblcountry = new JLabel("Nation");
        lblcountry.setBounds(30, 180, 150, 25);
        add(lblcountry);

        labelcountry = new JLabel();
        labelcountry.setBounds(200, 180, 150, 25);
        labelcountry.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelcountry);

        JLabel lbphone = new JLabel("Mobile Number ");
        lbphone.setBounds(400, 80, 150, 25);
        add(lbphone);

        labelphone = new JLabel();
        labelphone.setBounds(600, 80, 150, 25);
        labelphone.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelphone);

        JLabel lblemail = new JLabel("Email address");
        lblemail.setBounds(400, 130, 150, 25);
        add(lblemail);

        labelemail = new JLabel();
        labelemail.setBounds(600, 130, 150, 25);
        labelemail.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelemail);

        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(400, 180, 150, 25);
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(600, 180, 150, 25);
        labelgender.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelgender);

        delete = new JButton("Delete Account");
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.setBounds(600, 400, 150, 50);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(30, 400, 150, 50);
        back.addActionListener(this);
        add(back);

        try {
            Connection conn = new Connection();
            String query = "select * from customer where username = '" + username + "' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("account name"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("idnumber"));
                labelname.setText(rs.getString("name"));
                labelemail.setText(rs.getString("email address"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("nation"));
                labelphone.setText(rs.getString("Mobile number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new RemovePersonalInformation("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Connection c = new Connection();
                c.s.executeUpdate("delete from account where username = '" + username + "'  ");
                c.s.executeUpdate("delete from customer where username = '" + username + "'  ");
                c.s.executeUpdate("delete from bookpackage where username = '" + username + "'  ");
                c.s.executeUpdate("delete from bookhotel where username = '" + username + "'  ");

                JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
