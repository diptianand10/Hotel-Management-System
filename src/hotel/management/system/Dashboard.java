package hotel.management.system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Dashboard extends JFrame implements ActionListener{

	Dashboard(){
		setBounds(0,0,1920,1080);
		setLayout(null);
		

      
		
		JButton reception = new JButton("RECEPTION"); 
		reception.setBounds(150,400,260,50);
		reception.setFont(new Font("serif",Font.BOLD,25));
		reception.setBackground(Color.WHITE);
		reception.setForeground(Color.RED);
		reception.addActionListener(this);
        add(reception);
		
        JButton room = new JButton("ADD ROOMS"); 
        room.setBounds(1500,300,260,50);
        room.setFont(new Font("serif",Font.BOLD,25));
        room.setBackground(Color.WHITE);
        room.setForeground(Color.RED);
        room.addActionListener(this);
        add(room);
        
        JButton employee = new JButton("ADD EMPLOYEE"); 
        employee.setBounds(1500,500,260,50);
        employee.setFont(new Font("serif",Font.BOLD,25));
        employee.setBackground(Color.WHITE);
        employee.setForeground(Color.RED);
        employee.addActionListener(this);
        add(employee);
        
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920,1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);
        
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getActionCommand().equals("ADD EMPLOYEE")){
			new AddEmployee();
		}else if (ae.getActionCommand().equals("ADD ROOMS")){
			new AddRooms();
		}else if (ae.getActionCommand().equals("RECEPTION")){
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dashboard();
	}

}
