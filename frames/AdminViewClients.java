package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class AdminViewClients  extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable clientTable;
	private JScrollPane clientTableSP;
	private JPanel panel;
	private User u;
	private Color c;
	public AdminViewClients(User u)
	{
		super("View All Clients");
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
	
		ClientRepo crp=new ClientRepo();
		Client[] clientList=crp.getAllClient();

		String clientData1[][]=new String[clientList.length][8];
		for(int i=0;i<clientList.length;i++)
		{
			if(clientList[i]!=null)
			{
				clientData1[i][0]=clientList[i].getUserId();
				clientData1[i][1]=clientList[i].getName();
				clientData1[i][2]=clientList[i].getGender();
				clientData1[i][3]=String.valueOf(clientList[i].getAge());
				clientData1[i][4]=clientList[i].getEmail();
				clientData1[i][5]=clientList[i].getPhoneNo();
				clientData1[i][6]=clientList[i].getAddress();
				clientData1[i][7]=clientList[i].getMembershipType();
			}
		}
		
		String head1[]={"ID","Name","Gender","Age","Email","Phone No","Address","Membership Type"};
	
		this.clientTable=new JTable(clientData1,head1);
		this.clientTableSP=new JScrollPane(clientTable);
		this.clientTableSP.setBounds(50,110,700,450);
		this.clientTable.setEnabled(false);
		this.panel.add(clientTableSP);
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
		
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
}
