package TravelManagementsystem;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

import java.sql.Connection;

public class Conn
{
    Connection c;
    Statement s;
    Conn(){

        // step 1 - Register the driver
        // step 2 = creating the connection string
        // step 3 = creating a statement
        // step 4 = executing mysql queries
        // step 5 = closing the connection

        try{

           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem1","root", "pass123");
           s = c.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
