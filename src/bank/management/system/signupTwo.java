package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener {

    JTextField aadharTextField, panTextField;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    JButton next;
    String formno;

    signupTwo(String formno) {

        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");

        JLabel AdditionalDetails = new JLabel("Page 2:Additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AdditionalDetails.setBounds(290, 40, 400, 30);
        add(AdditionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 110, 100, 30);
        add(name);

        String vaiReligion[] = {"Hindu", "Gugarathi", "maratha", "punjabi", "other"};
        religion = new JComboBox(vaiReligion);
        religion.setBounds(300, 110, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 150, 200, 30);
        add(fname);

        String valcategory[] = {"open", "obc", "sc/st"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 150, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);

        String incomecategory[] = {"Null", "<1,50,000", "<2,00,000", "<5,00,000", "upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 190, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 230, 200, 30);
        add(gender);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 230, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 270, 200, 30);
        add(marital);

        String occupationValue[] = {"Salaried", "Self Employed", "Bussiness", "student", "Other"};
        occupation = new JComboBox(occupationValue);
        occupation.setBounds(300, 270, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 310, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 310, 400, 30);
        add(panTextField);


        JLabel aadhar = new JLabel("Aadhar number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 350, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 350, 400, 30);
        add(aadharTextField);

        aadharTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
                if (aadharTextField.getText().length() >= 12) {
                    e.consume(); 
                }

            }
        });

        JLabel senior = new JLabel("Senior cititen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 390, 200, 30);
        add(senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 390, 60, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 390, 70, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 430, 200, 30);
        add(existing);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 430, 60, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 430, 70, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);

        next = new JButton("next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(620, 540, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 660);
        setLocation(250, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try {
            conn c = new conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + seniorcitizen + "','" + existingaccount + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String arg[]) {

        new signupTwo("");
    }

}
