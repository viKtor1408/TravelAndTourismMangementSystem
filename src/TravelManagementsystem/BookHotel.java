package TravelManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener
{
    Choice chotel, cac, cfood;

    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkPrice, bookpackage, back;
    JTextField tfdays, tfpersons;

    String uname;
    BookHotel(String uname){
        this.uname = uname;
        setBounds(350,200,1100,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Book Hotel");
        text.setBounds(100, 10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);


        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);

        JLabel selectHotel = new JLabel("Select Hotel");
        selectHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        selectHotel.setBounds(40,110,150,20);
        add(selectHotel);

        chotel = new Choice();
        chotel.setBounds(250,110, 200, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel ");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel ttlpersons = new JLabel("Total Persons");
        ttlpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ttlpersons.setBounds(40,150,150,25);
        add(ttlpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150,200,25);
        add(tfpersons);


        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40,190,150,25);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190,200,25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/ Non-AC");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(40,230,150,25);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230, 200, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40,270,150,25);
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270, 200, 20);
        add(cfood);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 270,200,25);
        add(tfdays);


        JLabel lblid = new JLabel("id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40,310,150,25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);

        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40,350,150,25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("PhoneNo.");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40,390,150,25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelphone.setBounds(250,390,150,25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40,430,150,25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelprice.setBounds(250,430,150,25);
        add(labelprice);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+uname+"'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.black);
        checkPrice.setForeground(Color.white);
        checkPrice.setBounds(60,490,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,490,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,600,400);
        add(image);



        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkPrice){
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "'");
                while (rs.next()){
                    int cost = Integer.parseInt(rs.getString("costPerPerson"));
                    int food = Integer.parseInt(rs.getString("foodIncluded"));
                    int ac = Integer.parseInt(rs.getString("acRoom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acSelected = cac.getSelectedItem();
                    String foodSelected = cfood.getSelectedItem();

                    if(persons * days > 0){
                        int total = 0;
                        total += acSelected.equals("AC") ? ac : 0;
                        total += foodSelected.equals("Yes") ? food : 0;

                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs "+ total);
                    }else {
                        JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                    }


                }

            }catch (Exception e){
             e.printStackTrace();
            }


        }else if(ae.getSource() == bookpackage){

            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel2 values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"','"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");

                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new BookHotel("shivi");
    }
}

