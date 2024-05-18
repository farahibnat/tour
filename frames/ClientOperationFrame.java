package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class ClientOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, membershipTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox membershipTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable clientTable;
	private JScrollPane clientTableSP;
	private JPanel panel;
	private User u;
	private Color c;
	
	public ClientOperationFrame(User u)
	{
		super("Operate Clients");
		this.setBounds(100,100,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.c=new Color(224,255,255);
		
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
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,100,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No:");
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
		bg.add(maleRB);
		bg.add(femaleRB);
		
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
		
		this.membershipTypeLabel=new JLabel("Membership Type:");
		this.membershipTypeLabel.setBounds(280,250,100,30);
		this.panel.add(membershipTypeLabel);
		
		String[] item={"General Member", "Exclusive Member"};
		this.membershipTypeCMB=new JComboBox(item);
		this.membershipTypeCMB.setBounds(390,250,200,30);
		this.panel.add(membershipTypeCMB);
		
		this.addBtn=new JButton("Add Client");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update Client");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove Client");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search Client");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,350,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
	    
	    
		ClientRepo crp=new ClientRepo();
		Client[] clientList=crp.getAllClient();
		String clientData1[][]=new String[clientList.length][8];
		for(int i=0;i<clientList.length;i++)
		{
			if(clientList[i]!=null)
			{
				clientData1[i][0]=clientList[i].getUserId();
				clientData1[i][1]=clientList[i].getName();
				clientData1[i][2]=clientList[i].getGender();
				clientData1[i][3]=String.valueOf(clientList[i].getAge());
				clientData1[i][4]=clientList[i].getEmail();
				clientData1[i][5]=clientList[i].getPhoneNo();
				clientData1[i][6]=clientList[i].getAddress();
				clientData1[i][7]=clientList[i].getMembershipType();
			}
		}
		String head1[]={"ID","Name","Gender","Age","Email","Phone No","Adress","MembershipType"};
		this.clientTable=new JTable(clientData1,head1);
		this.clientTableSP=new JScrollPane(clientTable);
		this.clientTableSP.setBounds(50,380,700,200);
		this.clientTable.setEnabled(false);
		this.panel.add(clientTableSP);
		this.panel.revalidate();
		this.panel.repaint();
		this.add(panel);
		this.u=u;
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(command.equals(addBtn.getText()))
		{
			String userId,name,email,phoneNo,gender,address,securityAns,pass,membershipType;
			int age;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
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
						if(maleRB.isSelected())
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
						membershipType=membershipTypeCMB.getSelectedItem().toString();
					    
						Client c=new Client(userId,name,gender,age,email,phoneNo,address,role,securityAns,pass,membershipType);
						urp.addUser(c);
						ClientRepo crp=new ClientRepo();
					    
						crp.addClient(c);
						JOptionPane.showMessageDialog(this,"Client added successfully");
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
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		if(command.equals(updateBtn.getText()))
		{
			String userId,name,email,phoneNo,gender,address,membershipType;
			int age;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				userId=userTF.getText();
				ClientRepo crp=new ClientRepo();
				Client c=crp.searchClientByUserId(userId);
				if(c!=null)
				{
					try
					{
						name=nameTF.getText();
						email=emailTF.getText();
						phoneNo=phoneNoTF.getText();
					    
						if(maleRB.isSelected())
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
						membershipType=membershipTypeCMB.getSelectedItem().toString();
					    
						c.setName(name);
						c.setEmail(email);
						c.setPhoneNo(phoneNo);
						c.setGender(gender);
						c.setAge(age);
						c.setAddress(address);
						c.setMembershipType(membershipType);
						crp.updateClient(c);
						JOptionPane.showMessageDialog(this,"Client updated successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide valid age");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid user ID");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			if(!userTF.getText().isEmpty()) 
			{
				userId=userTF.getText();
				ClientRepo crp=new ClientRepo();
				Client c=crp.searchClientByUserId(userId);
				if(c!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					crp.removeClient(userId);
					JOptionPane.showMessageDialog(this,"Client removed successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Provide valid user ID");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide a valid userId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			if(!userTF.getText().isEmpty())
			{
				userId=userTF.getText();
				ClientRepo crp=new ClientRepo();
				Client c=crp.searchClientByUserId(userId);
				if(c!=null)
				{
					userTF.setEditable(false);
					nameTF.setText(c.getName());
					emailTF.setText(c.getEmail());
					phoneNoTF.setText(c.getPhoneNo());
					if(c.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}
					if(c.getMembershipType().equals("General Member"))
					{
						membershipTypeCMB.setSelectedItem("General Member");
					}
					else
					{
						membershipTypeCMB.setSelectedItem("Exclusive Member");
					}
					ageTF.setText(String.valueOf(c.getAge()));
					addressTF.setText(c.getAddress());
					JOptionPane.showMessageDialog(this,"Client found");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Client not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to search client.");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			userTF.setEditable(true);
			userTF.setText("");
			nameTF.setText("");
			emailTF.setText("");
			phoneNoTF.setText("");
			ageTF.setText("");
			addressTF.setText("");
			securityAnsTF.setText("");
			passPF.setText("");
			JOptionPane.showMessageDialog(this,"Reset successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			EmployeeHomeFrame edf=new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			edf.setVisible(true);
		}
	}
}
