package entities;
import java.lang.*;


public class Client extends User
{
	private String membershipType;
	
	public Client()
	{
		
	}
	public Client(String userId, String name, String gender,int age, String email, String phoneNo, String address, int role, String securityAns, String password,String membershipType)
	{   
		super(userId,name,gender,age,email,phoneNo, address, role,securityAns,password);
		this.membershipType=membershipType;
	}

	public void setMembershipType(String membershipType)
	 {   
		 this.membershipType=membershipType;
	 }
	 public String getMembershipType()
	 {
		 return this.membershipType;
	 }	 	 
	 public String toStringClient()
	 {
		 String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.membershipType+"\n";
		 return str;
	 }
	 public Client formClient(String str)
	 {
		String[] info= str.split(","); 
		Client c1=new Client();
		c1.setUserId(info[0]);
		c1.setName(info[1]);
		c1.setEmail(info[2]);
		c1.setPhoneNo(info[3]);
		c1.setGender(info[4]);
		c1.setAge(Integer.parseInt(info[5]));
		c1.setAddress(info[6]);
		c1.setMembershipType(info[7]);
		
		
		return c1;
		
	 }
}