package TravelManagementsystem;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable
{
    Thread t;
    String uname;

    JProgressBar bar;
    public void run()
    {

        try{

            for(int i = 1; i <= 101; i++)
            {

                int max = bar.getMaximum();// 100
                int value = bar.getValue();

                if(value<max)
                {

                    bar.setValue(bar.getValue() + 1);

                }else
                        {

                            setVisible(false);
                            new DashBoard(uname);
                        }
                Thread.sleep(50);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    Loading(String uname)
    {
        this.uname = uname;

        t  = new Thread(this);
        setBounds(600,300,700,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new  JLabel("Travel and Tourism Application");
        text.setBounds(80,20, 1000, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(180,100,300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new  JLabel("Loading, please wait....");
        loading.setBounds(250,140, 180, 30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel username = new  JLabel("Welcome " +uname);
        username.setBounds(20,340, 400, 40);
        username.setForeground(Color.red);
        username.setFont(new Font("Raleway", Font.BOLD, 20));
        add(username);

        t.start();

        setVisible(true);
    }


    public static void main(String[] args)
    {
        new Loading(" ");
    }
}
