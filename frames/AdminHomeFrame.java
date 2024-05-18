package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminHomeFrame extends JFrame implements ActionListener
{
	private JButton b1, adminBtn, employeeBtn, clientBtn,hotelBtn,roomBtn,payBtn,bookingBtn,bookingLineBtn,profileBtn,passBtn;
	private JLabel label;
	private Font f;
	private JPanel panel, btnListPanel;
	private Color c;
	private User u;
	public AdminHomeFrame(User u)
	{
		super("Admin Home Frame");
		this.setBounds(100,100,800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.c= new Color(224,255,255);
		
		this.f=new Font("Arial",Font.BOLD,30);
		/*ImageIcon img1= new ImageIcon("tour.jpeg");
				
		this.panel=new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(img1.getImage(),0,0,null);
			}
		};*/
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(this.c);
		
		this.label=new JLabel("Welcome, Dear Admin!");
		this.label.setBounds(280,80,450,300);
		this.label.setFont(f);
		
		this.panel.add(label);
		
		this.btnListPanel=new JPanel();
		this.btnListPanel.setLayout(null);
		this.btnListPanel.setBounds(30,70,240,350);
		this.btnListPanel.setBackground(new Color(20,17,17));
		btnListPanel.setVisible(false);
		
		this.b1=new JButton("Home");
		this.b1.setBounds(30,20,100,30);
		this.b1.addActionListener(this);
		this.panel.add(b1);
		
		
		this.adminBtn=new JButton("Operate Admins");
		this.adminBtn.setBounds(30,30,180,20);
		this.adminBtn.addActionListener(this);
		this.btnListPanel.add(adminBtn);
		
		this.employeeBtn=new JButton("Operate Employees");
		this.employeeBtn.setBounds(30,60,180,20);
		this.employeeBtn.addActionListener(this);
		this.btnListPanel.add(employeeBtn);
		
		this.clientBtn=new JButton("View Clients");
		this.clientBtn.setBounds(30,90,180,20);
		this.clientBtn.addActionListener(this);
		this.btnListPanel.add(clientBtn);
		
		this.hotelBtn=new JButton("View Hotels");
		this.hotelBtn.setBounds(30,120,180,20);
		this.hotelBtn.addActionListener(this);
		this.btnListPanel.add(hotelBtn);
		
		this.roomBtn=new JButton("View Rooms");
		this.roomBtn.setBounds(30,150,180,20);
		this.roomBtn.addActionListener(this);
		this.btnListPanel.add(roomBtn);
		
		this.payBtn=new JButton("View Payments List");
		this.payBtn.setBounds(30,180,180,20);
		this.payBtn.addActionListener(this);
		this.btnListPanel.add(payBtn);
		
		this.bookingBtn=new JButton("View Booking List");
		this.bookingBtn.setBounds(30,210,180,20);
		this.bookingBtn.addActionListener(this);
		this.btnListPanel.add(bookingBtn);
		
		this.bookingLineBtn=new JButton("View Booking Line List");
		this.bookingLineBtn.setBounds(30,240,180,20);
		this.bookingLineBtn.addActionListener(this);
		this.btnListPanel.add(bookingLineBtn);
		
		this.profileBtn=new JButton("Update Your Profile");
		this.profileBtn.setBounds(30,270,180,20);
		this.profileBtn.addActionListener(this);
		this.btnListPanel.add(profileBtn);
		
		this.passBtn=new JButton("Update Your Password");
		this.passBtn.setBounds(30,300,180,20);
		this.passBtn.addActionListener(this);
		this.btnListPanel.add(passBtn);
		
		this.panel.add(btnListPanel);
		this.add(panel);
	//	this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if (command.equals(b1.getText()))
		{
			btnListPanel.setVisible(true);
		}
		
		if (command.equals(adminBtn.getText()))
		{
			AdminOperationFrame aof=new AdminOperationFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if (command.equals(employeeBtn.getText()))
		{
			EmployeeOperation eof= new EmployeeOperation(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}
		
		if (command.equals(clientBtn.getText()))
		{
			AdminViewClients avc= new AdminViewClients(this.u);
			this.setVisible(false);
			avc.setVisible(true);
		}
		
		if (command.equals(hotelBtn.getText()))
		{
			
			AdminViewHotel avh= new AdminViewHotel(this.u);
			this.setVisible(false);
			avh.setVisible(true);
		}
		
		if (command.equals(roomBtn.getText()))
		{
			AdminViewRoom avr= new AdminViewRoom(this.u);
			this.setVisible(false);
			avr.setVisible(true);
		}
		if (command.equals(payBtn.getText()))
		{
			AdminViewPayment avp= new AdminViewPayment(this.u);
			this.setVisible(false);
			avp.setVisible(true);
		}
		
		if (command.equals(bookingBtn.getText()))
		{
			AdminBookingLineList abl= new AdminBookingLineList(this.u);
			this.setVisible(false);
			abl.setVisible(true);
		}
		
		if (command.equals(bookingLineBtn.getText()))
		{
			AdminBookingLineList cof= new AdminBookingLineList(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		if (command.equals(profileBtn.getText()))
		{
			AdminUpdateProfileFrame aup= new AdminUpdateProfileFrame(this.u);
			this.setVisible(false);
			aup.setVisible(true);
		}
		
		if (command.equals(passBtn.getText()))
		{
			AdminUpdatePasswordFrame auf= new AdminUpdatePasswordFrame(this.u);
			this.setVisible(false);
			auf.setVisible(true);
		}
		
	}
}
