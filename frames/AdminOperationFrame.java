package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, adminTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox adminTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private JPanel panel;
	private Color c;
	private User u;
	
	
	
	public AdminOperationFrame(User u)
	{
		super("Admin Operation Frame");
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
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your BestFriend name?:");
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
		
		this.adminTypeLabel=new JLabel("Admin Type:");
		this.adminTypeLabel.setBounds(280,250,100,30);
		this.panel.add(adminTypeLabel);
		
		String[] item={"User Managing Admin", "Employee Managing Admin"};
		this.adminTypeCMB=new JComboBox(item);
		this.adminTypeCMB.setBounds(390,250,200,30);
		this.panel.add(adminTypeCMB);
		
		this.addBtn=new JButton("Add Admin");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("update Admin");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("remove Admin");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("search Admin");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,350,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		AdminRepo arp=new AdminRepo();
		Admin[] adminList=arp.getAllAdmin();

		String adminData1[][]=new String[adminList.length][8];
		for(int i=0;i<adminList.length;i++)
		{
		
			if(adminList[i]!=null)
			{
				System.out.println(adminList[i].toStringAdmin());
				adminData1[i][0]=adminList[i].getUserId();
				adminData1[i][1]=adminList[i].getName();
				adminData1[i][2]=adminList[i].getEmail();
				adminData1[i][3]=adminList[i].getPhoneNo();
				adminData1[i][4]=adminList[i].getGender();
				adminData1[i][5]=String.valueOf(adminList[i].getAge());
				adminData1[i][6]=adminList[i].getAddress();
				adminData1[i][7]=adminList[i].getAdminType();
			}
			
			
			
		}
		
		String head1[]={"Id","Name","Email","PhoneNo","Gender","Age","Adress","AdminType"};
		
		this.adminTable=new JTable(adminData1,head1);
		this.adminTableSP=new JScrollPane(adminTable);
		this.adminTableSP.setBounds(50,380,700,200);
		this.adminTable.setEnabled(false);
		this.panel.add(adminTableSP);
		
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
			String userId,name,email,phoneNo,gender,address,securityAns,pass,adminType;
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
						
						int role=1;
						
						securityAns=securityAnsTF.getText();
						
						pass=passPF.getText();
						adminType=adminTypeCMB.getSelectedItem().toString();
						Admin a=new Admin(userId,name,gender,age,email,phoneNo,address,role,securityAns,pass,adminType);
						urp.addUser(a);
						AdminRepo arp=new AdminRepo();
						arp.addAdmin(a);
						JOptionPane.showMessageDialog(this,"Admin added Successfully");
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
			
			String userId,name,email,phoneNo,gender,address,adminType;
			int age;
			
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				
				userId=userTF.getText();
				AdminRepo arp=new AdminRepo();
				Admin a=arp.searchAdminByUserId(userId);
				if(a!=null)
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
						
						adminType=adminTypeCMB.getSelectedItem().toString();
					
						
						a.setName(name);
						a.setEmail(email);
						a.setPhoneNo(phoneNo);
						a.setGender(gender);
						a.setAge(age);
						a.setAddress(address);
						a.setAdminType(adminType);
						
						arp.updateAdmin(a);
						
						JOptionPane.showMessageDialog(this,"Admin updated Successfully");
					}
					catch(Exception e)
					{
						
						JOptionPane.showMessageDialog(this,"Provide valid age");
					}
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			
			if(!userTF.getText().isEmpty()) 
			{
				
				userId=userTF.getText();
				
				AdminRepo arp=new AdminRepo();
				
				Admin a=arp.searchAdminByUserId(userId);

				if(a!=null)
				{
					
					UserRepo urp=new UserRepo();
					
					urp.removeUser(userId);
					
					arp.removeAdmin(userId);
					
					JOptionPane.showMessageDialog(this,"Admin removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please Provide a valid userId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			
		
			if(!userTF.getText().isEmpty())
			{
				
				userId=userTF.getText();
				
				AdminRepo urp=new AdminRepo();
				
				Admin a=urp.searchAdminByUserId(userId);
				
				if(a!=null)
				{
					
					userTF.setEditable(false);
					
					nameTF.setText(a.getName());
					
					emailTF.setText(a.getEmail());
					
					phoneNoTF.setText(a.getPhoneNo());
					
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
					
					if(a.getAdminType().equals("User Managing Admin"))
					{
						adminTypeCMB.setSelectedItem("User Managing Admin");
					}
					else
					{
						adminTypeCMB.setSelectedItem("Employee Managing Admin");
					}
			
					ageTF.setText(String.valueOf(a.getAge()));
					
					addressTF.setText(a.getAddress());
			
					JOptionPane.showMessageDialog(this,"Admin found");
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"Admin not found");
				}
			}
			
			else
			{
				
				JOptionPane.showMessageDialog(this,"Please provide userId to search admin.");
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
			JOptionPane.showMessageDialog(this,"reset successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
	
}
