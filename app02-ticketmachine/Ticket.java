
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
    
    public int highwycombeTicket()
    {
        location = "High Wycombe";
        charge = 330;
        System.out.println("High Wycombe ticket cost: " + charge);
        return charge;
    }
    
    public int amershamTicket()
    {
       location = "Amersham";
       charge = 300;
       System.out.println("Amersham ticket cost: " + charge);
       return charge;
    }
    
    public int aylseburyTicket()
    {
        location = "Aylsebury";
        charge = 200;
        System.out.println("Aylsebury ticket cost: " + charge);
        return charge;
    }
    
    /**
     * @Return The price of a ticket.
             */
    
    public int getCharge()
    {
        return charge;
    }
    
    public String getLocation()
    {
        return location;
    }
}
