package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class EmployeeOperation extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, designationLabel,salaryLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF,salaryTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox designationCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable employeeTable;
	private JScrollPane employeeTableSP;
	private JPanel panel;
	private User u;
	private Color c;
	
	
	public EmployeeOperation(User u)
	{
		super("Employee Operation Frame");
		this.setBounds(50,100,860,700);
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
		
		this.designationLabel=new JLabel("Designation:");
		this.designationLabel.setBounds(280,250,100,30);
		this.panel.add(designationLabel);
		
		String[] item={"Hr Employee", "Manager"};
		this.designationCMB=new JComboBox(item);
		this.designationCMB.setBounds(390,250,200,30);
		this.panel.add(designationCMB);
		
		this.salaryLabel=new JLabel("Salary:");
		this.salaryLabel.setBounds(500,50,60,30);
		this.panel.add(salaryLabel);
		
		this.salaryTF=new JTextField();
		this.salaryTF.setBounds(590,50,100,30);
		this.panel.add(salaryTF);
		
		
		this.addBtn=new JButton("Add Employee");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update Employee");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove Employee");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search Employee");
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
		
		
		EmployeeRepo arp=new EmployeeRepo();
		Employee[] employeeList=arp.getAllEmployee();

		String employeeData1[][]=new String[employeeList.length][9];
		for(int i=0;i<employeeList.length;i++)
		{
		
			if(employeeList[i]!=null)
			{
				System.out.println(employeeList[i].toStringEmployee());
				employeeData1[i][0]=employeeList[i].getUserId();
				employeeData1[i][1]=employeeList[i].getName();
				employeeData1[i][2]=employeeList[i].getGender();
				employeeData1[i][3]=String.valueOf(employeeList[i].getAge());
				employeeData1[i][4]=employeeList[i].getEmail();
				employeeData1[i][5]=employeeList[i].getPhoneNo();
				employeeData1[i][6]=employeeList[i].getAddress();
				employeeData1[i][7]=employeeList[i].getDesignation();
				employeeData1[i][8]=String.valueOf(employeeList[i].getSalary());
			}
			
			
			
		}
		
		String head1[]={"Id","Name","Email","PhoneNo","Gender","Age","Adress","Designation","Salary"};
		
		this.employeeTable=new JTable(employeeData1,head1);
		this.employeeTableSP=new JScrollPane(employeeTable);
		this.employeeTableSP.setBounds(50,380,790,200);
		this.employeeTable.setEnabled(false);
		this.panel.add(employeeTableSP);
		
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
			String userId,name,email,phoneNo,gender,address,securityAns,pass,designation;
			int age;
			double salary;
			
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!salaryTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
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
						salary=Double.parseDouble(salaryTF.getText());
						int role=2;
						
						securityAns=securityAnsTF.getText();
						
						pass=passPF.getText();
						designation=designationCMB.getSelectedItem().toString();
						Employee e=new Employee(userId,name,gender,age,email,phoneNo,address,role,securityAns,pass,designation,salary);
						urp.addUser(e);
						EmployeeRepo arp=new EmployeeRepo();
						arp.addEmployee(e);
						JOptionPane.showMessageDialog(this,"Employee added Successfully");
					}
					catch(Exception e)
					{
			
						JOptionPane.showMessageDialog(this,"Provide valid age and salary");
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
			
			String userId,name,email,phoneNo,gender,address,designation;
			int age;
			double salary;
			
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())  && (!salaryTF.getText().isEmpty()))
			{
				
				userId=userTF.getText();
				EmployeeRepo arp=new EmployeeRepo();
				Employee a=arp.searchEmployeeByUserId(userId);
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
						
						designation=designationCMB.getSelectedItem().toString();
						salary=Double.parseDouble(salaryTF.getText());
						
						a.setName(name);
						a.setEmail(email);
						a.setPhoneNo(phoneNo);
						a.setGender(gender);
						a.setAge(age);
						a.setAddress(address);
						a.setDesignation(designation);
						a.setSalary(salary);
						
						arp.updateEmployee(a);
						
						JOptionPane.showMessageDialog(this,"Employee updated successfully");
					}
					catch(Exception e)
					{
						
						JOptionPane.showMessageDialog(this,"Provide valid age and salary");
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
				
				EmployeeRepo arp=new EmployeeRepo();
				
				Employee a=arp.searchEmployeeByUserId(userId);

				if(a!=null)
				{
					
					UserRepo urp=new UserRepo();
					
					urp.removeUser(userId);
					
					arp.removeEmployee(userId);
					
					JOptionPane.showMessageDialog(this,"Employee removed Successfully");
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
				
				EmployeeRepo urp=new EmployeeRepo();
				
				Employee a=urp.searchEmployeeByUserId(userId);
				
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
					
					if(a.getDesignation().equals("Hr Employee"))
					{
						designationCMB.setSelectedItem("Hr Employee");
					}
					else
					{
						designationCMB.setSelectedItem("Manager");
					}
			
					ageTF.setText(String.valueOf(a.getAge()));
					
					addressTF.setText(a.getAddress());
					salaryTF.setText(String.valueOf(a.getSalary()));
			
					JOptionPane.showMessageDialog(this,"employee found");
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"employee not found");
				}
			}
			
			else
			{
				
				JOptionPane.showMessageDialog(this,"Please provide userId to search employee.");
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