package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class HotelOperationFrame extends JFrame implements ActionListener
{
	private JLabel hotelIdLabel,nameLabel, locationLabel, detailsLabel;
	private JTextField hotelTF, nameTF, locationTF, detailsTF ;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable hotelTable;
	private JScrollPane hotelTableSP;
	private JPanel panel;
	private User u;
	private Color c;
	public HotelOperationFrame(User u)
	{
		super("Operate Hotels");
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
		this.hotelTF.setBounds(120,50,100,30);
		this.panel.add(hotelTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.panel.add(nameTF);
		
		
		this.locationLabel=new JLabel("Location:");
		this.locationLabel.setBounds(280,50,60,30);
		this.panel.add(locationLabel);
		
		this.locationTF=new JTextField();
		this.locationTF.setBounds(350,50,100,30);
		this.panel.add(locationTF);
		
		this.detailsLabel=new JLabel("Details:");
		this.detailsLabel.setBounds(280,100,60,30);
		this.panel.add(detailsLabel);
		
		this.detailsTF=new JTextField();
		this.detailsTF.setBounds(350,100,100,30);
		this.panel.add(detailsTF);

		
		this.addBtn=new JButton("Add Hotel");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update Hotel");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove Hotel");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search Hotel");
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
		this.hotelTableSP=new JScrollPane(hotelTable);
		this.hotelTableSP.setBounds(50,380,700,200);
		this.hotelTable.setEnabled(false);
		this.panel.add(hotelTableSP);
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
			String hotelId,name,location,details;
			
			if((!hotelTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!locationTF.getText().isEmpty())&& (!detailsTF.getText().isEmpty()))
			{
				hotelId=hotelTF.getText();
				HotelRepo hrp=new HotelRepo();
				Hotel hotel=hrp.searchHotelByHotelId(hotelId);
			    
				if(hotel==null)
				{
					
					try
					{
						name=nameTF.getText();
						location=locationTF.getText();
						details=detailsTF.getText();
					    
						Hotel h=new Hotel(hotelId,name,location,details);
						
						hrp.addHotel(h);
						JOptionPane.showMessageDialog(this,"Hotel added successfully");
					
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Hotel Id already exists.");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		if(command.equals(updateBtn.getText()))
		{
			String hotelId,name,location,details;
			if((!hotelTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!locationTF.getText().isEmpty())&& (!detailsTF.getText().isEmpty()))
			{
				hotelId=hotelTF.getText();
				HotelRepo hrp=new HotelRepo();
				Hotel h=hrp.searchHotelByHotelId(hotelId);
				if(h!=null)
				{
					
					
						name=nameTF.getText();
						location=locationTF.getText();
						details=detailsTF.getText();
					    h.setName(name);
						h.setLocation(location);
						h.setDetails(details);
						hrp.updateHotel(h);
						JOptionPane.showMessageDialog(this,"Hotel updated successfully");
				}
					
				
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid hotel ID");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String hotelId;
			if(!hotelTF.getText().isEmpty()) 
			{
				hotelId=hotelTF.getText();
				HotelRepo hrp=new HotelRepo();
				Hotel h=hrp.searchHotelByHotelId(hotelId);
				if(h!=null)
				{
					hrp.removeHotel(hotelId);
					JOptionPane.showMessageDialog(this,"Hotel removed successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Provide valid hotel ID");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide a valid hotelId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String hotelId;
			if(!hotelTF.getText().isEmpty())
			{
				hotelId=hotelTF.getText();
				HotelRepo hrp=new HotelRepo();
				Hotel h=hrp.searchHotelByHotelId(hotelId);
				if(h!=null)
				{
					hotelTF.setEditable(false);
					nameTF.setText(h.getName());
					locationTF.setText(h.getLocation());
					detailsTF.setText(h.getDetails());
					JOptionPane.showMessageDialog(this,"Hotel found");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Hotel not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide hotelId to search hotel.");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			hotelTF.setEditable(true);
			hotelTF.setText("");
			nameTF.setText("");
			locationTF.setText("");
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
