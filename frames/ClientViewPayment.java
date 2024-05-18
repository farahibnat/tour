 package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class ClientViewPayment  extends JFrame implements ActionListener
{
	private JLabel label;
	private JTextField userTF;
	private JButton backBtn;
	private JTable paymentTable;
	private JScrollPane paymentTableSP;
	private JPanel panel;
	private User u;
	public ClientViewPayment(User u)
	{
		super("View self-payment");
		this.setBounds(100,100,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
	
		PaymentRepo prp=new PaymentRepo();
		Payment[] paymentList=prp.searchPaymentByUserId(u.getUserId());

		String paymentData1[][]=new String[paymentList.length][5];
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]!=null)
			{
				paymentData1[i][0]=paymentList[i].getPaymentId();
				paymentData1[i][1]=paymentList[i].getBookingId();
				paymentData1[i][2]=paymentList[i].getUserId();
				paymentData1[i][3]=String.valueOf(paymentList[i].getAmount());
				paymentData1[i][4]=paymentList[i].getDate();
			}	
		}
		
		String head1[]={"Payment ID","Booking ID","User ID","Amount","Date"};
	
		this.paymentTable=new JTable(paymentData1,head1);
		this.paymentTableSP=new JScrollPane(paymentTable);
		this.paymentTableSP.setBounds(50,110,700,450);
		this.paymentTable.setEnabled(false);
		this.panel.add(paymentTableSP);
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
