package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class AdminViewRoom extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable roomTable;
	private JScrollPane roomTableSP;
	private JPanel panel;
	private Color c;
	private User u;
	
	
	
	public AdminViewRoom(User u)
	{
		super("Admin View Room");
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
		//array
		RoomRepo rrp=new RoomRepo();
		Room[] roomList=rrp.getAllRoom();
		
		String roomData1[][]=new String [roomList.length][5];
		for(int i=0;i<roomList.length;i++)
		{
		
			if(roomList[i]!=null)
			{
				roomData1[i][0]=roomList[i].getRoomId();
				roomData1[i][1]=roomList[i].getHotelId();
				roomData1[i][2]=roomList[i].getType();
				roomData1[i][3]=String.valueOf(roomList[i].getRentPerNight());
				roomData1[i][4]=roomList[i].getServiceDetails();
			}
		}
		String head1[]={"Room Id","Hotel Id","Type","Rent Per Night","Service Details"};
		this.roomTable=new JTable(roomData1,head1);
		//scroll
		this.roomTableSP=new JScrollPane(roomTable);
		this.roomTableSP.setBounds(50,110,700,450);
		this.roomTable.setEnabled(false);
		this.panel.add(roomTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	//action listner
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to payment home page.
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
}