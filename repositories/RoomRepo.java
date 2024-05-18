//Tasnia
package repositories;
import java.lang.*;
import java.util.*;
import interfaces.*;
import entities.*; 

public class RoomRepo implements IRoomRepo{
    public void addRoom(Room r)
    {
        Room []roomList= this.getAllRoom();
        for (int i=0; i<roomList.length; i++)
        {
            if(roomList[i]==null)
            {
                roomList[i]=r;
                break;
            }
            
        }
        this.write(roomList);
    }
    
    public void updateRoom(Room r){
        Room []roomList= this.getAllRoom();
        for (int i=0; i<roomList.length; i++)
        {
            if(roomList[i]!=null)
            {
                if (roomList[i].getRoomId().equals(r.getRoomId()))
                {
                    roomList[i]=r;
                    break;
                }
            }
        }
        this.write(roomList);
    }
    
    public void removeRoom(String key)
    {
        Room []roomList= this.getAllRoom();
        for (int i= 0; i<roomList.length; i++)
        {
            if (roomList[i]!=null)
            {
                if (roomList[i].getRoomId().equals(key))
                {
                    roomList[i]=null;
                    break;
                }
            }
        }
        this.write(roomList);
    }
    
    public Room searchRoomByRoomId(String roomId)
    {
        Room []roomList= this.getAllRoom();
        for (int i=0; i<roomList.length; i++)
        {
            if (roomList[i]!=null)
            {
                if (roomList[i].getRoomId().equals(roomId))
                {
                    return roomList[i];
                }
            }
        }
		return null;
    }
    
    public Room []searchRoomByHotelId(String hotelId)
    {
        Room []roomList= this.getAllRoom();
        Room []foundRoom= new Room[100];
        for (int i=0; i<roomList.length; i++)
        {
            if (roomList[i]!=null)
            {
                if (roomList[i].getHotelId().equals(hotelId))
                {
                    foundRoom[i]= roomList[i];
                }
            }
        }
		return foundRoom;
    }
    
    public Room[] getAllRoom(){
        FileIO f1= new FileIO();
        String []info= f1.readFile("repositories/data/room.txt");
        Room r1= new Room();
        Room []roomList= new Room[100];
        int i=0;
        for (String s: info)
        {
            if(s!= null)
            {
                roomList[i]= r1.formRoom(s);
            }
            i++;
        }
        return roomList;
    }
    
    public void write(Room []roomList)
    {
        String []info= new String[100];
        for(int i=0; i<100; ++i)
        {
            if(roomList[i]!=null)
            {
                info[i]= roomList[i].toStringRoom();
            }
        }
        FileIO f1= new FileIO();
        f1.writeFile(info, "repositories/data/room.txt");
    }
}