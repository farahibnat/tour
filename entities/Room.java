//Tasnia
package entities;
import java.lang.*;
public class Room {
    private String roomId;
    private String hotelId;
    private String type;
    private double rentPerNight;
    private String serviceDetails;
    
    public Room()
    {
        
    }
    
    public Room(String roomId, String hotelId, String type, double rentPerNight, String serviceDetails)
    {
        this.roomId=roomId;
        this.hotelId=hotelId;
        this.type=type;
        this.rentPerNight=rentPerNight;
        this.serviceDetails=serviceDetails;
    }
    
    public void setRoomId(String roomId)
    {
        this.roomId=roomId;
    }
    public String getRoomId()
    {
        return this.roomId;
    }
    
    public void setHotelId(String hotelId)
    {
        this.hotelId=hotelId;
    }
    public String getHotelId()
    {
        return this.hotelId;
    }
    
    public void setRentPerNight(double rentPerNight)
    {
        this.rentPerNight= rentPerNight;
    }
    public double getRentPerNight()
    {
        return this.rentPerNight;
    }
    
    public void setType(String type)
    {
        this.type=type;
    }
    public String getType()
    {
        return this.type;
    }
    
    public void setServiceDetails(String serviceDetails)
    {
        this.serviceDetails=serviceDetails;
    }
    public String getServiceDetails()
    {
        return this.serviceDetails;
    }
    
    public String toStringRoom()
    {
        String str= this.roomId+","+this.hotelId+","+this.type+","+this.rentPerNight+","+this.serviceDetails+"\n";
        return str;
    }
    
    public Room formRoom(String str)
    {
        String []info= str.split(",");
        Room r1= new Room();
        r1.setRoomId(info[0]);
        r1.setHotelId(info[1]);
        r1.setType(info[2]);
        r1.setRentPerNight(Double.parseDouble(info[3]));
        r1.setServiceDetails(info[4]);
        
        return r1;
    }
}
