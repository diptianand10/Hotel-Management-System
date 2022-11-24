package hotel.management.system;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class SearchRoom extends JFrame implements ActionListener{

	JTable tab;
	JButton b1, b2;
	JComboBox c1;
	JCheckBox c2;
	
	SearchRoom(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel h1 = new JLabel("SEARCH FOR ROOMS");
		h1.setFont(new Font("Tahoma", Font.BOLD, 20));
		h1.setBounds(400,30,240,30);
		add(h1);
		
		JLabel bed = new JLabel("Room Bed Type");
		bed.setBounds(40, 100, 120, 20);
		bed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(bed);
		
		c1 = new JComboBox<>(new String[]{"Single Bed", "Double Bed"});
        c1.setBounds(170, 100, 150, 25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Only display Available");
        c2.setBounds(650, 100, 180, 25);
        c2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel roomno = new JLabel("Room Number");
		roomno.setBounds(50, 160, 100, 20);
		roomno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(roomno);
        
		JLabel availability = new JLabel("Availability");
		availability.setBounds(270, 160, 100, 20);
		availability.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(availability);
		
		JLabel status = new JLabel("Status");
		status.setBounds(470, 160, 100, 20);
		status.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(status);
		
		JLabel price = new JLabel("Price");
		price.setBounds(680, 160, 100, 20);
		price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(price);
		
		JLabel bed_type = new JLabel("Bed Type");
		bed_type.setBounds(870, 160, 100, 20);
		bed_type.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(bed_type);
        
        tab = new JTable();
        tab.setBounds(0, 200, 1000, 300);
        add(tab);
        
        try{
        	Conn c = new Conn();
        	String query = "select * from room";
			ResultSet rs = c.s.executeQuery(query);
			tab.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        b1 = new JButton("Search");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(320,520,150,38);
        b1.setFont(new Font("serif",Font.BOLD,18));
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(510,520,150,38);
        b2.setFont(new Font("serif",Font.BOLD,18));
        add(b2);
		
		setBounds(390,200,1000,650);
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource() == b1){
			try{
				String query = "select * from room where bed_type = '"+c1.getSelectedItem()+"'";
				String query1 = "select * from room where availability = 'Available' and bed_type = '"+c1.getSelectedItem()+"'";
				Conn c = new Conn();
				ResultSet rs;

				if(c2.isSelected()){
					rs = c.s.executeQuery(query1);
				}else{
					rs = c.s.executeQuery(query);
				}
				tab.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			setVisible(false);
			new Reception();
		}
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchRoom();
	}
}
