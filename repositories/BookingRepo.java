
package repositories;
import java.lang.*;
import java.util.*;
import interfaces.*;
import entities.*; 

public class BookingRepo implements IBookingRepo{
    public void addBooking(Booking b)
    {
        Booking []bookingList= this.getAllBooking();
        for (int i=0; i<bookingList.length; i++)
        {
            if(bookingList[i]==null)
            {
                bookingList[i]=b;
                break;
            }
            
        }
        this.write(bookingList);
    }
    
    public void updateBooking(Booking b){
        Booking []bookingList= this.getAllBooking();
        for (int i=0; i<bookingList.length; i++)
        {
            if(bookingList[i]!=null)
            {
                if (bookingList[i].getBookingId().equals(b.getBookingId()))
                {
                    bookingList[i]=b;
                    break;
                }
            }
        }
        this.write(bookingList);
    }
    
    public void removeBooking(String key)
    {
        Booking []bookingList= this.getAllBooking();
        for (int i= 0; i<bookingList.length; i++)
        {
            if (bookingList[i]!=null)
            {
                if (bookingList[i].getBookingId().equals(key))
                {
                    bookingList[i]=null;
                    break;
                }
            }
        }
        this.write(bookingList);
    }
    
    public Booking searchBookingByBookingId(String bookingId)
    {
        Booking []bookingList= this.getAllBooking();
        for (int i=0; i<bookingList.length; i++)
        {
            if (bookingList[i]!=null)
            {
                if (bookingList[i].getBookingId().equals(bookingId))
                {
                    return bookingList[i];
                }
            }
        }
        return null;
    }
    
    public Booking []searchBookingByHotelId(String hotelId)
    {
        Booking []bookingList= this.getAllBooking();
        Booking []foundBooking= new Booking[100];
        for (int i=0; i<bookingList.length; i++)
        {
            if (bookingList[i]!=null)
            {
                if (bookingList[i].getHotelId().equals(hotelId))
                {
                    foundBooking[i]= bookingList[i];
                }
            }
            
        }
       return foundBooking;
    }
    
    public Booking []searchBookingByUserId(String userId)
    {
        Booking []bookingList= this.getAllBooking();
        Booking []foundBooking= new Booking[100];
        for (int i=0; i<bookingList.length; i++)
        {
            if (bookingList[i]!=null)
            {
                if (bookingList[i].getUserId().equals(userId))
                {
                   foundBooking[i]= bookingList[i];
                }
            }
          
        }
        return foundBooking;
    }
    
    public Booking[] getAllBooking()
    {
        FileIO f1= new FileIO();
        String []info= f1.readFile("repositories/data/booking.txt");
        Booking b1= new Booking();
        Booking []bookingList= new Booking[100];
        int i=0;
        for (String s: info)
        {
            if(s!= null)
            {
                bookingList[i]= b1.formBooking(s);
            }
            i++;
        }
        return bookingList;
    }
    
    public void write(Booking []bookingList)
    {
        String []info= new String[100];
        for(int i=0; i<100; ++i)
        {
            if(bookingList[i]!=null)
            {
                info[i]= bookingList[i].toStringBooking();
            }
        }
        FileIO f1= new FileIO();
        f1.writeFile(info, "repositories/data/booking.txt");
    }
}
