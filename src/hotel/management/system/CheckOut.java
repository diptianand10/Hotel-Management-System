package hotel.management.system;

import javax.swing.*;

import java.sql.*;
import java.util.Date;
import java.awt.event.*;
import java.awt.*;

public class CheckOut extends JFrame implements ActionListener{

	Choice c1;
	JLabel roomno, checkin1, checkout1;
	JButton checkoutBtn, backBtn;
	CheckOut(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("CHECK OUT");
        text.setFont(new Font("Tahoma", Font.BOLD, 18));
		text.setBounds(100, 20, 140, 30);
		text.setForeground(Color.BLACK);
	    add(text);
		
	    JLabel id = new JLabel("Customer Id");
		id.setBounds(30, 80, 100, 30);
		id.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    add(id);
	    
	    c1 = new Choice();
        c1.setBounds(150, 80, 150, 25);
        add(c1);
        
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(30, 130, 130, 30);
        room.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(room);
		
		roomno = new JLabel();
        roomno.setBounds(150, 130, 100, 30);
		add(roomno);
		
		JLabel checkin = new JLabel("Checkin Time");
		checkin.setBounds(30, 180, 100, 30);
		checkin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(checkin);
		
		checkin1 = new JLabel();
		checkin1.setBounds(150, 180, 190, 30);
		add(checkin1);
		
		JLabel checkout = new JLabel("Checkout Time");
		checkout.setBounds(30, 230, 130, 30);
		checkout.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(checkout);
		
		Date date = new Date();
		checkout1 = new JLabel("" + date);
		checkout1.setBounds(150, 230, 190, 30);
		add(checkout1);

		checkoutBtn = new JButton("CheckOut");
		checkoutBtn.setBackground(Color.BLACK);
		checkoutBtn.setForeground(Color.WHITE);
		checkoutBtn.setBounds(30, 280, 135, 30);
		checkoutBtn.addActionListener(this);
		checkoutBtn.setFont(new Font("serif",Font.BOLD,18));
		add(checkoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		backBtn.setBounds(190, 280, 135, 30);
		backBtn.setFont(new Font("serif",Font.BOLD,18));
		backBtn.addActionListener(this);
		add(backBtn);
		
		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("id_number")); 
                roomno.setText(rs.getString("room_number"));
                checkin1.setText(rs.getString("checkin_time"));
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/checkout.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(350,50,400,250);
        add(l1);
		
		setBounds(500, 360, 800, 400);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == checkoutBtn){
			String query = "delete from customer where id_number = '"+c1.getSelectedItem()+"'";
            String query1 = "update room set availability = 'Available' where room_no = '"+roomno.getText()+"'";
            try{
            	Conn c = new Conn();
            	c.s.executeUpdate(query);
            	c.s.executeUpdate(query1);
            	
            	JOptionPane.showMessageDialog(null, "CheckOut done");
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
		new CheckOut();
	}

}
