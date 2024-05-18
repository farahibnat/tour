package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class ClientViewHotel extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable hotelTable;
	private JScrollPane hotelTableSP;
	private JPanel panel;
	private Color c;
	private User u;
	
	
	
	public ClientViewHotel(User u)
	{
		super("Client View Hotels");
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
		HotelRepo hrp=new HotelRepo();
		Hotel[] hotelList=hrp.getAllHotel();
		
		String hotelData1[][]=new String[hotelList.length][4];
		for(int i=0;i<hotelList.length;i++)
		{
		
			if(hotelList[i]!=null)
			{
				hotelData1[i][0]=hotelList[i].getHotelId();
				hotelData1[i][1]=hotelList[i].getName();
				hotelData1[i][2]=hotelList[i].getLocation();
				hotelData1[i][3]=hotelList[i].getDetails();
			}
		}
		String head1[]={"Hotel Id","Name","Location","Details"};
		this.hotelTable=new JTable(hotelData1,head1);
		//scroll
		this.hotelTableSP=new JScrollPane(hotelTable);
		this.hotelTableSP.setBounds(50,110,700,450);
		this.hotelTable.setEnabled(false);
		this.panel.add(hotelTableSP);
		
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
			ClientHomeFrame adf=new ClientHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
}