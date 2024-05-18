package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class RoomOperationFrame extends JFrame implements ActionListener
{
	private JLabel roomIdLabel,hotelIdLabel, typeLabel, rentPerNightLabel, serviceDetailsLabel;
	private JTextField roomTF, hotelTF, typeTF, rentTF, detailsTF ;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable roomTable;
	private JScrollPane roomTableSP;
	private JPanel panel;
	private User u;
	private Color c;
	public RoomOperationFrame(User u)
	{
		super("Operate Rooms");
		this.setBounds(100,100,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.c=new Color(224,255,255);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(this.c);
		
		this.hotelIdLabel=new JLabel("Hotel Id:");
		this.hotelIdLabel.setBounds(50,50,60,30);
		this.panel.add(hotelIdLabel);
		
		this.hotelTF=new JTextField();
		this.hotelTF.setBounds(180,50,100,30);
		this.panel.add(hotelTF);
		
		this.roomIdLabel=new JLabel("Room Id:");
		this.roomIdLabel.setBounds(50,100,60,30);
		this.panel.add(roomIdLabel);
		
		this.roomTF=new JTextField();
		this.roomTF.setBounds(180,100,100,30);
		this.panel.add(roomTF);
		
		
		this.typeLabel=new JLabel("Room Type:");
		this.typeLabel.setBounds(50,150,60,30);
		this.panel.add(typeLabel);
		
		this.typeTF=new JTextField();
		this.typeTF.setBounds(180,150,100,30);
		this.panel.add(typeTF);
		
		this.rentPerNightLabel=new JLabel("Rent Per Night:");
		this.rentPerNightLabel.setBounds(50,200,60,30);
		this.panel.add(rentPerNightLabel);
		
		this.rentTF=new JTextField();
		this.rentTF.setBounds(180,200,100,30);
		this.panel.add(rentTF);
		
		this.serviceDetailsLabel=new JLabel(" Service Details:");
		this.serviceDetailsLabel.setBounds(50,250,60,30);
		this.panel.add(serviceDetailsLabel);
		
		this.detailsTF=new JTextField();
		this.detailsTF.setBounds(180,250,100,30);
		this.panel.add(detailsTF);
		
		
		this.addBtn=new JButton("Add Room");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update Room");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove Room");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search Room");
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
	    
	    
		RoomRepo rrp=new RoomRepo();
		Room[] roomList=rrp.getAllRoom();
		String roomData1[][]=new String[roomList.length][5];
		for(int i=0;i<roomList.length;i++)
			
			{
			if(roomList[i]!=null)
			{
			roomData1[i][0]=roomList[i].getHotelId();
			roomData1[i][1]=roomList[i].getRoomId();
			roomData1[i][2]=roomList[i].getType();
			roomData1[i][3]=String.valueOf(roomList[i].getRentPerNight());
			roomData1[i][4]=roomList[i].getServiceDetails();
			}
		}
		String head1[]={"Hotel Id","Room Id","Type","Rent Per Night","Service Details"};
		this.roomTable=new JTable(roomData1,head1);
		this.roomTableSP=new JScrollPane(roomTable);
		this.roomTableSP.setBounds(50,380,700,200);
		this.roomTable.setEnabled(false);
		this.panel.add(roomTableSP);
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
			String roomId,hotelId,type,serviceDetails;
			double rentPerNight;
			if((!roomTF.getText().isEmpty()) && (!hotelTF.getText().isEmpty()) && (!typeTF.getText().isEmpty()) && (!rentTF.getText().isEmpty()) &&(!detailsTF.getText().isEmpty()))
			{
				roomId=roomTF.getText();
				RoomRepo rrp=new RoomRepo();
				Room room=rrp.searchRoomByRoomId(roomId);
			    
				if(room==null)
				{
					try
					{
						roomId=roomTF.getText();
						hotelId=hotelTF.getText();
						type=typeTF.getText();
						rentPerNight=Double.parseDouble(rentTF.getText());
						serviceDetails=detailsTF.getText();
						
						
					    
						Room r=new Room(roomId,hotelId,type,rentPerNight,serviceDetails);
						rrp.addRoom(r);
						
						JOptionPane.showMessageDialog(this,"Room added successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide valid Rent Per Night");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Room Id already exists.");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		if(command.equals(updateBtn.getText()))
		{
	
			String roomId,hotelId,type,serviceDetails;
			double rentPerNight;
			if((!roomTF.getText().isEmpty()) && (!hotelTF.getText().isEmpty()) && (!typeTF.getText().isEmpty()) && (!rentTF.getText().isEmpty()) &&(!detailsTF.getText().isEmpty()))
			{   
		        roomId=roomTF.getText();
				RoomRepo rrp=new RoomRepo();
				Room r=rrp.searchRoomByRoomId(roomId);
			    
				if(r!=null)
				{
					try
					{
						type=typeTF.getText();
						rentPerNight=Double.parseDouble(rentTF.getText());
						serviceDetails=detailsTF.getText();
						
						r.setType(type);
						r.setRentPerNight(rentPerNight);
						r.setServiceDetails(serviceDetails);
						rrp.updateRoom(r);
						JOptionPane.showMessageDialog(this,"Room updated successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide valid Rent Per Night");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid room Id");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String roomId;
			if(!roomTF.getText().isEmpty()) 
			{
				roomId=roomTF.getText();
				RoomRepo rrp=new RoomRepo();
				Room r=rrp.searchRoomByRoomId(roomId);
				if(r!=null)
				{
					rrp.removeRoom(roomId);
					JOptionPane.showMessageDialog(this,"Room removed successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Provide valid Room ID");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide a valid  room Id");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String roomId;
			if(!roomTF.getText().isEmpty())
			{
				roomId=roomTF.getText();
				RoomRepo rrp=new RoomRepo();
				Room r=rrp.searchRoomByRoomId(roomId);
				if(r!=null)
				{
					roomTF.setEditable(false);
					hotelTF.setEditable(false);	
					typeTF.setText(r.getType());
					rentTF.setText(String.valueOf(r.getRentPerNight()));
					detailsTF.setText(r.getServiceDetails());
					
				
					JOptionPane.showMessageDialog(this,"Room found");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Room not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide roomId to search room.");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			roomTF.setEditable(true);
			roomTF.setText("");
			hotelTF.setEditable(true);
			hotelTF.setText("");
			typeTF.setText("");
			rentTF.setText("");
			detailsTF.setText("");
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
