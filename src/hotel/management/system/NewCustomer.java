package hotel.management.system;

import javax.swing.*;
import java.sql.*;	
import java.awt.event.*;
import java.awt.*;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener{
	
	JComboBox<String> cid;
	JTextField num,name1,country1,depositt;
    JRadioButton male,female;
    Choice c1;
    JLabel checkInTime;
    JButton addBtn, backBtn;
	
	NewCustomer(){
		
		getContentPane().setBackground(Color.WHITE);
        setLayout(null);
		
		JLabel title = new JLabel("NEW CUSTOMER FORM");
		title.setFont(new Font("Yu Mincho", Font.BOLD, 20));
		title.setBounds(100,20,300,30);
		add(title);
                
        JLabel id = new JLabel("Id");
		id.setBounds(35,80,100,20);
		id.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(id);
                
        String id1[] = {"Passport", "Aadhar Card", "Voter Id", "Driving license"};
		cid = new JComboBox<>(id1);
        cid.setBounds(200,80,150,25);
        cid.setBackground(Color.WHITE);
		add(cid);
                
        JLabel number = new JLabel("Number");
		number.setBounds(35, 120, 100, 20);
		number.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(number);
                
        num = new JTextField();
		num.setBounds(200,120,150,25);
		add(num);
		
		JLabel name = new JLabel("Name");
		name.setBounds(35, 160, 100, 20);
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(name);
		
		name1 = new JTextField();
		name1.setBounds(200,160,150,25);
		add(name1);

                
		JLabel gender = new JLabel("Gender");
		gender.setBounds(35, 200, 100, 20);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(gender);
                
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 14));
        male.setBackground(Color.WHITE);
        male.setBounds(200, 200, 60, 25);
        add(male);
                
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 14));
        female.setBackground(Color.WHITE);
        female.setBounds(270, 200, 100, 25);
		add(female);
                
		JLabel country = new JLabel("Country");
		country.setBounds(35, 240, 100, 20);
		country.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(country);
		
		country1 = new JTextField();
		country1.setBounds(200,240, 150, 25);
		add(country1);
		
		JLabel roomNumber = new JLabel("Room Number");
		roomNumber.setBounds(35,280,140,20);
		roomNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(roomNumber);
                
        c1 = new Choice();
        try{
	          Conn c = new Conn();
	          String query = "select * from room where availability= 'Available'";
	          ResultSet rs = c.s.executeQuery(query);
	          while(rs.next()){
	           c1.add(rs.getString("room_no"));    
	          }
        }
        catch(Exception e){ 
        	e.printStackTrace();
        }
        c1.setBounds(200,280,150,25);
		add(c1);
		
		JLabel checkIn = new JLabel("Checked-In");
		checkIn.setBounds(35, 320, 150, 20);
		checkIn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(checkIn);
		
		Date date = new Date();
		
		checkInTime = new JLabel("" + date);
		checkInTime.setBounds(200, 320, 150, 25);
		add(checkInTime);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setBounds(35, 360, 100, 20);
		deposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(deposit);
		
		depositt = new JTextField();
		depositt.setBounds(200, 360,150,25);
		add(depositt);

		addBtn = new JButton("Add");
		addBtn.setBackground(Color.BLACK);
		addBtn.setForeground(Color.WHITE);
		addBtn.setBounds(35, 410, 150, 38);
		addBtn.setFont(new Font("serif",Font.BOLD,18));
		addBtn.addActionListener(this);
		add(addBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		backBtn.setBounds(200, 410, 150, 38);
		backBtn.setFont(new Font("serif",Font.BOLD,18));
		backBtn.addActionListener(this);
		add(backBtn);
                
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/customer.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 58, 350, 400);
        add(image);
                
        setBounds(550,290,800,550);
        setVisible(true);
               
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == addBtn){
			String id = (String) cid.getSelectedItem();
			String num1 =  num.getText();
			String name2 =  name1.getText();
            String gender1 =  null;
            
            if(male.isSelected()){ 
                gender1 = "Male";
            }
            else if(female.isSelected()){ 
                gender1 = "Female";
            }
            
			String country2 =  country1.getText();
			String roomno =  c1.getSelectedItem();
            String time =  checkInTime.getText();
            String deposit1 = depositt.getText();
            
            try{
            	
            	String q1 = "insert into customer values('"+id+"','"+num1+"','"+name2+"','"+gender1+"','"+country2+"','"+roomno+"','"+time+"','"+deposit1+"')";
                String q2 = "update room set availability = 'Occupied' where room_no = "+roomno;
                Conn c = new Conn();
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added");
            	setVisible(false);
            	new Reception();
            	
            }catch(Exception e){
            	e.printStackTrace();
            }
		}else if (ae.getSource() == backBtn){
			setVisible(false);
			new Reception();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewCustomer();
	}

}
