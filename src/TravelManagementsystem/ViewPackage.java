package TravelManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener
{
    JButton back;

    JLabel labelusername, labelpackage, labelnumber, labelprice,labelphone, labelid, labelpersons ;
    ViewPackage(String uname){
        setBounds(420,200,900,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("View Package Details");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0,300,30);
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,90,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,90,150,25);
        add(labelusername);

        JLabel lblpackname = new JLabel("Package Name");
        lblpackname.setBounds(30,130,150,25);
        add(lblpackname);

        labelpackage = new JLabel();
        labelpackage.setBounds(220,130,150,25);
        add(labelpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30,170,150,25);
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(220,170,150,25);
        add(labelpersons);

        JLabel lblid = new JLabel("id");
        lblid.setBounds(30,210,150,25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220,210,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30,250,150,25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220,250,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("PhoneNo.");
        lblphone.setBounds(30,290,150,25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(220,290,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,330,150,25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(220,330,150,25);
        add(labelprice);



        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);



        try {
            Conn c = new Conn();
            String query = "select * from bookpackage where username = '"+uname+"'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));


                labelphone.setText(rs.getString("phone"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));

                labelpersons.setText(rs.getString("persons"));
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
        new ViewPackage("shivi");
    }
}

