package TravelManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener
{
    JButton create, back;
    Choice security;
    JTextField tfans,tfusername,tfname,tfpass;

    SignUp()
    {
        setBounds(500,300,1000,446);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(80, 144, 152));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel lbusername = new JLabel("Username");
        lbusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbusername.setBounds(50,20,125,25);
        p1.add(lbusername);

        tfusername = new JTextField();
        tfusername.setBounds(190,20,200, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lbname = new JLabel("Name");
        lbname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbname.setBounds(50,60,125,25);
        p1.add(lbname);

        tfname = new JTextField();
        tfname.setBounds(190,60,200, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lbpass = new JLabel("Password");
        lbpass.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbpass.setBounds(50,100,125,25);
        p1.add(lbpass);

        tfpass = new JTextField();
        tfpass.setBounds(190,100,200, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);

        JLabel scpues = new JLabel("Security Question");
        scpues.setFont(new Font("Tahoma", Font.BOLD, 14));
        scpues.setBounds(50,140,125,25);
        p1.add(scpues);

        security = new Choice();
        security.add("Fav Character from Panchayat");
        security.add("Fav marvel super Hero");
        security.add("Your Lucky Number");
        security.add("Fav childhood super hero");
        security.setBounds(190,140,200,35);
        p1.add(security);

        JLabel scans = new JLabel("Security Answer");
        scans.setFont(new Font("Tahoma", Font.BOLD, 14));
        scans.setBounds(50,180,125,25);
        p1.add(scans);

        tfans = new JTextField();
        tfans.setBounds(190,180,200, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);

        create = new JButton("Create");
        create.setBackground(new Color(58, 58, 72, 170));
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80,250,130,30);
        create.setBorder(BorderFactory.createEmptyBorder());
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(new Color(58, 58, 72, 170));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250,250,130,30);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource() == create)
        {

            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpass.getText();
            String question = security.getSelectedItem();
            String answer = tfans.getText();

            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate(query);// step 4 = executing the mysql query

                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new Login();
            }catch(Exception e)
            {

              e.printStackTrace();
            }

        }else if(ae.getSource() == back)
        {
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {

        new SignUp();
    }


}
