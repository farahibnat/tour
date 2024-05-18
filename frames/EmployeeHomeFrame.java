package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class EmployeeHomeFrame extends JFrame implements ActionListener
{
	private JButton b1, bookBtn, payingBtn, clientBtn,hotelBtn,roomBtn,payBtn,bookingBtn,bookingLineBtn,profileBtn,passBtn;
	private JLabel label;
	private Font f;
	private JPanel panel, btnListPanel;
	private Color c;
	private User u;
	public EmployeeHomeFrame(User u)
	{
		super("Employee Home Frame");
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
		
		this.label=new JLabel("Welcome, Dear Employee!");
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
		
		
		this.clientBtn=new JButton("Operate Clients");
		this.clientBtn.setBounds(30,30,180,20);
		this.clientBtn.addActionListener(this);
		this.btnListPanel.add(clientBtn);
		
		this.hotelBtn=new JButton("Operate Hotels");
		this.hotelBtn.setBounds(30,60,180,20);
		this.hotelBtn.addActionListener(this);
		this.btnListPanel.add(hotelBtn);
		
		this.roomBtn=new JButton("Operate Rooms");
		this.roomBtn.setBounds(30,90,180,20);
		this.roomBtn.addActionListener(this);
		this.btnListPanel.add(roomBtn);
		
		this.bookBtn=new JButton("Book Rooms for Clients");
		this.bookBtn.setBounds(30,120,180,20);
		//this.bookBtn.addActionListener(this);
		this.btnListPanel.add(bookBtn);
		
		this.payingBtn=new JButton("Receive Payments");
		this.payingBtn.setBounds(30,150,180,20);
		//this.payingBtn.addActionListener(this);
		this.btnListPanel.add(payingBtn);
		
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
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if (command.equals(b1.getText()))
		{
			btnListPanel.setVisible(true);
		}
		
		if (command.equals(clientBtn.getText()))
		{
			ClientOperationFrame cof= new ClientOperationFrame(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		if (command.equals(hotelBtn.getText()))
		{
			HotelOperationFrame hof= new HotelOperationFrame(this.u);
			this.setVisible(false);
			hof.setVisible(true);
		}
		
		if (command.equals(roomBtn.getText()))
		{
			RoomOperationFrame rof= new RoomOperationFrame(this.u);
			this.setVisible(false);
			rof.setVisible(true);
		}
		
		/*if (command.equals(bookBtn.getText()))
		{
			ClientOperationFrame cof= new ClientOperationFrame();
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		if (command.equals(payingBtn.getText()))
		{
			ClientOperationFrame cof= new ClientOperationFrame();
			this.setVisible(false);
			cof.setVisible(true);
		}*/
		
		if (command.equals(payBtn.getText()))
		{
			EmployeeViewPayment evp= new EmployeeViewPayment(this.u);
			this.setVisible(false);
			evp.setVisible(true);
		}
		
		if (command.equals(bookingBtn.getText()))
		{
			EmployeeBookingList cof= new EmployeeBookingList(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		if (command.equals(bookingLineBtn.getText()))
		{
			EmployeeBookingLineList eof= new EmployeeBookingLineList(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}
		
		if (command.equals(profileBtn.getText()))
		{
			EmployeeUpdateProfileFrame cof= new EmployeeUpdateProfileFrame(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		if (command.equals(passBtn.getText()))
		{
			EmployeeUpdatePasswordFrame cof= new EmployeeUpdatePasswordFrame(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		
	}
}