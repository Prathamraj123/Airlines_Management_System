/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AMS;

/**
 *
 * @author prath
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
        
{
    //why i am using contructors each and at every place so that whenever main method is called constructor is always gets called
    JLabel l1,l2,l3,l4;
    JButton bt1,bt2;
    JPasswordField pf;
    JTextField tf;
    JFrame f;
    Login()
    {
        f=new JFrame("Login Account");
        //for background color
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);
        //creating image icon of image
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/image1.jpeg"));
        Image i1=img.getImage().getScaledInstance(580,350,Image.SCALE_SMOOTH);
        ImageIcon img2=new ImageIcon(i1);
        l1.setIcon(img2);
        //now image has been added in our frame
        
        l2=new JLabel("Username");
        l2.setBounds(120,120,150,30);
        l2.setForeground(Color.BLACK);
        
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l2);
        
        f.add(l1);
        
        l3=new JLabel("Login Account");
        l3.setBounds(190,30,500,50);
        l3.setForeground(Color.BLACK);
        
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l1.add(l3);
        
        
        l4=new JLabel("Password");
        l4.setBounds(120,170,150,30);
        l4.setForeground(Color.BLACK);
        
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l4);
        
        tf=new JTextField();
        tf.setBounds(320,120,150,30);
        l1.add(tf);
        
        
        pf=new JPasswordField();
        pf.setBounds(320,170,150,30);
        l1.add(pf);
        
        bt1=new JButton("Login");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(120,220,150,40);
        l1.add(bt1);
        
        
        
        bt2=new JButton("SignUp");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(320,220,150,40);
        l1.add(bt2);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
        
        
        
        
    }
    public static void main(String args[])
    {
        new Login();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1)
        {
            String username =tf.getText();
            String pass=pf.getText();
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="Select * from signup where username='"+username+"' and password='"+pass+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
                    new Homepage().setVisible(true);
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered wrong user name and password");
                    f.setVisible(false);
                    f.setVisible(true);
                    
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
            
        }
        if(e.getSource()==bt2)
        {
            //old framwork will get closed and new will open
            this.f.setVisible(false);
            new SignupMessage();
            
        }
        }
    
}
