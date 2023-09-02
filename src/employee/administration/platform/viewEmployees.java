package employee.administration.platform;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class viewEmployees extends JFrame implements ActionListener{
    
    
    JTable table;
    JButton search, print, update, back, all;
    Choice eid;
    viewEmployees(){
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        Color view_button=new Color(0,0,128,255);
        Color update_button=new Color(220,110,0,255);
        
        JLabel lbleid=new JLabel("Search by Employee ID");
        lbleid.setBounds(20, 20, 150, 20);
        lbleid.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(lbleid);
        
        eid=new Choice();
        eid.setBounds(200, 20, 150, 20);
        add(eid);
        
        try{
            Database db=new Database();
            ResultSet rs=db.s.executeQuery("select * from employee");
            
            while(rs.next()){
                eid.add(rs.getString("eid"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        table=new JTable();
        
        try{
            Database db=new Database();
            ResultSet rs=db.s.executeQuery("select * from employee");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,100,1285, 550);
        add(sp);
        
        search= new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.setBackground(view_button);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);
        
        print= new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update= new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.setBackground(update_button);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        back= new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        all= new JButton("Show All");
        all.setBounds(1120, 70, 120, 20);
        all.setBackground(view_button);
        all.setForeground(Color.white);
        all.addActionListener(this);
        add(all);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search)
        {
            String query="select * from employee where eid='"+eid.getSelectedItem()+"'";
            try
                {
                    Database db=new Database();
                    ResultSet rs=db.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print)
        {
            try
                {
                    table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new updateEmployee(eid.getSelectedItem());
            
            
            
        }
        else if(ae.getSource()==back){
            setVisible(false);
        }
        else if(ae.getSource()==all){
            try{
                Database db=new Database();
                ResultSet rs=db.s.executeQuery("select * from employee");
            
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main (String[] args){
        new viewEmployees();
    }
}

