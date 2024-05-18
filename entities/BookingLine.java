package entities;
import java.lang.*;

public class BookingLine
    {
		
	  private String bookingLineId;
	  private String roomId;
	  private int numberOfNight;
	  private String bookingFromDate;
	  private String bookingTillDate;
	  private double amount;
	  
	  public BookingLine()
	  {
		  
	  }
	  
	   public BookingLine(String bookingLineId,String roomId,int numberOfNight,String bookingFromDate,String bookingTillDate,double amount)
	   {
	   this.bookingLineId=bookingLineId;
	   this.roomId=roomId;
	   this.numberOfNight=numberOfNight;
	   this.bookingFromDate=bookingFromDate;
	   this.bookingTillDate=bookingTillDate;
	   this.amount=amount;
	 
		}
		public void setBookingLineId(String bookingLineId)
		{
		  this.bookingLineId=bookingLineId;
		}	

		public void setRoomId(String roomId)
		{
		  this.roomId=roomId;
		}

		 public void setNumberOfNight(int numberOfNight)
		{
		  this.numberOfNight=numberOfNight;
		}
		
		public void setBookingFromDate(String bookingFromDate)
		{
		  this.bookingFromDate=bookingFromDate;
		}
		
		public void setBookingTillDate(String bookingTillDate)
		{
		  this.bookingTillDate=bookingTillDate;
		}
		
		public void setAmount(double amount)
		{
		  this.amount=amount;
		}

		 public String getBookingLineId()
		{
		 return this.bookingLineId;
		}
		
		public String getRoomId()
		{
		 return this.roomId;
		}
		public int getNumberOfNight()
		{
		 return this.numberOfNight;
		}
		
		public String getBookingFromDate()
		{
		 return this.bookingFromDate;
		}
		
		public String getBookingTillDate()
		{
		 return this.bookingTillDate;
		}
		
		public double getAmount()
		{
		 return this.amount;
		}

		public String toStringBookingLine()
		{
		String str=this.bookingLineId+","+this.roomId+","+this.numberOfNight+","+this.bookingFromDate+","+this.bookingTillDate+","+this.amount+"\n";
		return str;
		}
		
		public BookingLine formBookingLine(String str)
		{
		String [] info=str.split(",");
		BookingLine b1=new BookingLine();
		b1.setBookingLineId(info[0]);
		b1.setRoomId(info[1]);
		b1.setNumberOfNight(Integer.parseInt(info[2]));
		b1.setBookingFromDate(info[3]);
		b1.setBookingTillDate(info[4]);
		b1.setAmount(Double.parseDouble(info[5]));

		return b1;


		}
	}		
			
			
			
			
			
			
			
			
			
			
			
			