package frames;
 
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;
 
public class EmployeeBookingLineList extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable bookingLineTable;
	private JScrollPane bookingLineTableSP;
	private JPanel panel;
	private User u;
	private Color c;
	
	
	public EmployeeBookingLineList(User u)
	{
		super(" Employee View Booking Line");
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
		
		BookingLineRepo prp=new BookingLineRepo();
		BookingLine[] bookingLineList=prp.getAllBookingLine();
		String bookingLineData1[][]=new String[bookingLineList.length][6];
		for(int i=0;i<bookingLineList.length;i++)
		{
		
			if(bookingLineList[i]!=null)
			{
				bookingLineData1[i][0]=bookingLineList[i].getBookingLineId();
				bookingLineData1[i][1]=bookingLineList[i].getRoomId();
				bookingLineData1[i][2]=String.valueOf(bookingLineList[i].getNumberOfNight());
				bookingLineData1[i][3]=bookingLineList[i].getBookingFromDate();
				bookingLineData1[i][4]=bookingLineList[i].getBookingTillDate();
				bookingLineData1[i][5]=String.valueOf(bookingLineList[i].getAmount());
			}
			
			
			
		}
		
		String head1[]={"Booking line id","Room Id","No of Nights"," From Date","Till Date","Amount"};
		
		this.bookingLineTable=new JTable(bookingLineData1,head1);
		
		this.bookingLineTableSP=new JScrollPane(bookingLineTable);
		this.bookingLineTableSP.setBounds(50,110,700,450);
		this.bookingLineTable.setEnabled(false);
		this.panel.add(bookingLineTableSP);
		
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
