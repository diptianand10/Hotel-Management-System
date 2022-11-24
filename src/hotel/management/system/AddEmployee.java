package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField namef,agef,salaryf, emailf, phonef;
	JRadioButton male,female;
	JButton submit;
	JComboBox<String> jobs;
	
	
	AddEmployee(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("ADD EMPLOYEES");
        text.setFont(new Font("Tahoma", Font.BOLD, 18));
		text.setBounds(150, 20, 200, 20);
	    add(text);
		
		JLabel name = new JLabel("Name");
		name.setBounds(60,55,120,30);
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(name);
		
		namef = new JTextField();
		namef.setBounds(200,55,150,30);
		add(namef);
		
		JLabel age = new JLabel("Age");
		age.setBounds(60,105,120,30);
		age.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(age);
		
		agef = new JTextField();
		agef.setBounds(200,105,150,30);
		add(agef);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(60,155,120,30);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(200,155,70,30);
		male.setFont(new Font("Tahoma", Font.PLAIN, 12));
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(280,155,70,30);
		female.setFont(new Font("Tahoma", Font.PLAIN, 12));
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup b = new ButtonGroup();
		b.add(male);
		b.add(female);
		
		JLabel job = new JLabel("Job");
		job.setBounds(60,205,120,30);
		job.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(job);
		
		String s[] = {"Hotel Manager", "Event Planner", "Accounting staff", "Room Attendant", "Receptionist", "Spa manager", "House keeper", "Host/Hostess", "Waiter/Waitress", "Chef", "Porters", "Room Service" , "Kitchen Staff", "Kitchen manager"};
		jobs = new JComboBox<>(s);
		jobs.setBounds(200,205,150,30);
		jobs.setBackground(Color.WHITE);
		add(jobs);
		
		JLabel salary = new JLabel("Salary");
		salary.setBounds(60,255,120,30);
		salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(salary);
		
		salaryf = new JTextField();
		salaryf.setBounds(200,255,150,30);
		add(salaryf);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(60,305,120,30);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(phone);
		
		phonef = new JTextField();
		phonef.setBounds(200,305,150,30);
		add(phonef);
		
		JLabel email = new JLabel("Email");
		email.setBounds(60,355,120,30);
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(email);
		
		emailf = new JTextField();
		emailf.setBounds(200,355,150,30);
		add(emailf);
		
		submit =new JButton("SUBMIT");
		submit.setBounds(140,425,150,38);
		submit.setFont(new Font("serif",Font.BOLD,18));
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
		
		getContentPane().setBackground(Color.WHITE);;
		setBounds(510,250,850,540);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
        String name = namef.getText();
        String age = agef.getText();
        String salary = salaryf.getText();
        String email = emailf.getText();
        String phone = phonef.getText();
        
        String gender = null;
        if(male.isSelected()){
        	gender = "Male";
        }else if (female.isSelected()){
        	gender = "Female";
        }
        
        String job = (String)jobs.getSelectedItem();
        try{
        	Conn c = new Conn();
            String query = "insert into employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"', '"+email+"')";
            
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Added");
            setVisible(false);
            
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new AddEmployee();

	}

}