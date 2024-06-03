package TravelManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener
{
    Choice cpackage;

    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkPrice, bookpackage, back;
    JTextField tfpersons;

    String uname;
    BookPackage(String uname){
        this.uname = uname;
      setBounds(350,200,1100,500);
      getContentPane().setBackground(Color.white);
      setLayout(null);

      JLabel text = new JLabel("Book Package");
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

        JLabel selectPack = new JLabel("Select Package");
        selectPack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        selectPack.setBounds(40,110,150,20);
        add(selectPack);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110, 200, 20);
        add(cpackage);


        JLabel ttlpersons = new JLabel("Total Persons");
        ttlpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ttlpersons.setBounds(40,150,150,25);
        add(ttlpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150,200,25);
        add(tfpersons);

        JLabel lblid = new JLabel("id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40,190,150,25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);

        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40,230,150,25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("PhoneNo.");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40,270,150,25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelphone.setBounds(250,270,150,25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40,310,150,25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelprice.setBounds(250,310,150,25);
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
        checkPrice.setBounds(60,380,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);



        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkPrice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){

                cost = 32000;
            }else if(pack.equals("Silver Package")){

                cost = 25000;
            }else if(pack.equals("Bronze Package")){

                cost = 12000;

            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs" +cost);

        }else if(ae.getSource() == bookpackage){

            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");

                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new BookPackage("shivi");
    }
}
