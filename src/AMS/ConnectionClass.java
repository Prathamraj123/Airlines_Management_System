
package AMS;

/**
 *
 * @author prath
 */
import java.sql.*;

public class ConnectionClass 
{
    Connection con;
    Statement stm;
    ConnectionClass()
    {
//try catch is important so that if any error comes it will be handled by try and catch statement
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","system");
            stm=con.createStatement();
            
            
        }
        catch(Exception e)
        {
            //Exception ko automatic handle kr leta h
            e.printStackTrace();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String args[])
        {
            new ConnectionClass();
            
        }
    
    
}
