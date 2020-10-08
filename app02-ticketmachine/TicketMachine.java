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
 
 public class TicketMachine 
    {
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // destination
    public Ticket destination;
    //date
    private Date today = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
            
    /**
    * Create a machine that issues tickets of the given price.
             */
    public TicketMachine(int cost)
    {
       
       price = cost;
       balance = 0;
       total = 0;
    }
            
    /**
     * @Return The price of a ticket.
             */
    public int getPrice()
    {
       return price;
    }
        
    /**
    * Return The amount of money already inserted for the
    * next ticket.
    */
    public int getBalance()
    {
       return balance;
    }
        
    /**
    * Receive an amount of money from a customer.
    * Check that the amount is sensible.
             */
    public void insertMoney(int amount)
       {
           if(amount == 10) 
                {
                   balance = balance + amount;
                   System.out.println("Total amount money inserted: " + balance);
                   total = price - balance;
                   System.out.println("Your current balance: " + total);
                   System.out.println("Your ticket price: " + price);
                }
                else  if (amount == 20)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = price - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + price);
                }
                else if (amount == 100)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = price - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + price);
                }
                 else if (amount == 200)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = price - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + price);
                    }
                    else 
                    {
                        System.out.println("You can only insert 10p, 20, £1.00 and £2.00 coins " + amount);
                    }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("# Your chosen destination: "  );
            System.out.println("# Ticket cost is: " + destination.getCharge());
            System.out.println("# Date ticket have been purchased: " + today);  
            System.out.println("##################");
           
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
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
