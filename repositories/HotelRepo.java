
package repositories;
import java.lang.*;
import java.util.*;
import interfaces.*;
import entities.*; 

public class HotelRepo implements IHotelRepo{
    public void addHotel(Hotel h)
    {
        Hotel []hotelList= this.getAllHotel();
        for (int i=0; i<hotelList.length; i++)
        {
            if(hotelList[i]==null)
            {
                hotelList[i]=h;
                break;
            }
            
        }
        this.write(hotelList);
    }
    
    public void updateHotel(Hotel h){
        Hotel []hotelList= this.getAllHotel();
        for (int i=0; i<hotelList.length; i++)
        {
            if(hotelList[i]!=null)
            {
                if (hotelList[i].getHotelId().equals(h.getHotelId()))
                {
                    hotelList[i]=h;
                    break;
                }
            }
        }
        this.write(hotelList);
    }
    
    public void removeHotel(String key)
    {
        Hotel []hotelList= this.getAllHotel();
        for (int i= 0; i<hotelList.length; i++)
        {
            if (hotelList[i]!=null)
            {
                if (hotelList[i].getHotelId().equals(key))
                {
                    hotelList[i]=null;
                    break;
                }
            }
        }
        this.write(hotelList);
    }
    
    public Hotel searchHotelByHotelId(String hotelId)
    {
        Hotel []hotelList= this.getAllHotel();
        for (int i=0; i<hotelList.length; i++)
        {
            if (hotelList[i]!=null)
            {
                if (hotelList[i].getHotelId().equals(hotelId))
                {
                    return hotelList[i];
                }
            }
        }
        return null;
    }
    
    public Hotel[] getAllHotel()
    {
        FileIO f1= new FileIO();
        String []info= f1.readFile("repositories/data/hotel.txt");
        Hotel h1= new Hotel();
        Hotel []hotelList= new Hotel[100];
        int i=0;
        for (String s: info)
        {
            if(s!= null)
            {
                hotelList[i]= h1.formHotel(s);
            }
            i++;
        }
        return hotelList;
    }
    
    public void write(Hotel []hotelList)
    {
        String []info= new String[100];
        for(int i=0; i<100; ++i)
        {
            if(hotelList[i]!=null)
            {
                info[i]= hotelList[i].toStringHotel();
            }
        }
        FileIO f1= new FileIO();
        f1.writeFile(info, "repositories/data/hotel.txt");
    }
}
