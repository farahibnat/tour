 package frames;
 
 import java.lang.*;
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import entities.*;
 import repositories.*;
 
 public class ClientBookRoom extends JFrame implements ActionListener{
	 
	 private JLabel bookingLabel,hotelLabel,roomLabel,fromDateLabel,toDateLabel,nightLabel,amountLabel;
	 private JTextField bookingTF,hotelTF,roomTF,fromDateTF,toDateTF,nightTF,amountTF;
	 private JButton confirmBtn,back;
	 private JPanel panel;
	 private Color c;
	 private User u;
	 
	 public ClientBookRoom(User u)
	 {
		 super("Room Booking");
		this.setBounds(200,100,550,500);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 this.c=new Color(224,255,255);
		 
		 this.panel=new JPanel();
		 this.panel.setLayout(null);
		 this.panel.setBackground(this.c);
		 
		 this.bookingLabel=new JLabel("Booking Line Id:");
		 this.bookingLabel.setBounds(50,50,150,30);
		 this.panel.add(this.bookingLabel);
		 
		 this.bookingTF= new JTextField();
		 this.bookingTF.setBounds(210,50,150,30);
		 this.panel.add(bookingTF);
		 
		 this.hotelLabel=new JLabel("Hotel Id:");
		 this.hotelLabel.setBounds(50,90,150,30);
		 this.panel.add(hotelLabel);
		 
		 this.hotelTF= new JTextField();
		 this.hotelTF.setBounds(210,90,150,30);
		 this.panel.add(hotelTF);
		 
		 this.roomLabel=new JLabel("Room Id:");
		 this.roomLabel.setBounds(50,130,150,30);
		 this.panel.add(roomLabel);
		 
		 this.roomTF= new JTextField();
		 this.roomTF.setBounds(210,130,150,30);
		 this.panel.add(roomTF);
		 
		 this.fromDateLabel=new JLabel("Booking From Date:");
		 this.fromDateLabel.setBounds(50,170,150,30);
		 this.panel.add(fromDateLabel);
		 
		 this.fromDateTF= new JTextField();
		 this.fromDateTF.setBounds(210,170,150,30);
		 this.panel.add(fromDateTF);
		 
		 this.toDateLabel=new JLabel("Booking Till Date:");
		 this.toDateLabel.setBounds(50,210,150,30);
		 this.panel.add(toDateLabel);
		 
		 this.toDateTF= new JTextField();
		 this.toDateTF.setBounds(210,210,150,30);
		 this.panel.add(toDateTF);
		 
		 this.nightLabel=new JLabel("Number Of Nights:");
		 this.nightLabel.setBounds(50,250,150,30);
		 this.panel.add(nightLabel);
		 
		 this.nightTF= new JTextField();
		 this.nightTF.setBounds(210,250,150,30);
		 this.panel.add(nightTF);
		 
		 this.amountLabel=new JLabel("Amount:");
		 this.amountLabel.setBounds(50,290,150,30);
		 this.panel.add(amountLabel);
		 
		 this.amountTF= new JTextField();
		 this.amountTF.setBounds(210,290,150,30);
		 this.panel.add(amountTF);
		 
		 this.confirmBtn= new JButton("Confirm Booking");
		 this.confirmBtn.setBounds(70,340,150,30);
		 this.confirmBtn.addActionListener(this);
		 this.panel.add(confirmBtn);
		 
		 this.back= new JButton("Back");
		 this.back.setBounds(270,340,100,30);
		 this.back.addActionListener(this);
		 this.panel.add(back);
		 
		 this.add(panel);
		 this.u=u;
	 }
	 public void actionPerformed(ActionEvent ae)
	 {
		 String command=ae.getActionCommand();
		 if (command.equals(confirmBtn.getText()))
		 {
			 String bookingLineId, hotelId,roomId,fromDate,toDate; 
			 int noOfNight;
			 double amount;
			 if((!bookingTF.getText().isEmpty()) && (!hotelTF.getText().isEmpty()) && (!roomTF.getText().isEmpty()) && (!fromDateTF.getText().isEmpty()) && (!toDateTF.getText().isEmpty()) && (!nightTF.getText().isEmpty()) && (!amountTF.getText().isEmpty()))
			 {
				bookingLineId=bookingTF.getText();
				BookingLineRepo blr= new BookingLineRepo();
				BookingLine b= blr.searchBookingLineByBookingLineId(bookingLineId);
			   if(b==null)
			   {
				hotelId=hotelTF.getText();
				roomId=roomTF.getText();
				RoomRepo rrp=new RoomRepo();
				Room[]roomList= rrp.searchRoomByHotelId(hotelId);
				for (int i=0; i<roomList.length;++i)
				{
					if(roomList[i]!=null)
					{
						if (roomList[i].getRoomId()==roomId)
						{
							try
							{
								fromDate=fromDateTF.getText();
								toDate=toDateTF.getText();
								noOfNight=Integer.parseInt(nightTF.getText());
								amount=Double.parseDouble(amountTF.getText());
								
								BookingLine b1=new BookingLine(bookingLineId,roomId,noOfNight,fromDate,toDate,amount);
								BookingLineRepo brp= new BookingLineRepo();
								brp.addBookingLine(b1);
								JOptionPane.showMessageDialog(this,"Room Booked");
							}
							catch (Exception e)
							{
								JOptionPane.showMessageDialog(this,"Fill up the Number Of Nights and Amount fields accurately");
							}
							break;
						}
						if(i==(roomList.length-1))
						{
							JOptionPane.showMessageDialog(this,"Fill up Hotel Id and Room Id accurately");
						}
					}
				}
			  }
				else 
				{
					JOptionPane.showMessageDialog(this,"Booking Id already used");
				}
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(this,"Please fill up all the fields properly");
			 }
		 }
		 
		  if (command.equals(back.getText()))
		  {
			ClientHomeFrame adf=new ClientHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		  }
		 
	 }
 } 