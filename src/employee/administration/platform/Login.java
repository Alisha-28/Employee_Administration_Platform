package employee.administration.platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, cancel;
    JTextField username, password;
    
    
    Login()
    {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Color logincolor=new Color(52,181,86);
        Color cancelcolor=new Color(212,32,32);
        
        //Labels
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(300, 50, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblusername);
        
        username=new JTextField();
        username.setBounds(400, 50, 150, 25);
        add(username);
        
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(300, 90, 100, 25);
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblpassword);
        
        password=new JTextField();
        password.setBounds(400, 90, 150, 25);
        add(password);
        
        //Buttons
        
        login=new JButton("Login");
        login.setBackground(logincolor);
        login.setForeground(Color.WHITE);
        login.setBounds(300, 170, 100, 25);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(cancelcolor);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450, 170, 100, 25);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login1.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(45,15,210,200);
        add(image);
        
        setSize(640,300);
        setLocation(350,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login)
        {
            String cuser=username.getText();
            String cpass=password.getText();
            
            try {
                Database db=new Database();
                String query="select * from login where username='"+cuser+"' and password= '"+cpass+"'";
                
                ResultSet rs=db.s.executeQuery(query);
                
                if (rs.next()){
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
        else if (ae.getSource() == cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main (String[] args)
    {
        new Login();
    }
    
}

