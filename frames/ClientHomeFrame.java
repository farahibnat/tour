package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class ClientHomeFrame extends JFrame implements ActionListener
{
	private JButton b1, payingBtn, bookBtn,hotelBtn,roomBtn,payBtn,bookingBtn,bookingLineBtn,profileBtn,passBtn;
	private JLabel label;
	private Font f;
	private JPanel panel, btnListPanel;
	private Color c;
	private User u;
	public ClientHomeFrame(User u)
	{
		super("Client Home Frame");
		this.setBounds(100,100,800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.c= new Color(224,255,255);
		this.f=new Font("Arial",Font.BOLD,30);
	/*	ImageIcon img1= new ImageIcon("tour.jpeg");
				
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
		
		this.label=new JLabel("Welcome, Dear Client!");
		this.label.setBounds(280,80,450,300);
		this.label.setFont(f);
		
		this.panel.add(label);
		
		this.btnListPanel=new JPanel();
		this.btnListPanel.setLayout(null);
		this.btnListPanel.setBounds(30,50,240,400);
		this.btnListPanel.setBackground(new Color(20,17,17));
		btnListPanel.setVisible(false);
		
		this.b1=new JButton("Home");
		this.b1.setBounds(30,10,100,30);
		this.b1.addActionListener(this);
		this.panel.add(b1);
		
		
		this.hotelBtn=new JButton("View Hotels");
		this.hotelBtn.setBounds(30,30,180,30);
		this.hotelBtn.addActionListener(this);
		this.btnListPanel.add(hotelBtn);
		
		this.roomBtn=new JButton("View Rooms");
		this.roomBtn.setBounds(30,70,180,30);
		this.roomBtn.addActionListener(this);
		this.btnListPanel.add(roomBtn);
		
		this.bookBtn=new JButton("Room Booking");
		this.bookBtn.setBounds(30,110,180,30);
		this.bookBtn.addActionListener(this);
		this.btnListPanel.add(bookBtn);
		
		
		this.payingBtn=new JButton("Payment");
		this.payingBtn.setBounds(30,150,180,30);
		//this.payingBtn.addActionListener(this);
		this.btnListPanel.add(payingBtn);
		
		this.payBtn=new JButton("View Payments List");
		this.payBtn.setBounds(30,190,180,30);
		this.payBtn.addActionListener(this);
		this.btnListPanel.add(payBtn);
		
		this.bookingBtn=new JButton("View Booking List");
		this.bookingBtn.setBounds(30,230,180,30);
		this.bookingBtn.addActionListener(this);
		this.btnListPanel.add(bookingBtn);
		
		this.bookingLineBtn=new JButton("View Booking Line List");
		this.bookingLineBtn.setBounds(30,270,180,30);
		this.bookingLineBtn.addActionListener(this);
		this.btnListPanel.add(bookingLineBtn);
		
		this.profileBtn=new JButton("Update Your Profile");
		this.profileBtn.setBounds(30,310,180,30);
		this.profileBtn.addActionListener(this);
		this.btnListPanel.add(profileBtn);
		
		this.passBtn=new JButton("Update Your Password");
		this.passBtn.setBounds(30,350,180,30);
		this.passBtn.addActionListener(this);
		this.btnListPanel.add(passBtn);
		
		this.panel.add(btnListPanel);
		this.add(panel);
		this.u=u;
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if (command.equals(b1.getText()))
		{
			btnListPanel.setVisible(true);
		}
		
		if (command.equals(hotelBtn.getText()))
		{
			ClientViewHotel cof= new ClientViewHotel(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		if (command.equals(roomBtn.getText()))
		{
			ClientViewRoom cof= new ClientViewRoom(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		if (command.equals(bookBtn.getText()))
		{
			ClientBookRoom cof= new ClientBookRoom(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		/*if (command.equals(payingBtn.getText()))
		{
			ClientViewHotel cof= new ClientViewHotel();
			this.setVisible(false);
			cof.setVisible(true);
		}*/
		
		if (command.equals(payBtn.getText()))
		{
			ClientViewPayment cvp= new ClientViewPayment(this.u);
			this.setVisible(false);
			cvp.setVisible(true);
		}
		
		if (command.equals(bookingBtn.getText()))
		{
			ClientViewBooking cvb= new ClientViewBooking(this.u);
			this.setVisible(false);
			cvb.setVisible(true);
		}
		
	/*	if (command.equals(bookingLineBtn.getText()))
		{
			ClientViewBookingLine cof= new ClientViewBookingLine();
			this.setVisible(false);
			cof.setVisible(true);
		}*/
		
		if (command.equals(profileBtn.getText()))
		{
			ClientUpdateProfileFrame cup= new ClientUpdateProfileFrame(this.u);
			this.setVisible(false);
			cup.setVisible(true);
		}
		
		if (command.equals(passBtn.getText()))
		{
			ClientUpdatePasswordFrame cuf= new ClientUpdatePasswordFrame(this.u);
			this.setVisible(false);
			cuf.setVisible(true);
		}
	}
} 