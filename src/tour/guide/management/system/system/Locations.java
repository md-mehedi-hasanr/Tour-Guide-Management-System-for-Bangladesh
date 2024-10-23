package tour.guide.management.system.system;

import javax.swing.*;
import java.awt.*;

public class Locations extends JFrame {

    Locations() {
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(30, 100, 600, 600);

        String[] places = new String[]
                {


        "1. Sundarbans",
       "2. Cox's Bazar",
        "3. Srimangal",
        "4. Mahasthangarh",
        "5. Paharpur",
        "6. Lalbagh Fort",
        "7. Rangamati",
        "8. Bandarban",
        "9. Bagerhat",
        "10. Dhaka Old Town",

        "11. Chandranath Hill",
        "12. Kumrat Valley",
        "13. Jaflong",
        "14. Sreemangal Tea Gardens",
        "15. Natore Rajbari",
        "16. Kantaji Temple",
        "17. Panam City",
        "18. Mymensingh's Bhashani Udyan",
        "19. Sonargaon",
        "20. Shat Gambuj Mosque"



        };
        JList<String> placeList = new JList<>(places);
        placeList.setFont(new Font("Thoma", Font.PLAIN, 20));
        placeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        placeList.setFixedCellHeight(30);
        placeList.setVisibleRowCount(10);
        placeList.setBackground(Color.gray);
        JScrollPane scrollPane = new JScrollPane(placeList);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Locations();
    }
}
