package entities;
import java .lang.*;
 public class Admin extends User
 {
	 private String adminType;
	  
	  public Admin()
	  {
		  super();
	  }
	  public Admin(String userId, String name, String gender,int age, String email, String phoneNo, String address, int role, String securityAns, String password, String adminType)
	  {
		  super( userId,name,gender,age,email, phoneNo, address, role,securityAns,password);
		  this.adminType=adminType;
	  }
	  
	  public void setAdminType(String adminType)
	  {
		  this.adminType=adminType;
	  }
	  public String getAdminType()
	  {
		  return this.adminType;
	  }
	  public String toStringAdmin()
	{
		String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.adminType+"\n";
		return str;
	}
	
	public Admin formAdmin(String str)
	{
		String[] info=str.split(",");
		Admin a=new Admin();
		a.setUserId(info[0]);
		a.setName(info[1]);
		a.setEmail(info[2]);
		a.setPhoneNo(info[3]);
		a.setGender(info[4]);
		a.setAge(Integer.parseInt(info[5]));
		a.setAddress(info[6]);
		a.setAdminType(info[7]);
		
		return a;
	}
 }