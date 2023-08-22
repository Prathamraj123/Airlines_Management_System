/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AMS;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author prath
 */
public class ViewCanceledTicket extends JFrame
{
    
    JTable t;
    String x[]={"Ticket ID","Source","Destination","class","Price","Flight code","Flight name","Journey Date","Journey Time","Username","Name","Reason"};
    String y[][]=new String[20][12];//to print the table
    int i=0,j=0;
    Font f;
    
    ViewCanceledTicket()
    {
        
    
    super("All canceled Details");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("Arial",Font.BOLD,16);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select * from Cancelflight";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("tid");
                y[i][j++]=rest.getString("source");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("class_name");
                y[i][j++]=rest.getString("price");
                y[i][j++]=rest.getString("fcode");
                y[i][j++]=rest.getString("fname");
                y[i][j++]=rest.getString("journey_date");
                y[i][j++]=rest.getString("journey_time");
                y[i][j++]=rest.getString("destination");
                y[i][j++]=rest.getString("name");
                 y[i][j++]=rest.getString("reason");
                
                i++;
                j=0;
                
            }
            t=new JTable(y,x);
            
            
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
          t.setFont(f);
        t.setForeground(Color.WHITE);
                t.setBackground(Color.BLACK);
                JScrollPane js=new JScrollPane(t);
                
                add(js);
      
    }
    public static void main(String args[])
    {
        new ViewCanceledTicket().setVisible(true);
    }
    
}
