package tour.guide.management.system.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeScreen extends JFrame implements ActionListener {

    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, chechpackages, bookPackages, deletePersonalDetails;
    JButton logout, calculator, payment, Destinations, viewBookedHotels, bookHotels, viewHotels, viewPackages;
    String username;

    HomeScreen(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setBounds(30, 0, 400, 65);
        add(p1);
        JLabel heading = new JLabel("Tour Guide Management System");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setBounds(30, 5, 400, 80);
        p1.add(heading);
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(13, 1, 10, 10));
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setBounds(30, 150, 400, 600);
        add(p2);
        addPersonalDetails = createButton("Add New Personal Information ");
        p2.add(addPersonalDetails);

        updatePersonalDetails = createButton("Edit Personal Information");
        p2.add(updatePersonalDetails);

        viewPersonalDetails = createButton("Check Personal Information");
        p2.add(viewPersonalDetails);

        deletePersonalDetails = createButton("Remove Personal Information");
        p2.add(deletePersonalDetails);

        chechpackages = createButton("Explore Packages");
        p2.add(chechpackages);

        bookPackages = createButton("Book Packages");
        p2.add(bookPackages);

        viewPackages = createButton("View Booked Package");
        p2.add(viewPackages);

        viewHotels = createButton("Check Hotels");
        p2.add(viewHotels);

        bookHotels = createButton("Booked Hotels");
        p2.add(bookHotels);

        viewBookedHotels = createButton("View Booked Hotels");
        p2.add(viewBookedHotels);

        Destinations = createButton("Locations");
        p2.add(Destinations);

        payment = createButton("Transactions");
        p2.add(payment);
        logout = new JButton("Sign Out");
        logout.setForeground(Color.ORANGE);
        logout.setBackground(Color.gray);
        logout.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
        logout.addActionListener(this);
        p2.add(logout);

        setVisible(true);
    }
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.gray);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new EnterPersonalInformation(username);
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new SignIn("");
        } else if (ae.getSource() == viewPersonalDetails) {
            new CheckCustomerInformation(username).setVisible(true);
        } else if (ae.getSource() == updatePersonalDetails) {
            new EditPersonalInformation(username).setVisible(true);
        } else if (ae.getSource() == chechpackages) {
            new ExplorePackages().setVisible(true);
        } else if (ae.getSource() == bookPackages) {
            new BookPackage(username);
        } else if (ae.getSource() == viewPackages) {
            new CheckPackage(username);
        } else if (ae.getSource() == viewHotels) {
            new CheckHotels();
        } else if (ae.getSource() == Destinations) {
            new Locations();
        } else if (ae.getSource() == bookHotels) {
            new BookedHotels(username);
        } else if (ae.getSource() == viewBookedHotels) {
            new CheckBookedHotels(username);
        } else if (ae.getSource() == payment) {
            new Transactions();
            try {
                Runtime.getRuntime().exec("calc.exe");
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == deletePersonalDetails) {
            new RemovePersonalInformation(username);
        }
    }

    public static void main(String[] args) {
        new HomeScreen("");
    }
}
