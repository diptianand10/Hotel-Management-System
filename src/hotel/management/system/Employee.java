package hotel.management.system;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Employee extends JFrame implements ActionListener{

	JTable tab;
	JButton b1;
	
	Employee(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
        
        JLabel name = new JLabel("Name");
		name.setBounds(40, 10, 100, 20);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(name);
        
		JLabel age = new JLabel("Age");
		age.setBounds(190, 10, 100, 20);
		age.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(age);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(330, 10, 100, 20);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(gender);
		
		JLabel job = new JLabel("Job");
		job.setBounds(490, 10, 100, 20);
		job.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(job);
		
		JLabel salary = new JLabel("Salary");
		salary.setBounds(610, 10, 100, 20);
		salary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(salary);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(760, 10, 100, 20);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(phone);
		
		JLabel email = new JLabel("Email");
		email.setBounds(890, 10, 100, 20);
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(email);
        
        tab = new JTable();
        tab.setBounds(0, 40, 1000, 400);
        add(tab);
        
        try{
        	Conn c = new Conn();
        	String query = "select * from employee";
			ResultSet rs = c.s.executeQuery(query);
			tab.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(420,500,140,38);
        b1.setFont(new Font("serif",Font.BOLD,18));
        add(b1);
		
		setBounds(390,230,1000,600);
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae){
		
		setVisible(false);
		new Reception();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Employee();
	}
}
