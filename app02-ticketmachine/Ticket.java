import java.util.Date;
import java.text.SimpleDateFormat;    
/**
 * Ticket Class provides users the information 
 * about the cost and location of their journey.
 * The user can only choose between three tickets.
 * Once the ticket have been chosen it will automatically
 * store the location and the cost of the ticket
 * @author Nerizza Flores
 * @version (09/10/2020)
 */
public class Ticket 
{
    // instance variables for the location of the ticket
    public String location;
    // for the price of the ticket
    public int charge;
    // The date the ticket was purchased
    private Date today = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
    
    /**
     * Please choose your destination:
     * "High Wycombe" or "Amersham"or "Aylsebury"
     * once you have chosen your destination, it will show the price of the ticket
     */
    
    /**
     * Returns the ticket for High Wycombe with location and cost
     */
    public int highwycombeTicket()
    {
        location = "High Wycombe";
        charge = 330;
        System.out.println("Your destination is: " + location);
        System.out.println("Your ticket cost is: " + charge);
        System.out.println("Please insert money");
        return charge;
    }
    
    /**
     * Returns the ticket for Amersham with location and cost
     */
    public int amershamTicket()
    {
       location = "Amersham";
       charge = 300;
        System.out.println("Your destination is: " + location);
        System.out.println("Your ticket cost is: " + charge);
        System.out.println("Please insert money");
       return charge;
    }
    
    /**
     * Returns the ticket for Aylsebury with location and cost
     */
    
    public int aylseburyTicket()
    {
        location = "Aylsebury";
        charge = 220;
        System.out.println("Your destination is: " + location);
        System.out.println("Your ticket cost is: " + charge);
        System.out.println("Please insert money");
        return charge;
    }
      
    /**
     * Returns the ticket for all location with the total cost
     */
        public int allTicket()
    {
        int highwycombe = 330;
        int aylsebury = 220;
        int amersham = 300;
        int sum;
        sum = highwycombe + aylsebury + amersham;
        return sum;
    }
    
    /**
     * @Return The price of a ticket.
             */
    
    public int getCharge()
    {
        return charge;
    }
    
        /**
     * @Return The location of a ticket.
             */
    public String getLocation()
    {
        return location;
    }
}
