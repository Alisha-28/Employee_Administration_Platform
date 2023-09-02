package employee.administration.platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class deleteEmployee extends JFrame implements ActionListener{
    
    Choice eid;
    JButton delete, cancel;
    JLabel name, phone, email;
    JTextArea area;
    deleteEmployee(){
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JPanel p=new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        add(p);
        
        Color delete_button=new Color(200,0,0,255);
        
        JLabel heading=new JLabel("Delete Employee");
        heading.setForeground(delete_button);
        heading.setBounds(550, 40, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 32));
        p.add(heading);
        
        JLabel lbleid=new JLabel("Employee ID");
        lbleid.setBounds(180, 180, 130, 20);
        lbleid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lbleid);
        
        eid=new Choice();
        eid.setBounds(320, 180, 200, 20);
        p.add(eid);
        
        try{
            Database db=new Database();
            ResultSet rs=db.s.executeQuery("select * from employee");
            
            while(rs.next()){
                eid.add(rs.getString("eid"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel lblname=new JLabel("Employee Name");
        lblname.setBounds(180, 220, 140, 20);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblname);
        
        name=new JLabel();
        name.setBounds(320, 220, 200, 20);
        p.add(name);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(180, 260, 150, 20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblphone);
        
        phone=new JLabel();
        phone.setBounds(320, 260, 200, 20);
        p.add(phone);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(180, 300, 100, 20);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblemail);
        
        email=new JLabel();
        email.setBounds(320, 300, 200, 20);
        p.add(email);
        
        try{
            Database db=new Database();
            ResultSet rs=db.s.executeQuery("select * from employee where eid='"+eid.getSelectedItem()+"'");
            
            while(rs.next()){
               name.setText(rs.getString("name"));
               phone.setText(rs.getString("phone"));
               email.setText(rs.getString("email"));
               
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        area=new JTextArea();
        area.setBounds(800, 200, 400, 500);
        area.setFont(new Font("Tahoma", Font.PLAIN, 22));
        area.setForeground(delete_button);
        area.setEditable(false);
        p.add(area);
        
        area.setText("WARNING: Deleting an Employee's records from the database is an irreversible action. Make sure to double check the Employee's ID before clicking on the Delete button");
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
        //Buttons
        delete=new JButton("Delete");
        delete.setBounds(500, 450, 100, 30);
        delete.setBackground(delete_button);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        p.add(delete);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(700, 450, 100, 30);
        cancel.setBackground(Color.GRAY);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        eid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Database db=new Database();
                    ResultSet rs=db.s.executeQuery("select * from employee where eid='"+eid.getSelectedItem()+"'");

                    while(rs.next()){
                       name.setText(rs.getString("name"));
                       phone.setText(rs.getString("phone"));
                       email.setText(rs.getString("email"));

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
        
            }
            
        });
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Database db=new Database();
                String query="delete from employee where eid='"+eid.getSelectedItem()+"'";
                db.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Records Deleted Successfully");
                setVisible(false);
                }catch (Exception e){
                    e.printStackTrace();
                }
            
        }
        else{
            setVisible(false);
        }
}
    
    public static void main(String []args){
        new deleteEmployee();
    }
    
}
