package employee.administration.platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class updateEmployee extends JFrame implements ActionListener{
    
    JTextField fname, salary, address, email, phone, desig,edu;
    JButton update, cancel;
    JLabel an, dob, name, eid;
    String employeeid;
    updateEmployee(String employeeid){
        this.employeeid=employeeid;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JPanel p=new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        add(p);
        
        Color add_button=new Color(0,128,0,255);
        
        JLabel heading=new JLabel("Update Employee");
        heading.setForeground(add_button);
        heading.setBounds(550, 40, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 32));
        p.add(heading);
        
        JLabel lblname=new JLabel("Employee Name");
        lblname.setBounds(180, 140, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblname);
        
        name=new JLabel();
        name.setBounds(320, 140, 200, 20);
        p.add(name);
        
        JLabel lblfname=new JLabel("Father's Name");
        lblfname.setBounds(180, 180, 100, 20);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblfname);
        
        fname=new JTextField();
        fname.setBounds(320, 180, 200, 20);
        p.add(fname);
        
        JLabel lbldob=new JLabel("Date of Birth");
        lbldob.setBounds(180, 220, 150, 20);
        lbldob.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lbldob);
        
        dob=new JLabel();
        dob.setBounds(320, 220, 200, 20);
        p.add(dob);
        
        JLabel lblsalary=new JLabel("Salary");
        lblsalary.setBounds(180, 260, 100, 20);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblsalary);
        
        salary=new JTextField();
        salary.setBounds(320, 260, 200, 20);
        p.add(salary);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(180, 300, 100, 20);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lbladdress);
        
        address=new JTextField();
        address.setBounds(320, 300, 200, 20);
        p.add(address);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(180, 340, 100, 20);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblemail);
        
        email=new JTextField();
        email.setBounds(320, 340, 200, 20);
        p.add(email);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(180, 380, 100, 20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblphone);
        
        phone=new JTextField();
        phone.setBounds(320, 380, 200, 20);
        p.add(phone);
        
        JLabel lbledu=new JLabel("Highest Education");
        lbledu.setBounds(700, 140, 130, 20);
        lbledu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lbledu);
        
        edu=new JTextField();
        edu.setBounds(840, 140, 200, 20);
        p.add(edu);
        
        
        JLabel lbldesig=new JLabel("Designation");
        lbldesig.setBounds(700, 180, 100, 20);
        lbldesig.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lbldesig);
        
        desig=new JTextField();
        desig.setBounds(840, 180, 200, 20);
        p.add(desig);
        
        JLabel lblan=new JLabel("Aadhar Number");
        lblan.setBounds(700, 220, 150, 20);
        lblan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblan);
        
        an=new JLabel();
        an.setBounds(840, 220, 200, 20);
        p.add(an);
        
        JLabel lblid=new JLabel("Employee ID");
        lblid.setBounds(700, 260, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        p.add(lblid);
        
        eid=new JLabel();
        eid.setBounds(840, 260, 200, 20);
        p.add(eid);
        
        try{
                Database db=new Database();
                String query="select * from employee where eid='"+employeeid+"'";
                ResultSet rs=db.s.executeQuery(query);
                while(rs.next()){
                    name.setText(rs.getString("name"));
                    fname.setText(rs.getString("fname"));
                    dob.setText(rs.getString("dob"));
                    address.setText(rs.getString("address"));
                    salary.setText(rs.getString("salary"));
                    phone.setText(rs.getString("phone"));
                    email.setText(rs.getString("email"));
                    edu.setText(rs.getString("education"));
                    an.setText(rs.getString("aadhar"));
                    desig.setText(rs.getString("designation"));
                    eid.setText(rs.getString("eid"));
                    
                }
            }catch (Exception e){
                e.printStackTrace();
        }
        
        
        
        //Buttons
        update=new JButton("Update");
        update.setBounds(500, 550, 100, 30);
        update.setBackground(add_button);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        p.add(update);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(700, 550, 100, 30);
        cancel.setBackground(Color.GRAY);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        
        
        setLayout(new BorderLayout());
        add(p, "Center");
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            
            String efname=fname.getText();
            String esalary=salary.getText();
            String ephone=phone.getText();
            String eaddress=address.getText();
            String eemail=email.getText();
            String eedu=edu.getText();
            String edesig=desig.getText();
            
            try{
                Database db=new Database();
                String query="update employee set fname='"+efname+"', salary='"+esalary+"', address='"+eaddress+"', phone='"+ephone+"', email='"+eemail+"', education='"+eedu+"', designation='"+edesig+"' where eid='"+employeeid+"'";
                db.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details Updated Successfully");
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
        new updateEmployee("");
    }
    
}
