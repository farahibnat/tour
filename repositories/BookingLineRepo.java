package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class BookingLineRepo implements IBookingLineRepo
{
	
	
	public void addBookingLine(BookingLine b)
	{
		BookingLine[] bookingLineList=this.getAllBookingLine();
		
		
		for(int i=0;i<bookingLineList.length;i++)
		{
			if(bookingLineList[i]==null)
			{
				bookingLineList[i]=b;
				break;
			}
		}
		this.write(bookingLineList);
	}
	
	public void removeBookingLine(String key)
	{
		BookingLine[] bookingLineList=this.getAllBookingLine();
		
		for(int i=0;i<bookingLineList.length;i++)
		{
			if(bookingLineList[i]!=null)
			{
				if(bookingLineList[i].getBookingLineId().equals(key))
				{
					bookingLineList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(bookingLineList);
	}
	
	
		public void updateBookingLine(BookingLine b)
		{
			BookingLine [] bookingLineList=this.getAllBookingLine();
			
		for(int i=0;i<bookingLineList.length;i++)
		{
			if(bookingLineList[i]==null)
				
				{
				if(bookingLineList[i].getBookingLineId().equals(b.getBookingLineId()))
				{
					bookingLineList[i]=b;
					break;				
					
				   }						
				  }
		         }
				 this.write(bookingLineList);
				 
		}
	

	public 	BookingLine searchBookingLineByBookingLineId(String id)
	{
		BookingLine[] bookingLineList=this.getAllBookingLine();
		
		for(int i=0;i<bookingLineList.length;i++)
		{
			if(bookingLineList[i]!=null)
				
				{
				if(bookingLineList[i].getBookingLineId().equals(id))
				{
				return bookingLineList[i];
				}
		    }
		}
		return null;
	}
	
	
	
	public BookingLine[] searchBookingLineByRoomId(String id)
	{
		
		BookingLine [] bookingLineList=this.getAllBookingLine();
		BookingLine [] foundBookingLine=new BookingLine[100];
		
		
		for(int i=0; i<bookingLineList.length;i++)
		{
			if(bookingLineList[i]!=null)
				
				{
				if(bookingLineList[i].getRoomId().equals(id))
					
					{
						foundBookingLine[i]=bookingLineList[i];
					}
				}
				}
		    
             return foundBookingLine;
	}
		
	public BookingLine[] getAllBookingLine()
	{
	FileIO f1= new FileIO();
	String [] data=f1. readFile("repositories/data/bookingLine.txt");
	
	BookingLine b1= new  BookingLine();
	BookingLine [] bookingLineList=new BookingLine[100];
	int i=0;
	for (String str:data)
	{
	if(str!=null)
	
	{   
	    System.out.println(str);
	    bookingLineList[i]=b1.formBookingLine(str);	
	}	
		
	i++	;
	}
		
	return bookingLineList;	
	}
	
	public void write (BookingLine[] bookingLineList)
	{
		String [] data=new String[100];
		for(int i=0;i<100;++i)
		{
			if(bookingLineList[i]!=null)
			{
				
				data[i]=bookingLineList[i].toStringBookingLine();
			}
			}
			FileIO f1=new FileIO();
			f1.writeFile(data," repositories/data/bookingLine.txt");
	}
}
	