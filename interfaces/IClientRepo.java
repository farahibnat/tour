package interfaces;
import java.lang.*;
import entities.*;


public interface IClientRepo
{
	void addClient(Client c1);
	void removeClient(String key);
	void updateClient(Client c1);
	Client searchClientByUserId(String id);
	Client[] getAllClient();
	
}