package tour.guide.management.system.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton pay, back;
    JComboBox<String> paymentMethods;

    Transactions() {
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(30, 100, 480, 300);

        // Payment Methods ComboBox
        String[] methods = {"Nagad", "bKash", "Rocket", "Bank"};
        paymentMethods = new JComboBox<>(methods);
        paymentMethods.setBounds(165, 30, 150, 30);
        add(paymentMethods);

        pay = new JButton("Pay");
        pay.setForeground(Color.white);
        pay.setBackground(Color.black);
        pay.setBounds(30, 200, 100, 30);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(300, 200, 100, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Transactions();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == pay) {
            String selectedMethod = (String) paymentMethods.getSelectedItem();
            JOptionPane.showMessageDialog(null, "You selected: " + selectedMethod);
        }
    }
}
