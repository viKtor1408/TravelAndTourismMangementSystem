package TravelManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener
{
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;

    JButton search, rtrieve, back;
    ForgetPassword()
    {

        setBounds(500,300,1000,446);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(330,330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(630,40,330,330);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,580,340);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,40,120,30);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(230, 42, 180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.white);
        search.setBounds(450, 42, 100, 25);
        search.addActionListener(this);
        p1.add(search);

        JLabel name = new JLabel("Name");
        name.setBounds(40,80,120,30);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(name);

        tfname = new JTextField();
        tfname.setBounds(230, 82, 180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblqueation = new JLabel("Your Security Question");
        lblqueation.setBounds(40,120,180,25);
        lblqueation.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblqueation);

        tfquestion = new JTextField();
        tfquestion.setBounds(230, 122, 180,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lblanswer = new JLabel("Security Answer");
        lblanswer.setBounds(40,162,180,25);
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblanswer);

        tfanswer= new JTextField();
        tfanswer.setBounds(230, 162, 180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        rtrieve = new JButton("Retrieve");
        rtrieve.setBackground(Color.GRAY);
        rtrieve.setForeground(Color.white);
        rtrieve.setBounds(450, 162, 100, 25);
        rtrieve.addActionListener(this);
        p1.add(rtrieve);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,202,180,25);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblpassword);

        tfpassword= new JTextField();
        tfpassword.setBounds(230, 202, 180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.white);
        back.setBounds(170, 280, 100, 25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource() == search)
     {

         try{
             String query = "select * from account where username = '"+tfusername.getText()+"'";
             Conn c = new Conn();

             ResultSet rs = c.s.executeQuery(query);

             while(rs.next()){

                 tfname.setText(rs.getString("name"));
                 tfquestion.setText(rs.getString("security"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }
     } else if (ae.getSource() == rtrieve)
     {
         try{
             String query = "select * from account where answer = '"+tfanswer.getText()+"' and username = '"+tfusername.getText()+"'";
             Conn c = new Conn();

             ResultSet rs = c.s.executeQuery(query);

             while(rs.next()){

                 tfpassword.setText(rs.getString("password"));

             }
         }catch(Exception e){
             e.printStackTrace();
         }
     } else
     {
         setVisible(false);
         new Login();
     }

    }
    public static void main(String[] args) {
        new ForgetPassword();
    }
}
