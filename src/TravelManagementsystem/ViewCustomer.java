package TravelManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewCustomer extends JFrame implements ActionListener
{
    JButton back;

    JLabel labelusername, labelid, labelnumber, labelname, labelcountry, labelgender, labeladdress, labelphone, labelemail ;
    ViewCustomer(String uname){
        setBounds(520,180,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblid = new JLabel("id");
        lblid.setBounds(30,110,150,25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(220,290,150,25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500,50,150,25);
        add(lblcountry);

        labelcountry = new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500,110,150,25);
        add(lbladdress);

        labeladdress = new JLabel();
        labeladdress.setBounds(690,110,150,25);
        add(labeladdress);

        JLabel lblphone = new JLabel("PhoneNo.");
        lblphone.setBounds(500,170,150,25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(690,170,150,25);
        add(labelphone);

        JLabel lblemail = new JLabel("E-mail");
        lblemail.setBounds(500,230,150,25);
        add(lblemail);

        labelemail = new JLabel();
        labelemail.setBounds(690,230,150,25);
        add(labelemail);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,400,900,200);
        add(image);



        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+uname+"'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("emailID"));
                labeladdress.setText(rs.getString("address"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new ViewCustomer("shivi");
    }
}
