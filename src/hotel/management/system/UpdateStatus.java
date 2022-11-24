package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class UpdateStatus extends JFrame implements ActionListener{

	Choice c1;
	JTextField roomno1, name1, checkin1, penamount1, paidamount1;
	JButton btncheck, btnback, btnupdate;
	UpdateStatus(){
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("UPDATE STATUS");
        text.setFont(new Font("Tahoma", Font.BOLD, 18));
		text.setBounds(90, 20, 200, 30);
		text.setForeground(Color.BLACK);
	    add(text);
	    
	    JLabel id = new JLabel("Customer id");
		id.setBounds(30, 80, 100, 20);
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(id);
		
		 
        c1 = new Choice();
        c1.setBounds(200, 80, 150, 25);
        add(c1);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("id_number"));    
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
      
		JLabel roomno = new JLabel("Room Number");
		roomno.setBounds(30, 120, 100, 20);
		roomno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(roomno);
                    
        roomno1 = new JTextField();
        roomno1.setBounds(200, 120, 150, 25);
		add(roomno1);
		
		JLabel name = new JLabel("Name");
		name.setBounds(30, 160, 100, 20);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(name);
		
		name1 = new JTextField();
        name1.setBounds(200, 160, 150, 25);
		add(name1);
		
		JLabel checkin = new JLabel("Check-in Time");
		checkin.setBounds(30, 200, 100, 20);
		checkin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(checkin);
		
		checkin1 = new JTextField();
		checkin1.setBounds(200, 200, 150, 25);
		add(checkin1);
		
		JLabel paidamount = new JLabel("Amount Paid");
		paidamount.setBounds(30, 240, 100, 20);
		paidamount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(paidamount);
		
		paidamount1 = new JTextField();
		paidamount1.setBounds(200, 240, 150, 25);
		add(paidamount1);
		
		JLabel penamount = new JLabel("Pending Amount");
		penamount.setBounds(30, 280, 130, 20);
		penamount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(penamount);
		
		penamount1 = new JTextField();
		penamount1.setBounds(200, 280, 150, 25);
		add(penamount1);

		btncheck = new JButton("Check");
		btncheck.setBounds(30, 340, 140, 38);
		btncheck.setBackground(Color.BLACK);
		btncheck.setForeground(Color.WHITE);
		btncheck.addActionListener(this);
		btncheck.setFont(new Font("serif",Font.BOLD,18));
        add(btncheck);
        
        btnupdate = new JButton("Update");
        btnupdate.setBounds(210, 340, 140, 38);
        btnupdate.setBackground(Color.BLACK);
        btnupdate.setForeground(Color.WHITE);
        btnupdate.addActionListener(this);
        btnupdate.setFont(new Font("serif",Font.BOLD,18));
        add(btnupdate);
        
        btnback = new JButton("Back");
        btnback.setBounds(120, 390, 140, 38);
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.WHITE);
        btnback.addActionListener(this);
        btnback.setFont(new Font("serif",Font.BOLD,18));
        add(btnback);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(400,50,500,300);
        add(l1);
		
		setBounds(430,260,980, 500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == btncheck){
			
            try{
            	
            	String str = c1.getSelectedItem();
            	Conn c = new Conn();
            	ResultSet rs = c.s.executeQuery( "select * from customer where id_number = "+str);
            	while(rs.next()){
            		roomno1.setText(rs.getString("room_number"));
            		name1.setText(rs.getString("name"));    
                    checkin1.setText(rs.getString("checkin_time"));    
                    paidamount1.setText(rs.getString("deposit"));
            	}
            	
            	
            	 ResultSet rs1 = c.s.executeQuery("select * from room where room_no = "+roomno1.getText());
            	 while(rs1.next()){
                     String totalprice = rs1.getString("price"); 
                     int pendingamount = Integer.parseInt(totalprice)- Integer.parseInt(paidamount1.getText());
                     penamount1.setText("" + pendingamount);
            	 }
                 
            }catch(Exception e){
            	e.printStackTrace();
            }
		}else if(ae.getSource() == btnupdate){
			
			String number = c1.getSelectedItem();
			String room = roomno1.getText();
			String name = name1.getText();
			String checkin = checkin1.getText();
			String paidamount = paidamount1.getText();
			try{
				Conn c = new Conn();
				c.s.executeUpdate("update customer set room_number = '"+room+"', name = '"+name+"', checkin_time = '"+checkin+"', deposit = '"+paidamount+"' where id_number = '"+number+"'");
				JOptionPane.showMessageDialog(null, "Data Updated");
                setVisible(false);
                new Reception();
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
		new UpdateStatus();
	}
}
