package hotel.management.system;

import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener{
	
	JButton newCustomerbtn, roomsbtn,checkOutBtn,logOutBtn,roomStatusBtn,searchRoomBtn, checkStatusBtn, departmentbtn, allEmployeebtn, customerInfobtn;
	Reception(){
		
		setBounds(420,150,1000,800);
		setLayout(null);
		
		newCustomerbtn = new JButton("New Customer Form");
		newCustomerbtn.setBounds(10, 30, 270, 40);
		newCustomerbtn.setBackground(Color.WHITE);
		newCustomerbtn.setForeground(Color.BLACK);
		newCustomerbtn.setFont(new Font("serif",Font.BOLD,25));
		newCustomerbtn.addActionListener(this);
		add(newCustomerbtn);
	
		roomsbtn = new JButton("Rooms");
		roomsbtn.setBounds(10, 100, 270, 40);
		roomsbtn.setBackground(Color.WHITE);
		roomsbtn.setForeground(Color.BLACK);
		roomsbtn.setFont(new Font("serif",Font.BOLD,25));
		roomsbtn.addActionListener(this);
		add(roomsbtn);
		
		departmentbtn = new JButton("Department");
		departmentbtn.setBounds(10, 170, 270, 40);
		departmentbtn.setBackground(Color.WHITE);
		departmentbtn.setForeground(Color.BLACK);
		departmentbtn.setFont(new Font("serif",Font.BOLD,25));
		departmentbtn.addActionListener(this);
		add(departmentbtn);
		
		allEmployeebtn = new JButton("All Employee Info");
		allEmployeebtn.setBounds(10, 240, 270, 40);                
		allEmployeebtn.setBackground(Color.WHITE);
		allEmployeebtn.setForeground(Color.BLACK);
		allEmployeebtn.setFont(new Font("serif",Font.BOLD,25));
		allEmployeebtn.addActionListener(this);
		add(allEmployeebtn);
		
		customerInfobtn = new JButton("Customer Info");
		customerInfobtn.setBounds(10, 310, 270, 40);
		customerInfobtn.setBackground(Color.WHITE);
		customerInfobtn.setForeground(Color.BLACK);
		customerInfobtn.setFont(new Font("serif",Font.BOLD,25));
		customerInfobtn.addActionListener(this);
		add(customerInfobtn);
		
		checkOutBtn = new JButton("Check Out");
		checkOutBtn.setBounds(10, 380, 270, 40);
		checkOutBtn.setBackground(Color.WHITE);
		checkOutBtn.setForeground(Color.BLACK);
		checkOutBtn.setFont(new Font("serif",Font.BOLD,25));
		checkOutBtn.addActionListener(this);
		add(checkOutBtn);
		
		checkStatusBtn = new JButton("Update Check Status");
		checkStatusBtn.setBounds(10, 450, 270, 40);
		checkStatusBtn.setBackground(Color.WHITE);
		checkStatusBtn.setForeground(Color.BLACK);
		checkStatusBtn.setFont(new Font("serif",Font.BOLD,25));
		checkStatusBtn.addActionListener(this);
		add(checkStatusBtn);
		
		roomStatusBtn = new JButton("Update Room Status");
		roomStatusBtn.setBounds(10, 520, 270, 40);
		roomStatusBtn.setBackground(Color.WHITE);
		roomStatusBtn.setForeground(Color.BLACK);
		roomStatusBtn.setFont(new Font("serif",Font.BOLD,25));
		roomStatusBtn.addActionListener(this);
        add(roomStatusBtn);

		
		searchRoomBtn = new JButton("Search Room");
		searchRoomBtn.setBounds(10, 590, 270, 40);
		searchRoomBtn.setBackground(Color.WHITE);
		searchRoomBtn.setForeground(Color.BLACK);
		searchRoomBtn.setFont(new Font("serif",Font.BOLD,25));
		searchRoomBtn.addActionListener(this);
		add(searchRoomBtn);

		logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(10, 660, 270, 40);
		logOutBtn.setBackground(Color.WHITE);
		logOutBtn.setForeground(Color.BLACK);
		logOutBtn.setFont(new Font("serif",Font.BOLD,25));
		logOutBtn.addActionListener(this);
		add(logOutBtn);
	
		
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/reception.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,800);
        add(image);
        
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == newCustomerbtn){
			setVisible(false);
			new NewCustomer();
		}else if(ae.getSource() == roomsbtn){
			setVisible(false);
			new Rooms();
		}else if(ae.getSource() == departmentbtn){
			setVisible(false);
			new Department();
		}else if(ae.getSource() == allEmployeebtn){
			setVisible(false);
			new Employee();
		}else if(ae.getSource() == customerInfobtn){
			setVisible(false);
			new CustomerInfo();
		}else if(ae.getSource() == searchRoomBtn){
			setVisible(false);
			new SearchRoom();
		}else if(ae.getSource() == checkStatusBtn){
			setVisible(false);
			new UpdateStatus();
		}else if(ae.getSource() == roomStatusBtn){
			setVisible(false);
			new UpdateRoom();
		}else if(ae.getSource() == checkOutBtn){
			setVisible(false);
			new CheckOut();
		}else if(ae.getSource() == logOutBtn){
			setVisible(false);
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Reception();
	}

}
