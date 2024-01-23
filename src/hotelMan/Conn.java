package hotelMan;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement st;
    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","root");
            System.out.println("Connection Created");
            st= c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
