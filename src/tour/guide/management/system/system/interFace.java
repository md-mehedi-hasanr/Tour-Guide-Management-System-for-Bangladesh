package tour.guide.management.system.system;
///*
import javax.swing.*;
import java.awt.*;

public class interFace extends JFrame implements  Runnable{
    Thread t;
    private JProgressBar bar;

    String usernamee;
    public void setUploading() {
        setVisible(false);
        t.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {

                int m =  bar.getMaximum();
                int v =  bar.getValue();
                if (v < m) {
                    bar.setValue( bar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new HomeScreen(usernamee).setVisible(true);
//                    new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    interFace(String usernamee){
        this.usernamee = usernamee;

        t = new Thread( this);

        setBounds( 500 , 200 , 650 , 400);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        JLabel text = new JLabel("Tour Guide Management System App");
        text.setBounds(50 , 20 , 600 , 40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        add(text);


        bar = new JProgressBar();
        bar.setFont(new Font("Tahoma", Font.BOLD, 12));
        bar.setStringPainted(true);
        bar.setBounds(150 , 100 , 300 , 35);
        bar.setStringPainted(true);
        add(bar);


        JLabel loading = new JLabel("Wait For Sometime...");
        loading.setBounds(180 , 140 , 350 , 30);
        loading.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        loading.setForeground(Color.WHITE);
        add(loading);

        JLabel username = new JLabel("Welcome");
        username.setBounds(220 , 310 , 400 , 30);
        username.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
        username.setFont(new Font("Raleway" , Font.BOLD , 35));
        username.setForeground(Color.WHITE);
        add(username);

        t.start();
        setVisible(true);

    }
    public static void main(String[] args) {
        new interFace("");
    }
}
