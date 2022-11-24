package hotel.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
	
	    JTextField roomnof, pricef;
	    JComboBox<String> availablecb, cleancb, bedtypecb;
	    JButton add,cancel;
		
	    AddRooms(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
        
		JLabel text = new JLabel("ADD ROOMS");
        text.setFont(new Font("Tahoma", Font.BOLD, 18));
		text.setBounds(150, 20, 200, 20);
	    add(text);
	         
		JLabel roomno = new JLabel("Room Number");
		roomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomno.setBounds(60, 80, 120, 30);
		add(roomno);
	          
		roomnof = new JTextField();
	    roomnof.setBounds(200,80,150,30);
		add(roomnof);
	        
		JLabel available = new JLabel("Availability");
		available.setFont(new Font("Tahoma", Font.PLAIN, 16));
		available.setBounds(60,130,120,30);
		add(available);
	        
		String s[] = {"Available", "Occupied"};
	    availablecb = new JComboBox<>(s);
	    availablecb.setBounds(200,130,150,30);
	    availablecb.setBackground(Color.WHITE);
		add(availablecb);
	
	
		JLabel l3 = new JLabel("Cleaning Status");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l3.setBounds(60, 180, 120, 30);
		add(l3);
	    
		String st[] = {"Clean", "Dirty"};
	    cleancb = new JComboBox<>(st);
	    cleancb.setBounds(200, 180, 150, 30);
	    cleancb.setBackground(Color.WHITE);
		add(cleancb);
	
		JLabel price = new JLabel("Price");
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		price.setBounds(60, 230, 120, 30);
		add(price);
	        
	    pricef = new JTextField();
	    pricef.setBounds(200, 230, 150, 30);
		add(pricef);
	
	    JLabel bedtype = new JLabel("Bed Type");
	    bedtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    bedtype.setBounds(60,280,120,30);
		add(bedtype);
	
		String str[] = { "Single Bed", "Double Bed"};
	    bedtypecb = new JComboBox<>(str);
	    bedtypecb.setBounds(200,280,150,30);
	    bedtypecb.setBackground(Color.WHITE);
		add(bedtypecb);
	
		add = new JButton("ADD ROOM");
		add.addActionListener(this);
		add.setBounds(60,350,140,38);
	    add.setBackground(Color.BLACK);
	    add.setForeground(Color.WHITE);
	    add.setFont(new Font("serif",Font.BOLD,18));
		add(add);
	
		cancel = new JButton("CANCEL");
		cancel.addActionListener(this);
		cancel.setBounds(220,350,140,38);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("serif",Font.BOLD,18));
		add(cancel);

		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/twelve.jpg"));
        JLabel l15 = new JLabel(i1);
        l15.setBounds(400,60,500,300);
        add(l15);

     
        setBounds(470,300,940,470);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
            
            if(ae.getSource() == add){
                
                String roomno = roomnof.getText();
                String availablity = (String)availablecb.getSelectedItem();
                String status = (String)cleancb.getSelectedItem();
                String price  = pricef.getText();
                String bedtype = (String)bedtypecb.getSelectedItem();
                String query = "insert into room values( '"+roomno+"', '"+availablity+"', '"+status+"','"+price+"', '"+bedtype+"')";
              
                try{
                Conn c = new Conn();      
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Room Added");
                setVisible(false);
               
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            else{
                setVisible(false);
            }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddRooms();
	}

}
