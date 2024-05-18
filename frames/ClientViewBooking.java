 package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class ClientViewBooking  extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable bookingTable;
	private JScrollPane bookingTableSP;
	private JPanel panel;
	private Color c;
	private User u;
	
	public ClientViewBooking(User u)
	{
		super("View self-booking");
		this.setBounds(100,100,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 this.c=new Color(224,255,255);
		 
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(this.c);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
	
		BookingRepo brp=new BookingRepo();
		Booking[] bookingList=brp.searchBookingByUserId(u.getUserId());

		String bookingData1[][]=new String[bookingList.length][6];
		for(int i=0;i<bookingList.length;i++)
		{
			if(bookingList[i]!=null)
			{
				bookingData1[i][0]=bookingList[i].getBookingId();
				bookingData1[i][1]=bookingList[i].getHotelId();
				bookingData1[i][2]=bookingList[i].getUserId();
				bookingData1[i][3]=String.valueOf(bookingList[i].getTotalAmount());
				bookingData1[i][4]=String.valueOf(bookingList[i].getPaidAmount());
				bookingData1[i][5]=String.valueOf(bookingList[i].getDue());
				
			}
		}
		String head1[]={"Booking ID","Hotel ID","User ID","Total Amount","Paid Amount","Due"};
	
		this.bookingTable=new JTable(bookingData1,head1);
		this.bookingTableSP=new JScrollPane(bookingTable);
		this.bookingTableSP.setBounds(50,110,700,450);
		this.bookingTable.setEnabled(false);
		this.panel.add(bookingTableSP);
		this.panel.revalidate();
		this.panel.repaint();
		this.add(panel);
		this.u=u;
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(command.equals(backBtn.getText()))
		{
		
			ClientHomeFrame adf=new ClientHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
}
