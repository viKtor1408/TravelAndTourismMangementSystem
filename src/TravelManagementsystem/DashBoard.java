package TravelManagementsystem;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener
{
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails, checkPackage, bookPackage, viewPackage, viewHotels, bookHotels, viewbookedHotels, destinations, payments, calculators, notepad, about ;
    String uname;
    DashBoard(String uname){

       this.uname = uname;
      //setBounds(0,0,1600,1000);
       setExtendedState(JFrame.MAXIMIZED_BOTH); // to set the frame in full screen...
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,2000,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0,0,0,20));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,0));
        p2.add(updatePersonalDetails);


        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,100,350,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,70));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,370,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,65));
        p2.add(deletePersonalDetails);

        checkPackage = new JButton("Check Packages");
        checkPackage.setBounds(0,200,370,50);
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackage.setMargin(new Insets(0,0,0,130));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = new JButton("Book Packages");
        bookPackage.setBounds(0,250,370,50);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackage.setMargin(new Insets(0,0,0,130));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Packages");
        viewPackage.setBounds(0,300,370,50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPackage.setMargin(new Insets(0,0,0,130));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);



        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,350,370,50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewHotels.setMargin(new Insets(0,0,0,150));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotel");
        bookHotels.setBounds(0,400,370,50);
        bookHotels.setBackground(new Color(0,0,102));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookHotels.setMargin(new Insets(0,0,0,160));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewbookedHotels = new JButton("View Booked Hotel");
        viewbookedHotels.setBounds(0,450,400,50);
        viewbookedHotels.setBackground(new Color(0,0,102));
        viewbookedHotels.setForeground(Color.WHITE);
        viewbookedHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedHotels.setMargin(new Insets(0,0,0,120));
        viewbookedHotels.addActionListener(this);
        p2.add(viewbookedHotels);

        destinations = new JButton("Destination");
        destinations.setBounds(0,500,400,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0,0,0,190));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0,550,400,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0,0,0,200));
        payments.addActionListener(this);
        p2.add(payments);

        calculators = new JButton("Calculator");
        calculators.setBounds(0,600,400,50);
        calculators.setBackground(new Color(0,0,102));
        calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculators.setMargin(new Insets(0,0,0,190));
        calculators.addActionListener(this);
        p2.add(calculators);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,650,400,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0,0,0,210));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0,700,400,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0,0,0,230));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1950,1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(650, 70, 1000, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Releway", Font.BOLD, 50));
        image.add(text);


        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == addPersonalDetails)
     {
      new AddCustomer(uname);
     }else if(ae.getSource() == viewPersonalDetails){
      new ViewCustomer(uname);
     } else if(ae.getSource() == updatePersonalDetails){
      new UpdateCustomer(uname);
     }else if(ae.getSource() == checkPackage){
      new CheckPackage();
     }else if(ae.getSource() == bookPackage)
     {
      new BookPackage(uname);
     }else if(ae.getSource() == viewPackage){
      new ViewPackage(uname);

     }else if(ae.getSource() == viewHotels){
      new CheckHotels();
     } else if(ae.getSource() == destinations){
      new Destination();
     } else if (ae.getSource() == bookHotels){
      new BookHotel(uname);
     }else if(ae.getSource() == viewbookedHotels){
      new ViewBookedHotel(uname);

     }else if (ae.getSource() == payments){
      new Payment();
     }else if(ae.getSource() == notepad){

      try{
       Runtime.getRuntime().exec("notepad.exe");
      }catch (Exception e){
       e.printStackTrace();
      }

     }else if(ae.getSource() == calculators)
     {

      try{
       Runtime.getRuntime().exec("calc.exe");
      }catch (Exception e){
       e.printStackTrace();
      }
     } else if(ae.getSource() == about){
      new About();
     }
    }
    public static void main(String[] args)
    {
        new DashBoard(" ");
    }
}
