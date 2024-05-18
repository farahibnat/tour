
package frames;
 
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;
 
public class EmployeeBookingList extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable bookingTable;
	private JScrollPane bookingTableSP;
	private JPanel panel;
	private User u;
	private Color c;
	
	
	public EmployeeBookingList(User u)
	{
		super(" Employee View Booking");
		this.setBounds(100,100,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.c=new Color(224,255,255);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(this.c);
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		BookingRepo prp=new BookingRepo();
		Booking[] bookingList=prp.getAllBooking();
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
		
		String head1[]={"Booking id","Hotel Id","User Id","Total amount","Paid Amount","Due"};
		
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
			
			EmployeeHomeFrame edf=new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			edf.setVisible(true);
		}
	}
	
}
