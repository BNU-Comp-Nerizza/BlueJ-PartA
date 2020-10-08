/**
 * Write a description of class Ticket here.
 *
 * @author ()
 * @version (a version number or a date)
 */
public class Ticket 
{
    // instance variables - replace the example below with your own
    public String location;
    public int charge;
    
    /**
     * Please choose your destination:
     * "High Wycombe" or "Amersham"or "Alysebury" 
     */
    public String addTicket(String destination)
    {
        location = destination;
        charge = 0;
        
        if (location == "High wycombe")
        {
            charge = 330;
            System.out.println("High Wycombe ticket cost: " + charge);
        }
           else if (location == "Amersham")
            {
               charge = 300;
               System.out.println("Amersham ticket cost: " + charge);
            }
            else if (location == "Aylsebury")
            {
                charge = 200;
                System.out.println("Aylsebury ticket cost: " + charge);
            }
                else 
                {
            System.out.println("You can only choose between High Wycombe or Amersham or Alysebury");                      
        
        }
        return location;
    }
    
    
    public int getCharge()
    {
        return charge;
    }
}
