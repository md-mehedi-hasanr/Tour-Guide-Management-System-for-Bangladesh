package tour.guide.management.system.system;

import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable {
    JLabel caption;
    Thread t1;
    JList<String> hotelList;
    DefaultListModel<String> listModel;

    CheckHotels() {
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(200, 100, 600, 600);

        listModel = new DefaultListModel<>();
        hotelList = new JList<>(listModel);
        hotelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(hotelList);
        scrollPane.setBounds(50, 50, 500, 400); // Set bounds for the scroll pane
        add(scrollPane);
        caption = new JLabel();
        caption.setBounds(50, 470, 1000, 70);
        caption.setFont(new Font("Thoma", Font.PLAIN, 20));
        caption.setForeground(Color.black);
        add(caption);
        hotelList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedHotel = hotelList.getSelectedValue();
                caption.setText(selectedHotel);
            }
        });
        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckHotels();
    }

    @Override
    public void run() {
        String[] text = new String[]{

        "1. The Westin Dhaka",
        "2. Pan Pacific Sonargaon",
        "3. Radisson Blu Dhaka Water Garden",
        "4. InterContinental Dhaka",
        "5. Le Meridien Dhaka",
        "6. Hotel Sarina",
        "7. Four Points by Sheraton Dhaka",
        "8. The Peninsula Chittagong",
        "9. Royal Tulip Sea Pearl Beach Resort",
        "10.Jatiyo Sangsad Bhaban (National Parliament House)",
        "11. The Ritz-Carlton, Dhaka",
        "12. Hotel Agrabad",
        "13. Narayanganj River View Hotel",
        "14. Hotel Sundarban",
        "15. Best Western La Vinci Hotel",
        "16. Puthulok Hotel",
        "17. Dhaka Regency Hotel & Resort",
        "18. Hotel 71",
        "19. Regal Palace Hotel",
        "20. Green House Hotel & Restaurant"

        };
        try {

            for (String hotel : text) {
                listModel.addElement(hotel);
                Thread.sleep(250);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
