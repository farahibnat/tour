//Tasnia
package interfaces;
import java.lang.*;
import entities.*;
public interface IBookingRepo {
    void addBooking(Booking b);
    void updateBooking(Booking b);
    void removeBooking(String key);
    Booking searchBookingByBookingId(String bookingId);
    Booking[] searchBookingByHotelId(String hotelId);
    Booking[] searchBookingByUserId(String userId);
    Booking[] getAllBooking();
}