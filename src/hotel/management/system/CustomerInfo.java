package hotel.management.system;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class CustomerInfo extends JFrame implements ActionListener{
	
	JLabel doc, num, name, gender, country, room, status, deposit;
    JButton b1;
	
	CustomerInfo(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		doc = new JLabel("Document");
		doc.setBounds(50,10,100,20);
		doc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(doc);
                
        num = new JLabel("Number");
		num.setBounds(250,10,100,20);
		num.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(num);
		
		name = new JLabel("Name");
		name.setBounds(410,10,100,20);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(name);
		
		gender = new JLabel("Gender");
		gender.setBounds(590,10,100,20);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(gender);
		
		country = new JLabel("Country");
		country.setBounds(760,10,100,20);
		country.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(country);
		
		room = new JLabel("Room");
		room.setBounds(950,10,100,20);
		room.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(room);
		
		status = new JLabel("Check-in Status");
		status.setBounds(1100,10,100,20);
		status.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(status);
		
		deposit = new JLabel("Deposit");
		deposit.setBounds(1290,10,100,20);
		deposit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(deposit);
		
		JTable table = new JTable();
		table.setBounds(0, 40, 1400,400);
		add(table);
		
		try{
        	Conn c = new Conn();
        	String query = "select * from customer";
			ResultSet rs = c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
        	e.printStackTrace();
        }
		
		b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(650,500,150,38);
        b1.setFont(new Font("serif",Font.BOLD,20));
        add(b1);
        
        setBounds(300,200,1400,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
				
			setVisible(false);
			new Reception();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerInfo();
	}

}
