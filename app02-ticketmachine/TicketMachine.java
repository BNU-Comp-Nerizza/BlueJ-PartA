import java.util.Date;
import java.text.SimpleDateFormat;     
   /**
         * TicketMachine models a ticket machine that issues
         * flat-fare tickets.
         * The price of a ticket is specified via the constructor.
         * Instances will check to ensure that a user only enters
         * sensible amounts of money, and will only print a ticket
         * if enough money has been input.
         * 
         * @author David J. Barnes and Michael Kölling
         * @version 2016.02.29
         * 
         * Modified by Nerizza Flores
         * Date: 07/10/2020
         */
 
 public class TicketMachine extends Ticket
    {
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // The date the ticket was purchased
    private Date today = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
            
    /**
    * Create a machine that issues tickets*/
    public TicketMachine()
    {
       location = "unknown";
       price = charge;
       balance = 0;
       total = 0;
    }
        
    /**
     * @Return The price of a ticket.
             */
    public int getPrice()
    {
        return getCharge();
    }
    
        /**
     * @Return The price of a ticket.
             */
    public int getBalance()
    {
        return balance;
    }
      
    /**
    * Receive an amount of money from a customer.
    * Check that the amount is within the declared amount. */
    public void insertMoney(int amount)
       {
          if(amount == 10) 
                {
                   balance = balance + amount;
                   System.out.println("Total amount money inserted: " + balance);
                   total = charge - balance;
                   System.out.println("Your current balance: " + total);
                   System.out.println("Your ticket price: " + charge);
                }
                else  if (amount == 20)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = charge - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + charge);
                }
                else if (amount == 100)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = charge - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + charge);
                }
                 else if (amount == 200)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = charge - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + charge);
                    }
                    else 
                    {
                        System.out.println("You can only insert 10p, 20, £1.00 and £2.00 coins instead of " + amount + " p");
                    }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= charge) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# Your chosen destination: " + getLocation());
            System.out.println("# Ticket cost is: " + charge);
            System.out.println("# Date ticket have been purchased: " + today);  
            System.out.println("##################");
           
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (charge - balance) + " more cents.");
                    
        }
    }
    
        public void printAllTicket()
    {
            // Simulate the printing of all ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# Your chosen destination: High Wycombe & Aylsebury & Amersham");
            System.out.println("# Ticket cost is: " + AllTicket());
            System.out.println("# Date ticket have been purchased: " + today);  
            System.out.println("##################");
          
    }
    
    
    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
