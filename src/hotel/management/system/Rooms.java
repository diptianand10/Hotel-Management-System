package hotel.management.system;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Rooms extends JFrame implements ActionListener{

	JTable tab;
	JButton b1;
	
	Rooms(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(540,0,600,600);
        add(image);
        
        JLabel roomno = new JLabel("Room Number");
		roomno.setBounds(10, 10, 140, 20);
		roomno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(roomno);
        
		JLabel availability = new JLabel("Availability");
		availability.setBounds(130, 10, 100, 20);
		availability.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(availability);
		
		JLabel status = new JLabel("Status");
		status.setBounds(240, 10, 100, 20);
		status.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(status);
		
		JLabel price = new JLabel("Price");
		price.setBounds(360, 10, 100, 20);
		price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(price);
		
		JLabel bed_type = new JLabel("Bed Type");
		bed_type.setBounds(450, 10, 100, 20);
		bed_type.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(bed_type);
        
        tab = new JTable();
        tab.setBounds(0, 60, 530, 400);
        add(tab);
        
        try{
        	Conn c = new Conn();
        	String query = "select * from room";
			ResultSet rs = c.s.executeQuery(query);
			tab.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(200,500,150,38);
		b1.setFont(new Font("serif",Font.BOLD,18));
        add(b1);
		
		setBounds(390,240,1050,600);
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae){
		
		setVisible(false);
		new Reception();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rooms();
	}
}
