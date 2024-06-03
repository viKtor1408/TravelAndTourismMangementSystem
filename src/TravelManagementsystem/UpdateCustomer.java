package TravelManagementsystem;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener
{
    JLabel labelusername, labelname;


    JButton update, back;

    JTextField tfnumber, tfcountry, tfaddress, tfEmail, tfPhone, tfid, tfgender;

    Choice id;

    UpdateCustomer(String uname)
    {
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Customer Details");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahome", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150,25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(220, 90,150,25);
        add(tfid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);


        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);


        labelname = new JLabel();
        labelname.setBounds(220, 170,150,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150,25);
        add(tfgender);

        JLabel country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        add(country);


        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250,150,25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);


        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290,150,25);
        add(tfaddress);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30,330,150,25);
        add(lblEmail);


        tfEmail = new JTextField();
        tfEmail.setBounds(220, 330,150,25);
        add(tfEmail);

        JLabel lblPhone = new JLabel("PhoneNo.");
        lblPhone.setBounds(30,370,150,25);
        add(lblPhone);


        tfPhone = new JTextField();
        tfPhone.setBounds(220, 370,150,25);
        add(tfPhone);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setBounds(70,430,100,25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(380,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40,380, 400);
        add(image);


        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username ='"+uname+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("emailID"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){

            String username = labelusername.getText();
            String iD = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();

            try{
                Conn c = new Conn();

                String query = "update  customer set username = '"+username+"',id = '"+iD+"', number =  '"+number+"', name = '"+name+"', gender = '"+gender+"', country =  '"+country+"', address =  '"+address+"', emailID =  '"+email+"', phone = '"+phone+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer details updated successfully");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            setVisible(false);
        }


    }

    public static void main(String[] args)
    {
        new UpdateCustomer("shivi");
    }

}

