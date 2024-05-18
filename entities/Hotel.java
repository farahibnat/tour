//Tasnia

package entities;
import java.lang.*;
public class Hotel {
    private String hotelId;
    private String name;
    private String location;
    private String details;
    
    public Hotel()
    {
        
    }
    
    public Hotel(String hotelId, String name, String location, String details)
    {
        this.hotelId=hotelId;
        this.name=name;
        this.location=location;
        this.details=details;
    }
    
    public void setHotelId(String hotelId)
    {
        this.hotelId=hotelId;
    }
    public String getHotelId()
    {
        return this.hotelId;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    
    public void setLocation(String location)
    {
        this.location=location;
    }
    public String getLocation()
    {
        return this.location;
    }
    
    public void setDetails(String details)
    {
        this.details=details;
    }
    public String getDetails()
    {
        return this.details;
    }
    
    public String toStringHotel()
    {
        String str= this.hotelId+","+this.name+","+this.location+","+this.details+"\n";
        return str;
    }
    
    public Hotel formHotel(String str)
    {
        String []info= str.split(",");
        Hotel h1= new Hotel();
        h1.setHotelId(info[0]);
        h1.setName(info[1]);
        h1.setLocation(info[2]);
        h1.setDetails(info[3]);
        
        return h1;
    }
}
