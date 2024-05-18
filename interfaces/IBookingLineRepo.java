package interfaces;
import java.lang.*;
import entities.*;

public interface IBookingLineRepo
{
	 void addBookingLine(BookingLine bl);
	 void removeBookingLine(String key);
	 void updateBookingLine(BookingLine bl);
	 BookingLine searchBookingLineByBookingLineId(String bookingLineId);
	 BookingLine[] searchBookingLineByRoomId(String roomId);
	
	 BookingLine[] getAllBookingLine();
	 
	
}