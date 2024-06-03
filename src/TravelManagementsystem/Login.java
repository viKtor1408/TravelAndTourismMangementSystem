package TravelManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp, fgpass;

    JTextField tfusername, tfpassword;
    Login(){
       setSize(1000,500);
       setLocation(500,300);
       setLayout(null);

       getContentPane().setBackground(Color.WHITE);

       JPanel p1 = new JPanel();
       p1.setBackground(new Color(99, 172, 225));
       p1.setBounds(0,0,440,500);
       p1.setLayout(null);
       add(p1);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
       Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(100,110,200,200);
       p1.add(image);

       JPanel p2 = new JPanel();
       p2.setLayout(null);
       p2.setBounds(440,30,490,380);
       add(p2);

       JLabel lblusername = new JLabel("Username: ");
       lblusername.setBounds(60,20,120,25);
       lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
       p2.add(lblusername);

       tfusername = new JFormattedTextField();
       tfusername.setBounds(60,60,300,30);
       tfusername.setBorder(BorderFactory.createEmptyBorder());
       p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password: ");
        lblpassword.setBounds(60,120,120,25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

        tfpassword = new JFormattedTextField();
        tfpassword.setBounds(60,160,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60,240,130,30);
        login.setBackground(new Color(82, 160, 209));
        login.setForeground(Color.WHITE);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);

        signUp = new JButton("SignUp");
        signUp.setBounds(230,240,130,30);
        signUp.setBackground(new Color(82, 160, 209));
        signUp.setForeground(Color.WHITE);
        signUp.setBorder(BorderFactory.createEmptyBorder());
        signUp.addActionListener(this);
        p2.add(signUp);

        fgpass = new JButton("Forget Password");
        fgpass.setBounds(130,300,130,30);
        fgpass.setBackground(new Color(82, 160, 209));
        fgpass.setForeground(Color.WHITE);
        fgpass.setBorder(BorderFactory.createEmptyBorder());
        fgpass.addActionListener(this);
        p2.add(fgpass);

        JLabel trbl = new JLabel("Trouble in Signing...");
        trbl.setBounds(260,310,150,20);
        trbl.setForeground(Color.RED);
        p2.add(trbl);



        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login)
        {
            try
            {
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";

                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next())
                {
                    setVisible(false);
                    new Loading(username);
                }else {

                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password..");
                }

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if( ae.getSource() == signUp){
            setVisible(false);
            new SignUp();
        }else
        {
            setVisible(false);
            new ForgetPassword();
        }

    }

    public static void main(String[] args) {
       new Login();
    }

}
