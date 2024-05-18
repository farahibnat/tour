package entities;
import java.lang.*;


public class Employee extends User
{
	private String designation;
	private double salary;
	
	public Employee()
	{
		
	}
	public Employee(String userId, String name, String gender,int age, String email, String phoneNo, String address, int role, String securityAns, String password,String designation,double salary)
	{  
	    super(userId,name,gender,age,email, phoneNo, address, role,securityAns,password);
		this.designation=designation;
		this.salary=salary;
	}
	public void setDesignation(String designation)
	 {
		 this.designation=designation;
	 }
	 public void setSalary(double salary)
	 {
		 this.salary=salary;
	 }
	 public String getDesignation()
	 {
		 return this.designation;
	 }
	 public double getSalary()
	 {
		 return this.salary;
	 }	 	 
     public String toStringEmployee()
	 {
		 String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.designation+","+this.salary+"\n";
		 return str;
	 }

	 public Employee formEmployee(String str)
	 {
		String[] info= str.split(","); 
		Employee e=new Employee();
		e.setUserId(info[0]);
		e.setName(info[1]);
		e.setEmail(info[2]);
		e.setPhoneNo(info[3]);
		e.setGender(info[4]);
		e.setAge(Integer.parseInt(info[5]));
		e.setAddress(info[6]);
		e.setDesignation(info[7]);
		e.setSalary(Double.parseDouble(info[8]));
	
	
		return e;
	 }
}