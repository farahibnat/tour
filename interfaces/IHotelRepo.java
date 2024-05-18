//Tasnia
package interfaces;
import java.lang.*;
import entities.*;
public interface IHotelRepo {
    void addHotel(Hotel h);
    void updateHotel(Hotel h);
    void removeHotel(String key);
    Hotel searchHotelByHotelId(String hotelId);
    Hotel[] getAllHotel();
}