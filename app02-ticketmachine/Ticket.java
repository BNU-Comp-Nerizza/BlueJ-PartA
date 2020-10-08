import java.util.Date;
import java.text.SimpleDateFormat;  
/**
 * Write a description of class Ticket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket
{
    // instance variables - replace the example below with your own
    private String location;
    private int charge;
    // date
    private Date today = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
    
    /**
     * Please choose your destination:
     * "High Wycombe" or "Amersham"or "Alysebury" 
     */
    public Ticket(String destination)
    {
        location = destination;
        charge = 0;
    }

    public String getLocation()
    {
        return location;
    }
    
    public void addCharge()
    {
       if (location == "High wycombe")
        {
            charge = 330;
        }
           else if (location == "Amersham")
            {
               charge = 300;
            }
            else if (location == "Aylsebury")
            {
                charge = 200;
            }
                else 
                {
            System.out.println("You can only choose between High Wycombe or Amersham or Alysebury");                      
                              }
    }
    
    public int getCharge()
    {
        return charge;
    }
    
    public void printDestination()
    {
             System.out.println("# Your chosen destination: " + location);
             System.out.println("# Ticket cost is: " + charge);
             System.out.println("# Date ticket have been purchased: " + today);  
    }   
       
}
