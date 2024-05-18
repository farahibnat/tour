package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class SignupFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JButton addBtn, backBtn;
	private JPanel panel;
	private Color c;
	public SignupFrame()
	{
	super("Admin Operation Frame");
	this.setSize(800,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.c= new Color(224,255,255);
	
	this.panel=new JPanel();
	this.panel.setLayout(null);
	this.panel.setBackground(this.c);
	
	this.userIdLabel=new JLabel("User Id:");
	this.userIdLabel.setBounds(50,50,60,30);
	this.panel.add(userIdLabel);
	
	this.userTF=new JTextField();
	this.userTF.setBounds(120,50,100,30);
	this.panel.add(userTF);
	
	this.nameLabel=new JLabel("Name:");
	this.nameLabel.setBounds(50,100,60,30);
	this.panel.add(nameLabel);
	
	this.nameTF=new JTextField();
	this.nameTF.setBounds(120,100,100,30);
	this.panel.add(nameTF);
	
	this.emailLabel=new JLabel("email:");
	this.emailLabel.setBounds(50,150,60,30);
	this.panel.add(emailLabel);
	
	this.emailTF=new JTextField();
	this.emailTF.setBounds(120,150,100,30);
	this.panel.add(emailTF);
	
	this.phoneNoLabel=new JLabel("phone No:");
	this.phoneNoLabel.setBounds(50,200,60,30);
	this.panel.add(phoneNoLabel);
	
	this.phoneNoTF=new JTextField();
	this.phoneNoTF.setBounds(120,200,100,30);
	this.panel.add(phoneNoTF);
	
	this.genderLabel=new JLabel("Gender:");
	this.genderLabel.setBounds(50,250,60,30);
	this.panel.add(genderLabel);
	
	this.maleRB=new JRadioButton("Male");
	this.maleRB.setBounds(120,250,60,30);
	this.panel.add(maleRB);
	
	this.femaleRB=new JRadioButton("Female");
	this.femaleRB.setBounds(190,250,80,30);
	this.panel.add(femaleRB);
	
	this.bg=new ButtonGroup();
	this.bg.add(maleRB);
	this.bg.add(femaleRB);
	
	this.ageLabel=new JLabel("Age:");
	this.ageLabel.setBounds(50,300,60,30);
	this.panel.add(ageLabel);
	
	this.ageTF=new JTextField();
	this.ageTF.setBounds(120,300,100,30);
	this.panel.add(ageTF);
	
	this.addressLabel=new JLabel("Address:");
	this.addressLabel.setBounds(280,50,60,30);
	this.panel.add(addressLabel);
	
	this.addressTF=new JTextField();
	this.addressTF.setBounds(350,50,100,30);
	this.panel.add(addressTF);
	
	this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?:");
	this.securityQuesLabel.setBounds(280,100,300,30);
	this.panel.add(securityQuesLabel);
	
	this.securityAnsLabel=new JLabel("Security Ans:");
	this.securityAnsLabel.setBounds(280,150,100,30);
	this.panel.add(securityAnsLabel);
	
	this.securityAnsTF=new JTextField();
	this.securityAnsTF.setBounds(390,150,100,30);
	this.panel.add(securityAnsTF);
	
	this.passLabel=new JLabel("Password:");
	this.passLabel.setBounds(280,200,100,30);
	this.panel.add(passLabel);
	
	this.passPF=new JPasswordField();
	this.passPF.setBounds(390,200,100,30);
	this.panel.add(passPF);
	
	this.addBtn=new JButton("Submit");
	this.addBtn.setBounds(50,350,100,30);
	this.addBtn.addActionListener(this);
	this.panel.add(addBtn);
	
	this.backBtn=new JButton("back");
	this.backBtn.setBounds(160,350,100,30);
	this.backBtn.addActionListener(this);
	this.panel.add(backBtn);
	this.add(panel);
 
}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			String userId,name,email,phoneNo,gender,address,securityAns,pass;
			int age;
			
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) && ((maleRB.isSelected())||(femaleRB.isSelected()))&& (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
	
				userId=userTF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if(user==null)
				{
					try
					{
					
						name=nameTF.getText();
						email=emailTF.getText();
						phoneNo=phoneNoTF.getText();
						if (maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
						else
						{
							gender=maleRB.getText();
						}
						age=Integer.parseInt(ageTF.getText());
				
						address=addressTF.getText();
					
						int role=3;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
			
						Client c1=new Client(userId,name,gender,age,email,phoneNo,address,role,securityAns,pass,"General Member");
						urp.addUser(c1);
						ClientRepo c2=new ClientRepo();
						c2.addClient(c1);
						JOptionPane.showMessageDialog(this,"Client signed up successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide valid age");
					}
				
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}
		
			}
			else
			{
				
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
			
		}
		
		
		
		
		
		
		if(command.equals(backBtn.getText()))
		{
			
			LoginFrame adframe=new LoginFrame();
			this.setVisible(false);
			adframe.setVisible(true);
		}
	}
	
}