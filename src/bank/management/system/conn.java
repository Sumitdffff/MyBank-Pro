package bank.management.system;

import java.sql.*; 

public class conn {
            
    Connection c;
    Statement s;
    
    public conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsysteml","root","admin");
            s =c.createStatement();
        }catch(Exception e ){
            System.out.println(e);
        }
    }
    
}
