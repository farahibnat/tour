//Tasnia
package interfaces;
import java.lang.*;
import entities.*;
public interface IRoomRepo {
    void addRoom(Room r);
    void updateRoom(Room r);
    void removeRoom(String key);
    Room searchRoomByRoomId(String roomId);
    Room[] searchRoomByHotelId(String hotelId);
    Room[] getAllRoom();
}