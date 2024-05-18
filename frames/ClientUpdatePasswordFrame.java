package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class ClientUpdatePasswordFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,currentPassLabel, newPassLabel;
	private JTextField userTF;
	private JPasswordField currentPassPF,newPassPF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private Color c;
	private User u;
	
	
	
	public ClientUpdatePasswordFrame(User u)
	{
		super("Client Update Password Frame");
		this.setBounds(100,100,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.c=new Color(224,255,255);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(this.c);
		
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		this.panel.setBackground(this.c);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(u.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.currentPassLabel=new JLabel("current Password:");
		this.currentPassLabel.setBounds(50,100,60,30);
		this.panel.add(currentPassLabel);
		
		this.currentPassPF=new JPasswordField();
		this.currentPassPF.setBounds(120,100,100,30);
		this.panel.add(currentPassPF);
		
		this.newPassLabel=new JLabel("New Password:");
		this.newPassLabel.setBounds(50,150,60,30);
		this.panel.add(newPassLabel);
		
		this.newPassPF=new JPasswordField();
		this.newPassPF.setBounds(120,150,100,30);
		this.panel.add(newPassPF);
		
		
		
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,200,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,200,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(updateBtn.getText()))
		{
			
			if((!currentPassPF.getText().isEmpty()) && (!newPassPF.getText().isEmpty()))
			{
				
				if(currentPassPF.getText().equals(u.getPassword()))
				{
					
					u.setPassword(newPassPF.getText());
					UserRepo urp=new UserRepo();
					urp.updateUser(u);
					JOptionPane.showMessageDialog(this,"Password updated Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Current Password didn't match");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			ClientHomeFrame cdf=new ClientHomeFrame(this.u);
			this.setVisible(false);
			cdf.setVisible(true);
		}
	}
	
}