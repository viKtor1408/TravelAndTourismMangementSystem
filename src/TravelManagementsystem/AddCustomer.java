package TravelManagementsystem;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener
{
    JLabel labelusername, labelname;
    JRadioButton rmale, rfemale;

    JButton add, back;

    JTextField tfnumber, tfcountry, tfaddress, tfEmail, tfPhone;

    Choice id;

    AddCustomer(String uname)
    {
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150,25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        id = new Choice();
        id.add("Passport");
        id.add("Aadhar Card");
        id.add("Pan Card");
        id.add("Ration Card");
        id.setBounds(220,90,150,25);
        id.setBackground(Color.WHITE);
        add(id);

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

        rmale= new JRadioButton("Male");
        rmale.setBounds(220, 210,70,25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210,70,25);
        rfemale.setBackground(Color.white);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

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

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40,400, 500);
        add(image);


        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username ='"+uname+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){

            String username = labelusername.getText();
            String iD = id.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();

            try{
                Conn c = new Conn();

                String query = "insert into customer values('"+username+"','"+iD+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+email+"', '"+phone+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer detail added successfully");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new AddCustomer("shivi");
    }

}
