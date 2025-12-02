package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 680);
        add(image);

        JLabel text = new JLabel("CHANGE THE PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setBounds(220, 210, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        pintext.setBounds(150, 250, 180, 20);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(300, 250, 150, 20);
        image.add(pin);
        pin.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }

                if (pin.getPassword().length >= 4) {
                    e.consume();
                }
            }
        });

        JLabel repintext = new JLabel("Re-Enter PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Relaway", Font.BOLD, 16));
        repintext.setBounds(150, 280, 180, 20);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        repin.setBounds(300, 280, 150, 20);
        image.add(repin);

        repin.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }

                if (repin.getPassword().length >= 4) {
                    e.consume();
                }
            }
        });

        change = new JButton("Change");
        change.setBounds(350, 365, 110, 25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(150, 365, 110, 25);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 680);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.endsWith(rpin)) {
                    JOptionPane.showMessageDialog(null, "There Is Not Same PIN");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter PIN");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter PIN");
                    return;
                }

                conn con = new conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query3 = "update signupthree set pin = '" + rpin + "' where pin = '" + pinnumber + "'";

                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Change Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] arg) {
        new PinChange("").setVisible(true);
    }

}
