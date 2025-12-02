package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    Transaction(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,680);
        add(image);
        
        JLabel text = new JLabel("Please select your Tranaction");
        text.setBounds(190,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Relaway",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(150,315,130,22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Whitdraw");
        withdrawl.setBounds(320,315,130,22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150,340,130,22);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(320,340,130,22);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(150,365,130,22);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(320,365,130,22);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("EXIT");
        exit.setBounds(235,390,130,22);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(800,680);
        setLocation(300,0);
        setVisible(true);
         
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource()== balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()== ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String[] arg){
        new Transaction("");
    }
    
}
