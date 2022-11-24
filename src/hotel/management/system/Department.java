package hotel.management.system;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Department extends JFrame implements ActionListener{

	JTable tab;
	JButton b1;
	
	Department(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
        
        JLabel dept = new JLabel("Department");
        dept.setBounds(150, 10, 100, 20);
        dept.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(dept);
        
		JLabel budget = new JLabel("Budget");
		budget.setBounds(490, 10, 100, 20);
		budget.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(budget);
		
        
        tab = new JTable();
        tab.setBounds(0, 50, 700, 350);
        add(tab);
        
        try{
        	Conn c = new Conn();
        	String query = "select * from department";
			ResultSet rs = c.s.executeQuery(query);
			tab.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(260,420,150, 38);
        b1.setFont(new Font("serif",Font.BOLD,18));
        add(b1);
		
		setBounds(590,270,700,540);
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae){
		
		setVisible(false);
		new Reception();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Department();
	}
}
