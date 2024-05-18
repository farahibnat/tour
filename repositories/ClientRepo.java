package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;


public class ClientRepo implements IClientRepo
{
	public void addClient(Client c1)
	{
		Client[] clientList=this.getAllClient();
		
		for(int i=0;i<clientList.length;i++)
		{
			if(clientList[i]==null)
			{
				clientList[i]=c1;
				break;
			}
		}
		
		this.write(clientList);
		
	}
	public void removeClient(String key)
	{
		Client[] clientList=this.getAllClient();
		
		for(int i=0;i<clientList.length;i++)
		{
			if(clientList[i]!=null)
			{
				if(clientList[i].getUserId().equals(key))
				{
					clientList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(clientList);
	}
	public void updateClient(Client c1)
	{
		Client[] clientList=this.getAllClient();
		
		for(int i=0;i<clientList.length;i++)
		{
			if(clientList[i]!=null)
			{
				if(clientList[i].getUserId().equals(c1.getUserId()))
				{
					clientList[i]=c1;
					break;
				}
			}
			
		}
		
		this.write(clientList);
		
	}
	public Client searchClientByUserId(String id)
	{
		Client[] clientList=this.getAllClient();
		
		for(int i=0;i<clientList.length;i++)
		{
			if(clientList[i]!=null)
			{
				if(clientList[i].getUserId().equals(id))
				{
					return clientList[i];
				}
			}
			
		}

		return null;
		
		
	}
	public Client[] getAllClient()
	{
		FileIO io=new FileIO();
		String[] data= io.readFile("repositories/data/client.txt");
		
		
		Client c1=new Client();
		Client[] clientList=new Client[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				clientList[i]=c1.formClient(str);
				
			}
			
			i++;
		}
		
		return clientList;
	}
	
	public void write(Client[]  clientList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(clientList[i]!=null)
			{
				data[i]= clientList[i].toStringClient();
			}
			
		}
		FileIO io=new FileIO();
		io.writeFile(data, "repositories/data/client.txt");
	}
	
}