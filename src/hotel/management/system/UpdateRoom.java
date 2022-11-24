	package hotel.management.system;

	import java.awt.*;
	import javax.swing.*;
	import java.sql.*;
	import net.proteanit.sql.*;
	import java.awt.event.*;

	public class UpdateRoom extends JFrame implements ActionListener{

		Choice c1;
		JTextField roomno1, avail1, status1;
		JButton btncheck, btnback, btnupdate;
		UpdateRoom(){
			
			
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel text = new JLabel("UPDATE ROOM STATUS");
			text.setFont(new Font("Tahoma", Font.BOLD, 18));
			text.setBounds(60, 20, 250, 30);
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
			roomno.setBounds(30, 130, 100, 20);
			roomno.setFont(new Font("Tahoma", Font.PLAIN, 15));
			add(roomno);
	                    
	        roomno1 = new JTextField();
	        roomno1.setBounds(200, 130, 150, 25);
			add(roomno1);
			
			JLabel avail = new JLabel("Availability");
			avail.setBounds(30, 180, 100, 20);
			avail.setFont(new Font("Tahoma", Font.PLAIN, 15));
			add(avail);
			
			avail1 = new JTextField();
			avail1.setBounds(200, 180, 150, 25);
			add(avail1);
			
			JLabel status = new JLabel("Cleaning Status");
			status.setBounds(30, 230, 100, 20);
			status.setFont(new Font("Tahoma", Font.PLAIN, 15));
			add(status);
			
			status1 = new JTextField();
			status1.setBounds(200, 230, 150, 25);
			add(status1);
			

			btncheck = new JButton("Check");
			btncheck.setBounds(30, 300, 110, 35);
			btncheck.setBackground(Color.BLACK);
			btncheck.setForeground(Color.WHITE);
			btncheck.addActionListener(this);
			btncheck.setFont(new Font("serif",Font.BOLD,18));
	        add(btncheck);
	        
	        btnupdate = new JButton("Update");
	        btnupdate.setBounds(150, 300, 110, 35);
	        btnupdate.setBackground(Color.BLACK);
	        btnupdate.setForeground(Color.WHITE);
	        btnupdate.addActionListener(this);
	        btnupdate.setFont(new Font("serif",Font.BOLD,18));
	        add(btnupdate);
	        
	        btnback = new JButton("Back");
	        btnback.setBounds(270, 300, 110, 35);
	        btnback.setBackground(Color.BLACK);
	        btnback.setForeground(Color.WHITE);
	        btnback.addActionListener(this);
	        btnback.setFont(new Font("serif",Font.BOLD,18));
	        add(btnback);
	        
	        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/seventh.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(500,  300,  Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(410,50,500,300);
	        add(image);
	        
			
			setBounds(400,280,980, 450);
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
	            		
	            	}
	            	
	            	
	            	 ResultSet rs1 = c.s.executeQuery("select * from room where room_no = "+roomno1.getText());
	            	 while(rs1.next()){
	            		 avail1.setText(rs1.getString("availability"));
	            		 status1.setText(rs1.getString("status"));
	            	 }
	                 
	            }catch(Exception e){
	            	e.printStackTrace();
	            }
			}else if(ae.getSource() == btnupdate){
				
				String number = c1.getSelectedItem();
				String room = roomno1.getText();
				String available = avail1.getText();
				String status2 = status1.getText();
				try{
					Conn c = new Conn();
					c.s.executeUpdate("update room set availability = '"+available+"', status = '"+status1+"' where room_no = '"+room+"'");
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
			new UpdateRoom();
		}
	}
