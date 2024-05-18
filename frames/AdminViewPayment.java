package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class AdminViewPayment extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable paymentTable;
	private JScrollPane paymentTableSP;
	private JPanel panel;
	private Color c;
	private User u;
	
	
	
	public AdminViewPayment(User u)
	{
		super("Admin View Payment");
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
		PaymentRepo prp=new PaymentRepo();
		Payment[] paymentList=prp.getAllPayment();
		
		String paymentData1[][]=new String [paymentList.length][5];
		for(int i=0;i<paymentList.length;i++)
		{
		
			if(paymentList[i]!=null)

				paymentData1[i][0]=paymentList[i].getPaymentId();
				paymentData1[i][1]=paymentList[i].getBookingId();
				paymentData1[i][2]=paymentList[i].getUserId();
				paymentData1[i][3]=String.valueOf(paymentList[i].getAmount());
				paymentData1[i][4]=paymentList[i].getDate();
		}
		
		String head1[]={"Payment Id","Booking Id","User Id","Amount","Date"};
		this.paymentTable=new JTable(paymentData1,head1);
		//scroll
		this.paymentTableSP=new JScrollPane(paymentTable);
		this.paymentTableSP.setBounds(50,110,700,450);
		this.paymentTable.setEnabled(false);
		this.panel.add(paymentTableSP);
		
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