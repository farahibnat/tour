package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class LoginFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel,userIdLabel, passwordLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, signupBtn, forgetpassBtn;
	private JPanel panel;
	private Color c;
	
	public LoginFrame()
	{
	super("Login frame");
	//this.setLayout(null);
	//this.setVisible(true);
	this.setBounds(100,100,800,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.c= new Color(224,255,255);

	this.panel=new JPanel();
	this.panel.setLayout(null);
	this.panel.setBackground(this.c);
	
	this.titleLabel=new JLabel("WELCOME TO OUR TOURIST SITE");
	this.titleLabel.setForeground(Color.BLACK);
	this.titleLabel.setFont(new Font("Ralway",Font.BOLD,25));;
	this.titleLabel.setBounds(230,115,700,40);
	this.panel.add(titleLabel);
	
	this.userIdLabel=new JLabel("User Id:");
	this.userIdLabel.setForeground(Color.BLACK);
	//this.userIdLabel.setFont(new Font("Ralway",Font.BOLD,25));
	this.userIdLabel.setBounds(150,190,375,30);
	this.panel.add(userIdLabel);
	
	this.userTF=new JTextField();
    this.userTF.setBounds(325,190,230,30);
	//this.TF.setFont(new Font("Arial",Font.BOLD,14));
	this.panel.add(userTF);
	
    this.passwordLabel=new JLabel("Password :");
	this.passwordLabel.setForeground(Color.BLACK);
	//this.passwordLabel.setFont(new Font("Ralway",Font.BOLD,25));
	this.passwordLabel.setBounds(150,250,375,30);
	this.panel.add(passwordLabel);
	
	this.passPF=new JPasswordField();
	this.passPF.setBounds(325,250,230,30);
	//this.PF.setFont(new Font("Arial",Font.BOLD,14));
	this.panel.add(passPF);
	
	this.loginBtn=new JButton("Login");
	//this.loginBtn.setFont(new Font("Ralway",Font.BOLD,14));
	this.loginBtn.setForeground(Color.WHITE);
	this.loginBtn.setBackground(Color.BLACK);
	this.loginBtn.setBounds(300,350,100,30);
	this.loginBtn.addActionListener(this);
	this.panel.add(loginBtn);
	
	this.exitBtn=new JButton("Exit");
	//this.clearBtn.setFont(new Font("Arial",Font.BOLD,14));
	this.exitBtn.setForeground(Color.WHITE);
	this.exitBtn.setBackground(Color.BLACK);
	this.exitBtn.setBounds(430,350,100,30);
	this.exitBtn.addActionListener(this);
	this.panel.add(exitBtn);
	
	
	this.signupBtn=new JButton("Sign Up");
	//this.signupBtn.setFont(new Font("Arial",Font.BOLD,14));
	this.signupBtn.setForeground(Color.WHITE);
	this.signupBtn.setBackground(Color.BLACK);
	this.signupBtn.setBounds(370,400,100,30);
	this.signupBtn.addActionListener(this);
	this.panel.add(signupBtn);

	this.forgetpassBtn=new JButton("Forgot Password");
	//this.forgetpassBtn.setFont(new Font("Arial",Font.BOLD,14));
	this.forgetpassBtn.setForeground(Color.WHITE);
	this.forgetpassBtn.setBackground(Color.BLACK);
	this.forgetpassBtn.setBounds(300,450,230,30);
	this.forgetpassBtn.addActionListener(this);
	this.panel.add(forgetpassBtn);
	
	this.add(panel);
 
	}

	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			String uId=userTF.getText();
			String pass=passPF.getText();
			UserRepo urp=new UserRepo();
			User user=urp.searchUserByUserId(uId);
			if(user!=null)
			{
				if((user.getUserId().equals(uId))&&(user.getPassword().equals(pass))&&(user.getRole()==1))
				{
					AdminHomeFrame ahf=new AdminHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
				
				else if((user.getUserId().equals(uId))&&(user.getPassword().equals(pass))&&(user.getRole()==2))
				{
					EmployeeHomeFrame ahf=new EmployeeHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
				
				else if((user.getUserId().equals(uId))&&(user.getPassword().equals(pass))&&(user.getRole()==3))
				{
					ClientHomeFrame ahf=new ClientHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
				
				
				
			 else
				{
					JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
				}
				
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
			}
		}
		
		if(command.equals(signupBtn.getText()))
		{
			SignupFrame sf=new SignupFrame();
			this.setVisible(false);
			sf.setVisible(true);
		}
		
		if(command.equals(forgetpassBtn.getText()))
		{
			ForgetPassFrame fpf=new ForgetPassFrame();
			this.setVisible(false);
			fpf.setVisible(true);
		}
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
	
}
	
	
	
	
	
	
	
