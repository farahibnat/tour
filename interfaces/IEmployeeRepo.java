package interfaces;
import java.lang.*;
import entities.*;


public interface IEmployeeRepo
{
	void addEmployee(Employee e);
	void removeEmployee(String key);
	void updateEmployee(Employee e);
	Employee searchEmployeeByUserId(String id);
	Employee[] getAllEmployee();
	
}