package repositories;
import java.lang.*;
import java.util.*;
import interfaces.*;
import entities.*;


public class EmployeeRepo implements IEmployeeRepo
{
	public void addEmployee(Employee e)
	{
		Employee[] employeeList=this.getAllEmployee();
		
		for(int i=0;i<employeeList.length;i++)
		{
			if(employeeList[i]==null)
			{
				employeeList[i]=e;
				break;
			}
		}
		
		this.write(employeeList);
		
	}
	
	public void removeEmployee(String key)
	{
		Employee[] employeeList=this.getAllEmployee();
		
		
		for(int i=0;i<employeeList.length;i++)
		{
			if(employeeList[i]!=null)
			{
				if(employeeList[i].getUserId().equals(key))
				{
					employeeList[i]=null;
					break;
				}
			}
		}
		
		this.write(employeeList);
	}
	
	public void updateEmployee(Employee e)
	{
		Employee[] employeeList=this.getAllEmployee();
		
		for(int i=0;i<employeeList.length;i++)
		{
			if(employeeList[i]!=null)
			{
				if(employeeList[i].getUserId().equals(e.getUserId()))
				{
					employeeList[i]=e;
					break;
				}
			}
		}
		
		this.write(employeeList);
	}
	
	public Employee searchEmployeeByUserId(String id)
	{
		Employee[] employeeList=this.getAllEmployee();
		
		for(int i=0;i<employeeList.length;i++)
		{
			if(employeeList[i]!=null)
			{
				if(employeeList[i].getUserId().equals(id))
				{
					return employeeList[i];
				}
			}
		}
		
		return null;
	}
	
	
	public Employee[] getAllEmployee()
	{
		FileIO io=new FileIO();
		String[] data= io.readFile("repositories/data/employee.txt");
		
		
		Employee e=new Employee();
		Employee[] employeeList=new Employee[100];
		int i=0;
		for(String str:data)
		{
			if(str!=null)
			{   
		        System.out.println(str);
				employeeList[i]=e.formEmployee(str);
				
			}
			
			i++;
		}
		
		return employeeList;
		
		
	}
	
	public void write(Employee[] employeeList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(employeeList[i]!=null)
			{
				data[i]=employeeList[i].toStringEmployee();
			}
			
		}
		
		FileIO io=new FileIO();
		io.writeFile(data, "repositories/data/employee.txt");
	}
	
}