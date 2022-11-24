package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

        
        HotelManagementSystem() {
		

                setBounds(450,250,1000,600);
                setLayout(null);

                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/hotelicon.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel image = new JLabel(i2);
                image.setBounds(0,0,1000,600);
                add(image);
                
                JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
                text.setBounds(80, 200, 1000, 130);
                text.setForeground(Color.BLACK);
                text.setFont(new Font("serif", Font.BOLD, 55));
                image.add(text);
                
                JButton next = new JButton("Login");
                next.setBounds(800, 490, 150, 50);
                next.setBackground(Color.WHITE);
                next.setForeground(Color.BLACK);
                next.addActionListener(this);
                next.setFont(new Font("serif", Font.PLAIN, 30));
                image.add(next);
                
                setVisible(true);
                
                while(true){
                    text.setVisible(false); 
                try{
                    Thread.sleep(500); 
                }catch(Exception e){} 
                    text.setVisible(true);
                try{
                    Thread.sleep(500);
                }catch(Exception e){
                	e.printStackTrace();
                }
            }

	}
        
        public void actionPerformed(ActionEvent ae){
            new Login().setVisible(true);
            this.setVisible(false);
            
    }
        public static void main(String args[]){
        	new HotelManagementSystem();
        }

}
