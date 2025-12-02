package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class signupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    signupThree(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("1.Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,110,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(120,150,180,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,150,250,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(120,190,180,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,190,250,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("2.Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,230,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4123");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,230,250,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,250,200,30);
        add(carddetail);
        
        JLabel pin = new JLabel("3.Pin Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,280,200,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,280,200,30);
        add(pnumber);
        
        JLabel pindetail = new JLabel("Your 4 Digit Pin Number");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,300,200,30);
        add(pindetail);
        
        JLabel services = new JLabel("4.Service Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,330,250,30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(120,370,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,370,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(120,410,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,410,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(120,450,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,450,200,30);
        add(c6);
        
        c7 = new JCheckBox("I her by declares that the about details are correct to the best of my knowloge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,500,500,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("raleway",Font.BOLD,14));
        submit.setBounds(200,560,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("raleway",Font.BOLD,14));
        cancel.setBounds(420,560,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,660);
        setLocation(250,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit) {
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Fixe Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
            
           Random random = new Random();
           String cardnumber =""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
           String pinnumber  =""+Math.abs((random.nextLong()%9000L)+1000L);
           String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM card";
            }else if(c2.isSelected()){
                facility = facility + " Internet";
            }else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + " Email Alerts";
            }else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }else if(c6.isSelected()){
                facility = facility + " E-Statement";
            }
           
            try{
                if (accountType == null || accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                    } else  {
                    conn con = new conn();
                    String queryl = "insert into Signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    
                    con.s.executeUpdate(queryl);
                    con.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null," Card Number: " + cardnumber + "\n pin:" + pinnumber );
                
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                
                }
            }catch(Exception e){
                System.out.println(e);
            }
           
        }else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String arg[]){
        new signupThree("");
    }
    
}
