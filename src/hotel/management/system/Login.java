package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	
	JTextField username, password;
	JButton login, cancel;
	
	Login(){
//		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setBounds(40,40,100,30);
		add(user);
		
		username = new JTextField();
		username.setBounds(170,40,150,30);
		add(username);
		
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40,90,100,30);
		add(pass);
		
		password = new JTextField();
		password.setBounds(170,90,150,30);
		add(password);
		
		login = new JButton("Login"); 
        login.setBounds(40,170,120,30);
        login.setFont(new Font("serif",Font.BOLD,15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel =new JButton("Cancel");
        cancel.setBounds(190,170,120,30);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,25,200,200);
        add(image);
		
		setBounds(600,400,600,300);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
        	try{
                Conn c = new Conn();
                String user = username.getText();
                String pass = password.getText();
                
                String query = "select * from login where username='"+ user +"' and password='"+ pass +"'";
                
                ResultSet rs = c.s.executeQuery(query); 
                if(rs.next()){ 
                    
                    setVisible(false);
                    new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect username and password");
//                    setVisible(false);
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
        	setVisible(false);
        }
        
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
