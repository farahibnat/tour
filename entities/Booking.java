//Tasnia 
package entities;
import java.lang.*;
public class Booking {
    private String bookingId;
    private String hotelId;
    private String userId;
    private double totalAmount;
    private double paidAmount;
    private double due;
    
    public Booking()
    {
        
    }
    
    public Booking(String bookingId, String hotelId, String userId, double totalAmount, double paidAmount, double due)
    {
        this.bookingId=bookingId;
        this.hotelId=hotelId;
        this.userId= userId;
        this.totalAmount=totalAmount;
        this.paidAmount=paidAmount;
        this.due=due;
    }
    
    public void setBookingId(String bookingId)
    {
        this.bookingId=bookingId;
    }
    public String getBookingId()
    {
        return this.bookingId;
    }
    
    public void setHotelId(String hotelId)
    {
        this.hotelId=hotelId;
    }
    public String getHotelId()
    {
        return this.hotelId;
    }
    
    public void setUserId(String userId)
    {
        this.userId=userId;
    }
    public String getUserId()
    {
        return this.userId;
    }
    
    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount=totalAmount;
    }
    public double getTotalAmount()
    {
        return this.totalAmount;
    }
    
    public void setPaidAmount(double paidAmount)
    {
        this.paidAmount=paidAmount;
    }
    public double getPaidAmount()
    {
        return this.paidAmount;
    }
    
    public void setDue(double due)
    {
        this.due=due;
    }
    public double getDue()
    {
        return this.due;
    }
    
    public String toStringBooking()
    {
        String str= this.bookingId+","+this.hotelId+","+this.userId+","+this.totalAmount+","+this.paidAmount+","+this.due+"\n";
        return str;
    }
    
    public Booking formBooking(String str)
    {
        String []info= str.split(",");
        Booking b1= new Booking();
        b1.setBookingId(info[0]);
        b1.setHotelId(info[1]);
        b1.setUserId(info[2]);
        b1.setTotalAmount(Double.parseDouble(info[3]));
        b1.setPaidAmount(Double.parseDouble(info[4]));
        b1.setDue(Double.parseDouble(info[5]));
        
        return b1;
    }
}
