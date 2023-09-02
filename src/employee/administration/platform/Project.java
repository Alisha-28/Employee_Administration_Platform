package employee.administration.platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    JButton add, view, update, delete, logout;
    Project()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        Color add_button=new Color(0,128,0,255);
        Color view_button=new Color(0,0,128,255);
        Color update_button=new Color(220,110,0,255);
        Color delete_button=new Color(200,0,0,255);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/project1.png"));
        Image i2=i1.getImage().getScaledInstance(1300, 850, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JLabel heading=new JLabel("Employee Administration Platform");
        heading.setBounds(700, 80, 800, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 32));
        image.add(heading);
        
        add=new JButton("Add Employee");
        add.setBackground(new Color(243,246,240,255));
        add.setForeground(add_button);
        add.setBorder(BorderFactory.createLineBorder(add_button));
        add.setBounds(750, 200, 170, 60);
        add.setFont(new Font("Raleway", Font.BOLD, 17));
        add.addActionListener(this);
        image.add(add);
        
        view=new JButton("View Employees");
        view.setBackground(new Color(243,246,240,255));
        view.setForeground(view_button);
        view.setBorder(BorderFactory.createLineBorder(view_button));
        view.setBounds(980, 200, 170, 60);
        view.setFont(new Font("Raleway", Font.BOLD, 17));
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("Update Employee");
        update.setBackground(new Color(243,246,240,255));
        update.setForeground(update_button);
        update.setBorder(BorderFactory.createLineBorder(update_button));
        update.setBounds(750, 350, 170, 60);
        update.setFont(new Font("Raleway", Font.BOLD, 17));
        update.addActionListener(this);
        image.add(update);
        
        delete=new JButton("Delete Employee");
        delete.setBackground(new Color(243,246,240,255));
        delete.setForeground(delete_button);
        delete.setBorder(BorderFactory.createLineBorder(delete_button));
        delete.setBounds(980,350, 170, 60);
        delete.setFont(new Font("Raleway", Font.BOLD, 17));
        delete.addActionListener(this);
        image.add(delete);
        
        logout=new JButton("Log Out");
        logout.setForeground(Color.white);
        logout.setBackground(Color.darkGray);
        logout.setBounds(860,500, 170, 60);
        logout.setFont(new Font("Raleway", Font.BOLD, 17));
        logout.addActionListener(this);
        image.add(logout);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if (msg.equals("Add Employee")){
           new addEmployee();
        }
        else if (msg.equals("View Employees")){
            new viewEmployees();
        }
        else if (msg.equals("Update Employee")){
            new viewEmployees();
        }
        else if (msg.equals("Delete Employee")){
            
            new deleteEmployee();
        } 
        
        else if (msg.equals("Log Out")){
            setVisible(false);
            new Login();
        } 
    }
    
    public static void main(String []args)
    {
        new Project();
    }
}

