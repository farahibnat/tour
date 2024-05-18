package interfaces;
import java.lang.*;
import entities.*;


public interface IPaymentRepo
{
	void addPayment(Payment p);
	void removePayment(String key);
	void updatePayment(Payment p);
	Payment searchPaymentByPaymentId(String id);
	Payment[] searchPaymentByBookingId(String id);
	Payment[] searchPaymentByUserId(String id);
	Payment[] getAllPayment();
	
}