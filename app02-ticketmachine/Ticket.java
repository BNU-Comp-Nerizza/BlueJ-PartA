/**
 * Write a description of class Ticket here.
 *
 * @author Nerizza Flores
 * @version (09/10/2020)
 */
public class Ticket 
{
    // instance variables for the location of the ticket
    public String location;
    // for the price of the ticket
    public int charge;
    
    /**
     * Please choose your destination:
     * "High Wycombe" or "Amersham"or "Aylsebury"
     * once you have chosen your destination, it will show the price of the ticket
     */
    public String addTicket(String destination)
    {
        location = destination;
        charge = 0;
        
        if (location == "High Wycombe")
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
    
    /**
     * @Return The price of a ticket.
             */
    
    public int getCharge()
    {
        return charge;
    }
}
