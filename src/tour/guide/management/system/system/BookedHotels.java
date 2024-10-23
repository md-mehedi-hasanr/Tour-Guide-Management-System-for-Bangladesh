package tour.guide.management.system.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class BookedHotels extends JFrame implements ActionListener
{
    Choice selectHotels ,cac , cfood;
    JLabel  lblfood,labelusername , labelid , labelname , labelnumber , gender , labelphone , labelprice , labelidnumber;
    JButton chechprice , book , back;
    JTextField tfperson , tfdays;
    JRadioButton ac , nonac;
    ButtonGroup gendergroup;

    String username;
    public BookedHotels(String username) {
        this.username = username;
        setLayout(null);
        setBounds(300, 150, 450, 650);
        getContentPane().setBackground(Color.LIGHT_GRAY);


        JLabel bookpackages = new JLabel("Booking Particular Hotel");
        bookpackages.setFont(new Font("Yu Mincho", Font.BOLD, 25));
        bookpackages.setBounds(30, 0, 300, 53);
        add(bookpackages);

        JLabel lblusername = new JLabel("Username Details :");
        lblusername.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblusername.setBounds(30,60,150,20);
        add(lblusername);
        labelusername  = new JLabel();
        labelusername.setBounds(200,60,150,22);
        labelusername.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelusername);

        JLabel lblselecthotels = new JLabel("Choose Hotels");
        lblselecthotels.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblselecthotels.setBounds(30,100,150,20);
        add(lblselecthotels);
        selectHotels = new Choice();
        selectHotels.setBounds(200,100,150,20);
        add(selectHotels);

        try{
            Connection c = new Connection();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()){
                selectHotels.add(rs.getString("Name of The Hotel : "));
            }
        }
        catch( Exception e){
            e.printStackTrace();
        }

        JLabel lbperson = new JLabel("Total Person");
        lbperson.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lbperson.setBounds(30,140,150,20);
        add(lbperson);
        tfperson = new JTextField("1");
        tfperson.setBounds(200,140,150,25);
        tfperson.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(tfperson);

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lbldays.setBounds(30,180,150,20);
        add(lbldays);
        tfdays = new JTextField("1");
        tfdays.setBounds(200,180,150,25);
        tfdays.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(tfdays);

        JLabel lblac = new JLabel("AC/ Non-AC");
        lblac.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblac.setBounds(30,220,150,20);
        add(lblac);
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(200,220,150,20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblfood.setBounds(30,260,150,20);
        add(lblfood);
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(200,260,150,20);
        add(cfood);

        JLabel lblid = new JLabel("ID ");
        lblid.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblid.setBounds(30,300,150,20);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(200,300,150,25);
        labelid.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelid);

        JLabel lblNumber = new JLabel("ID Number");
        lblNumber.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblNumber.setBounds(30,340,150,20);
        add(lblNumber);
        labelidnumber = new JLabel();
        labelidnumber.setBounds(200,340,150,25);
        labelidnumber.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelidnumber);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblPhone.setBounds(30,380,150,20);
        add(lblPhone);
        labelphone = new JLabel();
        labelphone.setBounds(200,380,150,25);
        labelphone.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelphone);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblprice.setBounds(30,420,150,20);
        add(lblprice);
        labelprice = new JLabel();
        labelprice.setBounds(200,420,150,25);
        labelprice.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelprice);

        try {
            Connection conn = new Connection();
            String  query = "select * from customer where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelidnumber.setText(rs.getString("idnumber"));
                labelphone.setText(rs.getString("phoneNo"));
            }
        }
        catch (Exception e){
            e.printStackTrace();;
        }

        chechprice = new JButton("Check Price");
        chechprice.setBackground(Color.black);
        chechprice.setForeground(Color.gray);
        chechprice.setBounds(30 ,  500 , 150 , 30);
        chechprice.addActionListener(this);
        add(chechprice);

        book = new JButton("Book Package");
        book.setBackground(Color.black);
        book.setForeground(Color.gray);
        book.setBounds(200 ,  500 , 150 , 30);
        book.addActionListener(this);
        add(book);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.gray);
        back.setBounds(130 ,  550 , 150 , 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    public static void main(String[] args) {
        new BookedHotels("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == book){
            try {
                Connection c = new Connection();
                c.s.executeUpdate("insert into bookhotel values ('"+labelusername.getText()+"'  , '"+selectHotels.getSelectedItem()+"' , '"+tfperson.getText()+"' , '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"' ,  '"+cfood.getSelectedItem()+"' , '"+labelid.getText()+"'  , '"+labelidnumber.getText()+"' , '"+labelphone.getText()+"' , '"+labelprice.getText()+"' ) ");

                JOptionPane.showMessageDialog(null , "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e1){
                e1.printStackTrace();
            }

        }
        else if( e.getSource() == chechprice){
            try {
                Connection c = new Connection();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + selectHotels.getSelectedItem() + "'");
                while ( rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int acroom = Integer.parseInt(rs.getString("acroom"));

                    int person = Integer.parseInt( tfperson.getText());
                    int days= Integer.parseInt( tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if( person * days > 0){
                        int total =0;
                        total += acselected.equals("AC") ?  acroom : 0;
                        total += foodselected.equals("Yes") ? food :0;
                        total += cost;
                        total = total * person * days;
                        labelprice.setText("Taka : " + total);
                    }
                    else{
                        JOptionPane.showMessageDialog(null , "Please enter valid values.");
                    }
                }
            }
            catch (Exception es){
                es.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
}
