package entities;
import java.lang.*;

public class Payment
{
	private String paymentId, bookingId, userId, date;
	private double amount;
	
	public Payment()
	{
	}
	
	public Payment(String paymentId, String bookingId, String userId, String date, double amount)
	{
		this.paymentId=paymentId;
		this.bookingId=bookingId;
		this.userId=userId;
		this.date=date;
		this.amount=amount;
	}
	
	public void setPaymentId(String paymentId)
	{
		this.paymentId=paymentId;
	}
	
	public void setBookingId(String bookingId )
	{
		this.bookingId=bookingId;
	}
	
	public void setUserId(String userId )
	{
		this.userId=userId;
	}
	
	public void setDate(String date)
	{
		this.date=date;
	}
	
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	
	public String getPaymentId()
	{
		return this.paymentId;
	}
	
	public String getBookingId()
	{
		return this.bookingId;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	
	
	public String toStringPayment()
	{
		String str=this.paymentId+","+this.bookingId+","+this.userId+","+this.amount+","+this.date+"\n";
		return str;
	}
	
	public Payment formPayment(String str)
	{
		String[] info=str.split(",");
		Payment p=new Payment();
		p.setPaymentId(info[0]);
		p.setBookingId(info[1]);
		p.setUserId(info[2]);
		p.setAmount(Double.parseDouble(info[3]));
		p.setDate((info[4]));
		
		return p;
	}
}