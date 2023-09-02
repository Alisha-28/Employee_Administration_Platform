package employee.administration.platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Splash extends JFrame implements ActionListener{
    JButton click;
    Splash(){
        super("Employee Administration Platform");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/splash1.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 270, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        click=new JButton("Click to Start");
        click.setBounds(30, 90, 130, 30);
        click.setBackground(Color.white);
        click.setForeground(new Color(39,107,178,255));
        click.setBorder(BorderFactory.createLineBorder(Color.white));
        click.addActionListener(this);
        image.add(click);
        
        setSize(500,270);
        setLocation(400,190);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == click)
        {
            setVisible(false);
            new Login();
        }
    }
    
    
    public static void main (String[] args)
    {
        new Splash();
    }
    
}
